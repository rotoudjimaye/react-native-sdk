Table of Contents
=================
<!-- TOC -->
- [0.1. Lenddo React-Native Demo App](#01-lenddo-react-native-demo-app)
- [0.2. Pre-requisites](#02-pre-requisites)
- [0.3. To run Sample App](#03-to-run-sample-app)
    - [0.3.1. Installing nodejs dependecies for Sample App](#031-installing-nodejs-dependecies-for-sample-app)
- [0.4. Data SDK implementation instruction](#04-data-sdk-implementation-instruction)
    - [0.4.1. Adding Lenddo react-native-sdk into your react-native dependencies](#041-adding-lenddo-react-native-sdk-into-your-react-native-dependencies)
    - [0.4.2. Gradle setup](#042-gradle-setup)
    - [0.4.3. Required Permissions](#043-required-permissions)
    - [0.4.4. Required gradle declaration](#044-required-gradle-declaration)
    - [0.4.5. Initializing React-Native Lenddo Data SDK](#045-initializing-react-native-lenddo-data-sdk)
    - [0.4.6. Register native module in Application class in your android project](#046-register-native-module-in-application-class-in-your-android-project)
    - [0.4.7. Setting Partner Script Id](#047-setting-partner-script-id)
    - [0.4.8. Registering data gathering callback](#048-registering-data-gathering-callback)
        - [0.4.8.1. Capturing callback via EventEmitter](#0481-capturing-callback-via-eventemitter)
- [0.5. Onboarding SDK implementation instruction](#05-onboarding-sdk-implementation-instruction)
    - [0.5.1. Adding Lenddo react-native-sdk into your react-native dependencies](#051-adding-lenddo-react-native-sdk-into-your-react-native-dependencies)
    - [0.5.2. Gradle setup](#052-gradle-setup)
    - [0.5.3. Required Permissions](#053-required-permissions)
    - [0.5.4. Required gradle declaration](#054-required-gradle-declaration)
    - [0.5.5. Initializing React-Native Lenddo Onboarding SDK](#055-initializing-react-native-lenddo-onboarding-sdk)
    - [0.5.6. Register native module in Application class in your android project](#056-register-native-module-in-application-class-in-your-android-project)
    - [0.5.7. Setting Partner Script Id](#057-setting-partner-script-id)
    - [0.5.8. Registering onboarding callback](#058-registering-onboarding-callback)
    - [0.5.9. Additional yet optional onboarding setup](#059-additional-yet-optional-onboarding-setup)
        - [0.5.9.1. Setup endpoint and back popup dialog](#0591-setup-endpoint-and-back-popup-dialog)
        - [0.5.9.2. Adding native email signin and facebook login(optional)](#0592-adding-native-email-signin-and-facebook-loginoptional)
            - [0.5.9.2.1. Include GoogleSignInHelper and FacebookSignInHelper into your wrapper package](#05921-include-googlesigninhelper-and-facebooksigninhelper-into-your-wrapper-package)
            - [0.5.9.2.2. Enabling using Gmail SignIn and Facebook Login in App.js](#05922-enabling-using-gmail-signin-and-facebook-login-in-appjs)
<!-- /TOC -->

## 0.1. Lenddo React-Native Demo App

An android sample app to demonstrate react-native Lenddo data sdk that allows you to collect information in order for Lenddo to verify the user's information and enhance its scoring capabilities. And with implementation instruction for new react-native application. You can check the demo application from this [link](https://github.com/Lenddo/react-native-sdk-sample-app) for more information regarding the implementaion stated below.

## 0.2. Pre-requisites

Before incorporating the React-Native Data SDK into your app, you should be provided with the following information:

* Partner Script ID

Please ask for the information above from your Lenddo representative. If you have a dashboard account, these values can also be found there.

There may be also other partner specific values that you are required to set.

## 0.3. To run Sample App

* Update `index.android.bundle` whenever you modify your code in `App.js`

```bash
react-native bundle --platform android --dev false --entry-file index.js --bundle-output android/app/src/main/assets/index.android.bundle --assets-dest android/app/src/main/res
```
*  Make sure an emulator is running or a device is connected

```bash
react-native run-android
```

### 0.3.1. Installing nodejs dependecies for Sample App

```bash
npm install @lenddo/react-native-sdk --save
npm install react-native-check-box --save
npm install react-native-material-textfield --save
npm install react-native-tab-view --save
npm install react-native-gesture-handler --save
```

## 0.4. Data SDK implementation instruction

### 0.4.1. Adding Lenddo react-native-sdk into your react-native dependencies

```bash
npm install @lenddo/react-native-sdk --save
```

### 0.4.2. Gradle setup

* In `android/setting.gradle`

```gradle
...

include ':app', ':react-native-sdk'
project(':react-native-sdk').projectDir = new File(rootProject.projectDir, '../node_modules/@lenddo/react-native-sdk/android/app')
```

* In `android/app/build.gradle`

```gradle
...
dependencies {
    ...
    compile project(':react-native-sdk')
}
```

### 0.4.3. Required Permissions
React-Native Data Sdk will use information stored on the users' android phone. It is advisable for all permissions to be added to your app to enable LenddoData to extract the necessary information for verification and scoring. The optimal permissions are already defined for you in the Libraries’ AndroidManifest.xml and are automatically added to your app using gradle when you rebuild the app after adding our SDK.

Below is the list of required permissions.
```xml
    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
    <uses-permission android:name="android.permission.READ_PHONE_STATE" />
    <uses-permission android:name="android.permission.READ_CONTACTS" />
    <uses-permission android:name="android.permission.READ_CALENDAR" />
    <uses-permission android:name="com.android.browser.permission.READ_HISTORY_BOOKMARKS" />
    <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
    <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
    <uses-permission android:name="android.permission.RECEIVE_BOOT_COMPLETED" />
    <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
```
If you do not want the all default permissions added, you manually have to remove permissions by editing the lenddosdk/src/main/AndroidManifest.xml and comment out permissions you do not wish to grant, however please note that the following permissions at the minimum are required for the operation of the SDK and should NOT be removed:

```xml
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
<uses-permission android:name="android.permission.READ_PHONE_STATE" />
```
It is also important that these permissions are consistent with the privacy policy of your app.

### 0.4.4. Required gradle declaration
In your app-level build.gradle file, it is a good practice to set/ use targetSdkVersion, compileSdkVersion and buildToolsVersion of api 26:
```gradle
apply plugin: 'com.android.application'

android {
    compileSdkVersion 26
    buildToolsVersion "26.0.2"

    defaultConfig {
        applicationId "com.your.reverse.domain.sample-app"
        minSdkVersion 16
        targetSdkVersion 26
        versionCode 1
        versionName "1.0.0"
        multiDexEnabled true
        ndk {
            abiFilters "armeabi-v7a", "x86"
        }
    }
}
```
In your top-level build.gradle file, make sure to include kotlin dependency (It is required by the sdk).

```
buildscript {
    ext.kotlin_version = '1.2.10'
    repositories {
        google()
        jcenter()
        maven { url 'https://maven.google.com' }
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:3.0.1'
        classpath 'com.google.gms:google-services:4.0.1'
        classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}
```

### 0.4.5. Initializing React-Native Lenddo Data SDK
In your Application class initialize Lenddo core info as shown below (Lenddo React-Native Demo app).

```java
package lenddo.com.lenddoconnect;

import com.lenddo.mobile.core.LenddoCoreInfo; // Required import
import com.lenddo.mobile.datasdk.AndroidData; // Required import
import com.lenddo.mobile.datasdk.models.ClientOptions; // Required import

// ... other imports

public class MainApplication extends Application implements ReactApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        LenddoCoreInfo.initCoreInfo(getApplicationContext());  // Init core info

        // Setup data gathering with client options which are data settings (can be over written via RNDataSdkWrapper's setupWithClientOptions method on your App.js  (pleaser refer to RNDataSDKDemo))
        ClientOptions clientOptions = new ClientOptions();
        clientOptions.enableLogDisplay(true);

        AndroidData.setup(getApplicationContext(), clientOptions);

        // ... Or use the below to have a default client options
        // AndroidData.setup(getApplicationContext());
    }

    // ... Some codes
}

```

### 0.4.6. Register native module in Application class in your android project

```java
package lenddo.com.lenddoconnect;

import com.lenddo.mobile.data.RNDataSdkWrapperPackage; // << import react-module package
// ... other imports

public class MainApplication extends Application implements ReactApplication {

    private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {
        @Override
        public boolean getUseDeveloperSupport() {
            return BuildConfig.DEBUG;
        }

        @Override
        protected List<ReactPackage> getPackages() {
            return Arrays.<ReactPackage>asList(
                    new MainReactPackage(),
                    new RNCollapsingToolbarPackage(),
                    new RNNestedScrollViewPackage(),
                    new RNDataSdkWrapperPackage() //<--- Add wrapper package here
            );
        }

        @Override
        protected String getJSMainModuleName() {
            return "index";
        }
    };

    @Override
    public ReactNativeHost getReactNativeHost() {
        return mReactNativeHost;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        SoLoader.init(this, /* native exopackage */ false);

        LenddoCoreInfo.initCoreInfo(getApplicationContext());
        AndroidData.setup(getApplicationContext());
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

}

```
### 0.4.7. Setting Partner Script Id
On your App.js, setup Partner Script Id dynamically via RNDataSdkWrapper's ```setPartnerScriptId``` method. **And make sure to setup your Partner Script Id before calling RNDataSdkWrapper's** ```startAndroidData``` **method.**

```javascript
    RNDataSdkWrapper.setPartnerScriptId(this.state.scoring.partnerScriptId);
```

### 0.4.8. Registering data gathering callback
On your App.js, setup Lenddo sdk with callback to capture response from gathering of data and sending data into our api. You should call RNDataSdkWrapper's ```setupWithCallback``` before ```startAndroidData```. As shown in Lenddo React-Native Demo app.

```javascript
import { RNDataSdkWrapper , RNClientOptions } from '@lenddo/react-native-sdk';

export default class RNDataSDKDemo extends PureComponent {
    // Other method description

    startAndroidData() {
        RNDataSdkWrapper.setupWithCallback(
            (result, logMsg, statusCode) => {console.log('result: ' + result);
                console.log('logMsg: ' + logMsg);
                console.log('statusCode: ' + statusCode);

                this.setState({dataSendingCallback: logMsg});
                RNDataSdkWrapper.statisticsEnabled(
                (statisticsEnabled) => {
                    if(statisticsEnabled){
                        this.setState({startDataText : 'STOP&CLEAR DATA SDK'})
                    } else{
                        this.setState({startDataText: 'START LENDDO DATA SDK'})
                    }
                });
            });
        RNDataSdkWrapper.startAndroidData(this.state.scoring.applicationId);
    }

```

Other setup method available are ```setupWithClientOptions``` and the default ```setup``` method (please refer to the Lenddo React-Native Demo app)

Note whenever you desire to use ```setupWithClientOptions``` and ```setupWithCallback``` at the same time, make sure you call ```setupWithClientOptions``` first. And also to make sure to call setup methods just once.

#### 0.4.8.1. Capturing callback via EventEmitter
You can also use EventEmitter for capturing datasdk callbacks, by just using React-Native Callback class it only captures: **success**, **error** and **failed** state, it does not include **start** state. Refer to the source code below.

```javascript
  componentWillMount() {
    DeviceEventEmitter.addListener('onDataSendingStart',(params) => {
            console.log("onDataSendingStart")
            console.log(params)
            if (params.method == 'registerDataSendingCompletionCallback') {
                // do something when data collection stared
            }
        }
    )
    DeviceEventEmitter.addListener('onDataSendingSuccess',(params) => {
            console.log("onDataSendingSuccess")
            console.log(params)
        }
    )
    DeviceEventEmitter.addListener('onDataSendingError',(params) => {
            console.log("onDataSendingError")
            console.log(params)
        }
    )
    DeviceEventEmitter.addListener('onDataSendingFailed',(params) => {
            console.log("onDataSendingFailed")
            console.log(params)
        }
    )
  }
```

## 0.5. Onboarding SDK implementation instruction

### 0.5.1. Adding Lenddo react-native-sdk into your react-native dependencies

```bash
npm install @lenddo/react-native-sdk --save
```

### 0.5.2. Gradle setup

* In `android/setting.gradle`

```gradle
...

include ':app', ':react-native-sdk'
project(':react-native-sdk').projectDir = new File(rootProject.projectDir, '../node_modules/@lenddo/react-native-sdk/android/app')
```

* In `android/app/build.gradle`

```gradle
...
dependencies {
    ...
    compile project(':react-native-sdk')
}
```

### 0.5.3. Required Permissions
React-Native Onboarding Sdk will require internet access and an **optional** camera access that is required for only psychometics and assisted enable.

```xml
    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.CAMERA" />
```

### 0.5.4. Required gradle declaration
In your app-level build.gradle file, it is a good practice to set/ use targetSdkVersion, compileSdkVersion and buildToolsVersion of api 26:
```gradle
apply plugin: 'com.android.application'

android {
    compileSdkVersion 26
    buildToolsVersion "26.0.2"

    defaultConfig {
        applicationId "com.your.reverse.domain.sample-app"
        minSdkVersion 16
        targetSdkVersion 26
        versionCode 1
        versionName "1.0.0"
        multiDexEnabled true
        ndk {
            abiFilters "armeabi-v7a", "x86"
        }
    }
}
```

### 0.5.5. Initializing React-Native Lenddo Onboarding SDK
In your Application class initialize Lenddo core info as shown below (Lenddo React-Native Demo app).

```java
package lenddo.com.lenddoconnect;

import com.lenddo.mobile.core.LenddoCoreInfo; // Required import
import com.lenddo.mobile.datasdk.AndroidData; // Required import
import com.lenddo.mobile.datasdk.models.ClientOptions; // Required import

// ... other imports

public class MainApplication extends Application implements ReactApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        LenddoCoreInfo.initCoreInfo(getApplicationContext());  // Init core info


        AndroidData.setup(getApplicationContext());

        // ... Or use the below to have an alternative client options
        /*
        // Setup data gathering with client options which are data settings (can be over written via RNDataSdkWrapper's setupWithClientOptions method on your App.js  (pleaser refer to RNDataSDKDemo))
        ClientOptions clientOptions = new ClientOptions();
        clientOptions.enableLogDisplay(true);

        AndroidData.setup(getApplicationContext(), clientOptions);
        */
         
    }

    // ... Some codes
}

```

### 0.5.6. Register native module in Application class in your android project

```java
package lenddo.com.lenddoconnect;

import com.lenddo.mobile.onboarding.RNOnboardingSdkWrapperPackage; // << import react-module package
// ... other imports

public class MainApplication extends Application implements ReactApplication {

    private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {
        @Override
        public boolean getUseDeveloperSupport() {
            return BuildConfig.DEBUG;
        }

        @Override
        protected List<ReactPackage> getPackages() {
            RNOnboardingSdkWrapperPackage rnOnboardingSdkWrapperPackage = new RNOnboardingSdkWrapperPackage();
            // rnOnboardingSdkWrapperPackage.setGoogleSignInHelper(new GoogleSignInHelper()); // Optional for native gmail sign-in
            // rnOnboardingSdkWrapperPackage.setFacebookSignInHelper(new FacebookSignInHelper()); // Optional for native facebook login

            return Arrays.<ReactPackage>asList(
                    new MainReactPackage(),
                    new RNCollapsingToolbarPackage(),
                    new RNNestedScrollViewPackage(),
                    rnOnboardingSdkWrapperPackage //<--- Add wrapper package here
            );
        }

        @Override
        protected String getJSMainModuleName() {
            return "index";
        }
    };

    @Override
    public ReactNativeHost getReactNativeHost() {
        return mReactNativeHost;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        SoLoader.init(this, /* native exopackage */ false);

        LenddoCoreInfo.initCoreInfo(getApplicationContext());
        AndroidData.setup(getApplicationContext());
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

}

```
### 0.5.7. Setting Partner Script Id
On your App.js, setup Partner Script Id dynamically via RNOnboardingSdkWrapper's ```setPartnerScriptId``` method. **And make sure to setup your Partner Script Id before calling RNOnboardingSdkWrapper's** ```startAuthorize``` **method.**

```javascript
    RNOnboardingSdkWrapper.setPartnerScriptId(this.state.formData.partnerScriptId);
```

### 0.5.8. Registering onboarding callback
On your App.js, setup Lenddo onboarding sdk with callback to capture response from your startAuthorize call, by using RTCDeviceEventEmitter to capture onboarding progress and listen to WebView's backpress.  As shown in Lenddo React-Native Demo app.

```javascript
import { RNOnboardingSdkWrapper, RNFormDataCollector} from '@lenddo/react-native-sdk';

export default class RNDataSDKDemo extends PureComponent {
    // Other method description

componentDidMount() {
    BackHandler.addEventListener('hardwareBackPress', this.handleBackPress);
}

componentWillUnmount() {
    BackHandler.removeEventListener('hardwareBackPress', this.handleBackPress);
}

componentWillMount() {
    DeviceEventEmitter.addListener('onAuthorizeStarted',(params) => {
        // Do any source code before lenddo onboarding start.
        console.log("onAuthorizeStarted")
        console.log(params)
        }
    )
    DeviceEventEmitter.addListener('onAuthorizeComplete',(params) => {
            console.log("onAuthorizeComplete")
            console.log(params)
        }
    )
    DeviceEventEmitter.addListener('onAuthorizeCanceled',(params) => {
            console.log("onAuthorizeCanceled")
            console.log(params)
        }
    )
    DeviceEventEmitter.addListener('onAuthorizeError',(params) => {
            console.log("onAuthorizeError")
            console.log(params)
        }
    )
    DeviceEventEmitter.addListener('onAuthorizeFailure',(params) => {
        console.log("onAuthorizeFailure")
        console.log(params)
        }
    )
}


handleBackPress = () => {
    RNOnboardingSdkWrapper.onBackPressed()
    return true;
}

onPressStartOnboarding() {
    /* Probe Data
    setApplicationId
    setFirstName
    setLastName
    setMiddleName
    setHomePhone
    setMobilePhone
    setEmail
    setWorkEmail
    setDateOfBirth - dd/MM
    setStartEmploymentDate
    setEndEmploymentDate
    setUniversityName
    putField
    addGovernmentId
    setGovernmentIds
    setAddress
    */
    RNFormDataCollector.refreshFormDataCollector()
    RNFormDataCollector.setApplicationId(this.state.formData.applicationId)
    RNFormDataCollector.setFirstName(this.state.formData.firstName)
    RNFormDataCollector.setMiddleName(this.state.formData.middleName)
    RNFormDataCollector.setLastName(this.state.formData.lastName)

    RNOnboardingSdkWrapper.setPartnerScriptId(this.state.formData.partnerScriptId)
    RNOnboardingSdkWrapper.startAuthorize()
}
```
### 0.5.9. Additional yet optional onboarding setup
On your App.js, setup Lenddo onboarding sdk with additional options to be use.

#### 0.5.9.1. Setup endpoint and back popup dialog
You can customize endpoint and back popup dialog via sample code snippet below

```javascript

    RNOnboardingSdkWrapper.setAuthorizeApiEndpoint('https://authorize-api%s.partner-service.link')
    RNOnboardingSdkWrapper.setApiRegion('kr')
    RNOnboardingSdkWrapper.customizeBackPopup('Title', 'Message', 'OK', 'Cancel')
```

#### 0.5.9.2. Adding native email signin and facebook login(optional)
If your work flow includes email signin and facebook login, you can use native application for this feature.

##### 0.5.9.2.1. Include GoogleSignInHelper and FacebookSignInHelper into your wrapper package
```java
public class MainApplication extends Application implements ReactApplication {

    private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {
        @Override
        public boolean getUseDeveloperSupport() {
            return BuildConfig.DEBUG;
        }

        @Override
        protected List<ReactPackage> getPackages() {
            // Add native Gmail SignIn and Facebook Login
            RNOnboardingSdkWrapperPackage rnOnboardingSdkWrapperPackage = new RNOnboardingSdkWrapperPackage();
            rnOnboardingSdkWrapperPackage.setGoogleSignInHelper(new GoogleSignInHelper()); 
            rnOnboardingSdkWrapperPackage.setFacebookSignInHelper(new FacebookSignInHelper());

            return Arrays.<ReactPackage>asList(
                    new MainReactPackage(),
                    new RNCollapsingToolbarPackage(),
                    new RNNestedScrollViewPackage(),
                    rnOnboardingSdkWrapperPackage,
                    new RNDataSdkWrapperPackage()
            );
        }

        @Override
        protected String getJSMainModuleName() {
            return "index";
        }
    };
}
```

##### 0.5.9.2.2. Enabling using Gmail SignIn and Facebook Login in App.js
After adding the signin helper class, enable the use of this via code snippet below

```javascript

    RNOnboardingSdkWrapper.setEnableNativeFacebook(true)
    RNOnboardingSdkWrapper.setEnableNativeGoogle(true)
 
```