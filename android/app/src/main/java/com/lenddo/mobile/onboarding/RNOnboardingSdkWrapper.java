package com.lenddo.mobile.onboarding;


import android.text.TextUtils;

import android.app.Activity;
import android.content.Intent;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.ActivityEventListener;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.lenddo.mobile.core.LenddoCoreInfo;
import com.lenddo.mobile.core.Log;
import com.lenddo.mobile.onboardingsdk.client.LenddoEventListener;
import com.lenddo.mobile.onboardingsdk.client.LenddoConstants;
import com.lenddo.mobile.onboardingsdk.utils.UIHelper;
import com.lenddo.mobile.onboardingsdk.models.FormDataCollector;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.lenddo.mobile.onboardingsdk.utils.SignInHelper;

public class RNOnboardingSdkWrapper extends ReactContextBaseJavaModule implements ActivityEventListener{
    private static final String TAG = "RNOnboardingSdkWrapper";
    private static RNOnboardingSdkWrapper mInstance = null;
    private ReactApplicationContext reactContext;
    private UIHelper uiHelper;
    private String partnerScriptId;
    private String apiRegion;
    private boolean enableAssistedPsychometrics;
    private boolean enableNativeGoogle;
    private boolean enableNativeFacebook;
    private CustomBackPopup customBackPopup;
    private SignInHelper facebookSignInHelper;
    private SignInHelper googleSignInHelper;

    private static final int STARTED = 0;
    private static final int COMPLETE = 1;
    private static final int CANCELLED = 2;
    private static final int ERROR = 3;
    private static final int FAIL = 4;

    public static synchronized void initOnboardingSdkWrapper(ReactApplicationContext reactContext) {
        if (mInstance == null) {
            mInstance = new RNOnboardingSdkWrapper(reactContext);
        }
    }

    public static synchronized RNOnboardingSdkWrapper getInstance() {
        if (mInstance == null){ //if there is no instance available... create new one
            throw new NullPointerException("Call initOnboarding before calling getInstance");
        }
        return mInstance;
    }

    private RNOnboardingSdkWrapper(ReactApplicationContext reactContext) {
        super(reactContext);
        Log.d(TAG, "RNOnboardingSdkWrapper");
        this.reactContext = reactContext;
        this.customBackPopup = new CustomBackPopup();
        this.enableAssistedPsychometrics = false;
        this.enableNativeGoogle = false;
        this.enableNativeFacebook = false;
        this.apiRegion = "";
    }

    @ReactMethod
    public void setApiRegion(String apiRegion) {
        this.apiRegion = apiRegion;
    }

    @ReactMethod
    public void setAuthorizeApiEndpoint(String authorizeApiEndpoint) {
        if (!authorizeApiEndpoint.isEmpty()) {
            LenddoConstants.AUTHORIZE_DATA_ENDPOINT = authorizeApiEndpoint;
        }
    }

    @ReactMethod
    public void setEnableNativeGoogle(boolean enableNativeGoogle) {
        this.enableNativeGoogle = enableNativeGoogle;
    }

    @ReactMethod
    public void setEnableNativeFacebook(boolean enableNativeFacebook) {
        this.enableNativeFacebook = enableNativeFacebook;
    }

    @ReactMethod
    public void setEnableAssistedPsychometrics(boolean enableAssistedPsychometrics) {
        this.enableAssistedPsychometrics = enableAssistedPsychometrics;
    }

    public void setFacebookSignInHelper(SignInHelper facebookSignInHelper) {
        this.facebookSignInHelper = facebookSignInHelper;
    }

    public void setGoogleSignInHelper(SignInHelper googleSignInHelper) {
        this.googleSignInHelper = googleSignInHelper;
    }

    @ReactMethod
    public void customizeBackPopup(String title, String message, String okButtonLabel, String cancelButtonLabel) {
        this.customBackPopup.useCustomBackPopup = true;
        this.customBackPopup.title = title;
        this.customBackPopup.message = message;
        this.customBackPopup.okButtonLabel = okButtonLabel;
        this.customBackPopup.cancelButtonLabel = cancelButtonLabel;
    }

    @ReactMethod
    public void setPartnerScriptId(String partnerScriptId) {
        this.partnerScriptId = partnerScriptId;
        LenddoCoreInfo.setOnboardingPartnerScriptId(reactContext, this.partnerScriptId);
        Log.d(TAG, "setPartnerScriptId: " + partnerScriptId);
    }

    @ReactMethod
    public void getPartnerScriptId(Callback callback) {
        Log.d(TAG, "getPartnerScriptId: " + this.partnerScriptId);
        try {
            callback.invoke(this.partnerScriptId);
        } catch (Exception e) {
            Log.e(TAG, "Error: ", e);
        }
    }

    @ReactMethod
    public void startAuthorize() {
        this.uiHelper = new UIHelper(getCurrentActivity(),  new LenddoEventListener() {

            @Override
            public boolean onButtonClicked(FormDataCollector collector) {
                FormDataCollector formDataCollector = RNFormDataCollector.getInstance().getFormDataCollector();

                collector.setApplicationId(formDataCollector.getApplicationId());
                collector.setFirstName(formDataCollector.getFirstName());
                collector.setLastName(formDataCollector.getLastName());
                collector.setMiddleName(formDataCollector.getMiddleName());
                collector.setBirthDay(formDataCollector.getBirthDay());
                collector.setBirthMonth(formDataCollector.getBirthMonth());
                collector.setBirthYear(formDataCollector.getBirthYear());
                collector.setHomePhone(formDataCollector.getHomePhone());
                collector.setMobilePhone(formDataCollector.getMobilePhone());
                collector.setEmail(formDataCollector.getEmail());
                collector.setWorkEmail(formDataCollector.getWorkEmail());
                collector.setEmployerName(formDataCollector.getEmployerName());
                collector.setStartEmploymentDate(formDataCollector.getStartEmploymentDate());
                collector.setEndEmploymentDate(formDataCollector.getEndEmploymentDate());
                collector.setUniversityName(formDataCollector.getUniversityName());
                collector.setAddress(formDataCollector.getAddress());
                collector.setGovernmentIds(formDataCollector.getGovernmentIds());

                return true;
            }

            @Override
            public void onAuthorizeStarted(FormDataCollector collector) {
                WritableMap params = Arguments.createMap();
                params.putInt("action", STARTED);
                params.putInt("statusCode", 201);
                reactContext
                        .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                        .emit("onAuthorizeStarted", params);

            }

            @Override
            public void onAuthorizeComplete(FormDataCollector collector) {
                WritableMap params = Arguments.createMap();
                params.putInt("action", COMPLETE);
                params.putInt("statusCode", 200);
                reactContext
                        .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                        .emit("onAuthorizeComplete", params);
            }

            @Override
            public void onAuthorizeCanceled(FormDataCollector collector) {
                WritableMap params = Arguments.createMap();
                params.putInt("action", CANCELLED);
                params.putInt("statusCode", 300);
                reactContext
                        .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                        .emit("onAuthorizeCancelled", params);
            }

            @Override
            public void onAuthorizeError(int statusCode, String rawResponse) {
                WritableMap params = Arguments.createMap();
                params.putInt("action", ERROR);
                params.putString("status", rawResponse);
                params.putInt("statusCode", statusCode);
                reactContext
                        .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                        .emit("onAuthorizeError", params);
            }

            @Override
            public void onAuthorizeFailure(Throwable throwable) {
                WritableMap params = Arguments.createMap();
                params.putInt("action", FAIL);
                params.putString("status", throwable.getMessage());
                params.putInt("statusCode", 500);
                reactContext
                        .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                        .emit("onAuthorizeFailure", params);
            }
        });

        if (!this.apiRegion.isEmpty()) {
            this.uiHelper.setApiRegion(apiRegion);
        }

        if (this.enableNativeFacebook) {
            if(facebookSignInHelper != null) {
                this.uiHelper.addFacebookSignIn(facebookSignInHelper);
            }
        }

        if (this.enableNativeGoogle) {
            if(googleSignInHelper != null) {
                this.uiHelper.addGoogleSignIn(googleSignInHelper);
            }
        }

        if (this.enableAssistedPsychometrics) {
            this.uiHelper.setAssistedPsychometrics(true);
        }

        if (this.customBackPopup.useCustomBackPopup) {
            this.uiHelper.customizeBackPopup(this.customBackPopup.title, this.customBackPopup.message, this.customBackPopup.okButtonLabel, this.customBackPopup.cancelButtonLabel);
        }

        uiHelper.showAuthorize();
    }

    @ReactMethod
    public void onBackPressed() {
        getCurrentActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (uiHelper != null && uiHelper.onBackPressed()) {
                    getCurrentActivity().onBackPressed();
                }
            }
        });
    }

    /**
     * Called when host (activity/service) receives an {@link Activity#onActivityResult} call.
     */
    @Override
    public void onActivityResult(Activity activity, final int requestCode, final int resultCode, final Intent data) {
        getCurrentActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (uiHelper != null) {
                    uiHelper.onActivityResult(requestCode, resultCode, data);
                }
                else {
                    Log.e(TAG, "uiHelper is null, call setupHelper before startAuthorize.");
                }
            }
        });
    }

    /**
     * Called when a new intent is passed to the activity
     */
    @Override
    public void onNewIntent(Intent intent) {

    }

    @Override
    public String getName() {
        return "RNOnboardingSdkWrapper";
    }

    @java.lang.Override
    @ReactMethod
    public java.lang.String toString() {
        return "RNOnboardingSdkWrapper";
    }

    public static class CustomBackPopup {
        public boolean useCustomBackPopup;
        public String title;
        public String message;
        public String okButtonLabel;
        public String cancelButtonLabel;

        public CustomBackPopup() {
            this.useCustomBackPopup = false;
        }
    }
}
