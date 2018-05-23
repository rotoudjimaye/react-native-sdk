package com.lenddo.data;


import android.text.TextUtils;
import android.util.Log;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.UiThreadUtil;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.lenddo.mobile.datasdk.AndroidData;
import com.lenddo.mobile.datasdk.listeners.OnDataSendingCompleteCallback;
import com.lenddo.mobile.datasdk.models.ApplicationPartnerData;
import com.lenddo.mobile.datasdk.models.ClientOptions;
import com.lenddo.mobile.datasdk.utils.AndroidDataUtils;
import com.lenddo.mobile.core.LenddoCoreInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class RNClientOptions extends ReactContextBaseJavaModule {
    private Callback callback;
    private ClientOptions clientOptions;
    
    public RNClientOptions(ReactApplicationContext reactContext) {
        super(reactContext);

        Log.d(TAG, "RNClientOptions");
        this.clientOptions = new ClientOptions();
    }

    @ReactMethod
    public void getClientOptions() {
        return this.clientOptions;
    }

    @ReactMethod
    public void setReactNativeCallback(Callback callback) {
        this.callback = callback;
    }

    @ReactMethod
    public Callback getReactNativeCallback() {
        return this.callback;
    }

    @ReactMethod
    public void setCustomMPermissionLayout(int intro, int rationale, int feedback, int thankyou) {
        this.clientOptions.setCustomMPermissionLayout(intro, rationale, feedback, thankyou);
    }

    @ReactMethod
    public int[] getCustomMPermissionLayout() {
        return this.clientOptions.getCustomMPermissionLayout();
    }

    @ReactMethod
    public boolean isCustomMPermission() {
        return this.clientOptions.isCustomMPermission();
    }

    @ReactMethod
    public String getPartnerId() {
        return this.clientOptions.getPartnerId();
    }

    @ReactMethod
    public void setPartnerId(String partnerId) {
        this.clientOptions.setPartnerId(partnerId);
    }

    @ReactMethod
    public boolean isWifiOnly() {
        return this.clientOptions.isWifiOnly();
    }

    @ReactMethod
    public void setWifiOnly(boolean wifiOnly) {
        this.clientOptions.setWifiOnly(wifiOnly);
    }

    @ReactMethod
    public void setPartnerScriptId(String partnerScriptId) {
        this.clientOptions.setPartnerScriptId(partnerScriptId);
    }

    @ReactMethod
    public String getPartnerScriptId() {
        return this.clientOptions.getPartnerScriptId();
    }

    @ReactMethod
    public void setThemeColor(String color) {
        this.clientOptions.setThemeColor(color);
    }

    @ReactMethod
    public int getThemeColor() {
        return this.clientOptions.getThemeColor();
    }

    @ReactMethod
    public void disableSMSDataCollection() {
        this.clientOptions.disableSMSDataCollection();
    }

    @ReactMethod
    public void disableCallLogDataCollection() {
        this.clientOptions.disableCallLogDataCollection();
    }

    @ReactMethod
    public void disableContactDataCollection() {
        this.clientOptions.disableContactDataCollection();
    }

    @ReactMethod
    public void disableCalendarEventDataCollection() {
        this.clientOptions.disableCalendarEventDataCollection();
    }

    @ReactMethod
    public void disableInstalledAppDataCollection() {
        this.clientOptions.disableInstalledAppDataCollection();
    }

    @ReactMethod
    public void disableBrowserHistoryDataCollection() {
        this.clientOptions.disableBrowserHistoryDataCollection();
    }

    @ReactMethod
    public void disableLocationDataCollection() {
        this.clientOptions.disableLocationDataCollection();
    }

    @ReactMethod
    public void disableBattChargeDataCollection() {
        this.clientOptions.disableBattChargeDataCollection();
    }

    @ReactMethod
    public void disableGalleryMetaDataCollection() {
        this.clientOptions.disableGalleryMetaDataCollection();
    }

    @ReactMethod
    public void disableMediaMetaDataCollection() {
        this.clientOptions.disableMediaMetaDataCollection();
    }

    @ReactMethod
    public void disableSMSBodyCollection() {
        this.clientOptions.disableSMSBodyCollection();
    }

    @ReactMethod
    public void enablePhoneNumberHashing() {
        this.clientOptions.enablePhoneNumberHashing();
    }

    @ReactMethod
    public void enableContactsNameHashing() {
        this.clientOptions.enableContactsNameHashing();
    }

    @ReactMethod
    public void enableContactsEmailHashing() {
        this.clientOptions.enableContactsEmailHashing();
    }

    @ReactMethod
    public void enableCalendarOrganizerHashing() {
        this.clientOptions.enableCalendarOrganizerHashing();
    }

    @ReactMethod
    public void enableCalendarDisplayNameHashing() {
        this.clientOptions.enableCalendarDisplayNameHashing();
    }

    @ReactMethod
    public void enableCalendarEmailHashing() {
        this.clientOptions.enableCalendarEmailHashing();
    }

    @ReactMethod
    public boolean isEnableSMS() {
        return this.clientOptions.isEnableSMS();
    }

    @ReactMethod
    public boolean isEnableCallLog() {
        return this.clientOptions.isEnableCallLog();
    }

    @ReactMethod
    public boolean isEnableContact() {
        return this.clientOptions.isEnableContact();
    }

    @ReactMethod
    public boolean isEnableCalendarEvent() {
        return this.clientOptions.isEnableCalendarEvent();
    }

    @ReactMethod
    public boolean isEnableInstalledApp() {
        return this.clientOptions.isEnableInstalledApp();
    }

    @ReactMethod
    public boolean isEnableBrowserHistory() {
        return this.clientOptions.isEnableBrowserHistory();
    }

    @ReactMethod
    public boolean isEnableLocation() {
        return this.clientOptions.isEnableLocation();
    }

    @ReactMethod
    public boolean isEnableBatteryCharge() {
        return this.clientOptions.isEnableBatteryCharge();
    }

    @ReactMethod
    public boolean isEnableGalleryMetaData() {
        return this.clientOptions.isEnableGalleryMetaData();
    }

    @ReactMethod
    public boolean isEnableMediaMetaData() {
        return this.clientOptions.isEnableMediaMetaData();
    }

    @ReactMethod
    public boolean isEnableSMSBody() {
        return this.clientOptions.isEnableSMSBody();
    }

    @ReactMethod
    public boolean isEnablePhoneNumberHashing() {
        return this.clientOptions.isEnablePhoneNumberHashing();
    }

    @ReactMethod
    public boolean isEnableContactsNameHashing() {
        return this.clientOptions.isEnableContactsNameHashing();
    }

    @ReactMethod
    public boolean isEnableContactsEmailHashing() {
        return this.clientOptions.isEnableContactsEmailHashing();
    }

    @ReactMethod
    public boolean isEnableCalendarOrganizerHashing() {
        return this.clientOptions.isEnableCalendarOrganizerHashing();
    }

    @ReactMethod
    public boolean isEnableCalendarDisplayNameHashing() {
        return this.clientOptions.isEnableCalendarDisplayNameHashing();
    }

    @ReactMethod
    public boolean isEnableCalendarEmailHashing() {
        return this.clientOptions.isEnableCalendarEmailHashing();
    }

    @ReactMethod
    public void setApiGatewayUrl(String endPoint) {
        this.clientOptions.setApiGatewayUrl(endPoint);
    }

    @ReactMethod
    public void enableLogDisplay(boolean isEnable) {
        this.clientOptions.enableLogDisplay(isEnable);
    }

    @java.lang.Override
    @ReactMethod
    public java.lang.String toString() {
        return "RNClientOptions";
    }
}
