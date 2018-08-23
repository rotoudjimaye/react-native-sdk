package com.lenddo.mobile.onboarding;


import android.text.TextUtils;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.UiThreadUtil;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.lenddo.mobile.core.models.GovernmentId;
import com.lenddo.mobile.core.models.VerificationData;
import com.lenddo.mobile.onboardingsdk.models.FormDataCollector;
import com.lenddo.mobile.core.LenddoCoreInfo;
import com.lenddo.mobile.core.Log;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;


public class RNFormDataCollector extends ReactContextBaseJavaModule {
    private static final String TAG = "RNFormDataCollector";
    private static RNFormDataCollector mInstance = null;
    private Callback callback;
    private FormDataCollector formDataCollector;
    private List<GovernmentId> governmentIds;

    public static synchronized void initFormDataCollector(ReactApplicationContext reactContext) {
        if (mInstance == null) {
            mInstance = new RNFormDataCollector(reactContext);
        }
    }

    public static synchronized RNFormDataCollector getInstance() {
        if (mInstance == null){ //if there is no instance available... create new one
            throw new NullPointerException("Call initFormDataCollector before calling getInstance");
        }
        return mInstance;
    }

    public RNFormDataCollector(ReactApplicationContext reactContext) {
        super(reactContext);

        Log.d(TAG, "RNFormDataCollector");
        this.formDataCollector = new FormDataCollector();
        this.governmentIds = new ArrayList<>();
    }

    public FormDataCollector getFormDataCollector() {
        return formDataCollector;
    }

    @Override
    public String getName() {
        return "RNFormDataCollector";
    }

    @ReactMethod
    public void refreshFormDataCollector() {
        this.formDataCollector = new FormDataCollector();
        this.governmentIds.clear();
    }

    @ReactMethod
    public void setApplicationId(String applicationId) {
        this.formDataCollector.setApplicationId(applicationId);
    }

    @ReactMethod
    public void setFirstName(String firstName) {
        this.formDataCollector.setFirstName(firstName);
    }

    @ReactMethod
    public void setLastName(String lastName) {
        this.formDataCollector.setLastName(lastName);
    }

    @ReactMethod
    public void setMiddleName(String middleName) {
        this.formDataCollector.setMiddleName(middleName);
    }

    @ReactMethod
    public void setHomePhone(String homePhone) {
        this.formDataCollector.setHomePhone(homePhone);
    }

    @ReactMethod
    public void setMobilePhone(String mobilePhone) {
        this.formDataCollector.setMobilePhone(mobilePhone);
    }

    @ReactMethod
    public void setEmail(String email) {
        this.formDataCollector.setEmail(email);
    }

    @ReactMethod
    public void setWorkEmail(String email) {
        this.formDataCollector.setWorkEmail(email);
    }

    @ReactMethod
    public void setEmployerName(String employerName) {
        this.formDataCollector.setEmployerName(employerName);
    }

    @ReactMethod
    public void setDateOfBirth(String dateOfBirth) {
        // Add format checker
        this.formDataCollector.setDateOfBirth(dateOfBirth);
    }

    @ReactMethod
    public void setStartEmploymentDate(String startEmploymentDate) {
        // Add format checker
        this.formDataCollector.setStartEmploymentDate(startEmploymentDate);
    }

    @ReactMethod
    public void setEndEmploymentDate(String endEmploymentDate) {
        // Add format checker
        this.formDataCollector.setEndEmploymentDate(endEmploymentDate);
    }

    @ReactMethod
    public void setUniversityName(String universityName) {
        this.formDataCollector.setUniversityName(universityName);
    }

    @ReactMethod
    public void putField(String key, String values) {
        this.formDataCollector.putField(key, values);
    }

    @ReactMethod
    public void addGovernmentId(String type, String values) {
        this.governmentIds.add(new GovernmentId(type, values));
    }

    @ReactMethod
    public void setGovernmentIds() {
        this.formDataCollector.setGovernmentIds(this.governmentIds);
    }

    @ReactMethod
    public void setAddress(String line_1, String line_2, String city, String administrative_division,
                           String country_code, String postal_code, double latitude, double longitude) {
        VerificationData.Address primaryAddress = new VerificationData.Address();
        primaryAddress.line_1 = line_1;
        primaryAddress.line_2 = line_2;
        primaryAddress.city = city;
        primaryAddress.administrative_division = administrative_division;
        primaryAddress.postal_code = postal_code;
        primaryAddress.country_code = country_code;
        primaryAddress.latitude = latitude;
        primaryAddress.longitude = longitude;

        this.formDataCollector.setAddress(primaryAddress);
    }

    @java.lang.Override
    @ReactMethod
    public java.lang.String toString() {
        return "RNFormDataCollector";
    }
}
