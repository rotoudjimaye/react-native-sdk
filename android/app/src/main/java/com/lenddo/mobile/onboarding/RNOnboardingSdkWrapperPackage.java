package com.lenddo.mobile.onboarding;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import com.lenddo.mobile.onboardingsdk.utils.SignInHelper;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import com.lenddo.mobile.core.Log;
import java.util.Collections;

public class RNOnboardingSdkWrapperPackage implements ReactPackage {
    private static final String TAG = "RNOnboardingSdkWrapperPackage";
    private SignInHelper facebookSignInHelper;
    private SignInHelper googleSignInHelper;

    public void setFacebookSignInHelper(SignInHelper facebookSignInHelper) {
        this.facebookSignInHelper = facebookSignInHelper;
    }

    public void setGoogleSignInHelper(SignInHelper googleSignInHelper) {
        this.googleSignInHelper = googleSignInHelper;
    }

    public List<Class<? extends JavaScriptModule>> createJSModules() {
        return Collections.emptyList();
    }

    @Override
    public List<NativeModule> createNativeModules(
            ReactApplicationContext reactContext) {
        RNOnboardingSdkWrapper.initOnboardingSdkWrapper(reactContext);
        RNOnboardingSdkWrapper.getInstance().setFacebookSignInHelper(this.facebookSignInHelper);
        RNOnboardingSdkWrapper.getInstance().setGoogleSignInHelper(this.googleSignInHelper);

        RNFormDataCollector.initFormDataCollector(reactContext);

        List<NativeModule> modules = new ArrayList<>();
        modules.add(RNOnboardingSdkWrapper.getInstance());
        modules.add(RNFormDataCollector.getInstance());

        return modules;
    }

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        return Arrays.<ViewManager>asList();
    }

}
