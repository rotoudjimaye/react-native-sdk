package com.lenddo.mobile.data;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import com.lenddo.mobile.core.Log;
import java.util.Collections;

public class RNDataSdkWrapperPackage implements ReactPackage {
    private static final String TAG = "RNDataSdkWrapperPackage";

    public List<Class<? extends JavaScriptModule>> createJSModules() {
        return Collections.emptyList();
    }

    @Override
    public List<NativeModule> createNativeModules(
            ReactApplicationContext reactContext) {

        RNClientOptions.initClientOptions(reactContext);

        List<NativeModule> modules = new ArrayList<>();
        modules.add(new RNDataSdkWrapper(reactContext));
        modules.add(RNClientOptions.getInstance());

        return modules;
    }

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        return Arrays.<ViewManager>asList();
    }

}
