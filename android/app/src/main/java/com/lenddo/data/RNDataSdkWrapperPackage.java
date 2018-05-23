package com.lenddo.data;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class RNDataSdkWrapperPackage implements ReactPackage {
  private List<String> partnerScriptIds, apiSecrets;

    public RNDataSdkWrapperPackage(List<String> partnerScriptIds, List<String> apiSecrets){
      this.partnerScriptIds = partnerScriptIds;
      this.apiSecrets = apiSecrets;
    }

    @Override
    public List<NativeModule> createNativeModules(
            ReactApplicationContext reactContext) {
        List<NativeModule> modules = new ArrayList<>();

        modules.add(new RNDataSdkWrapper(reactContext, partnerScriptIds, apiSecrets));

        return modules;
    }

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        return Arrays.<ViewManager>asList();
    }

}
