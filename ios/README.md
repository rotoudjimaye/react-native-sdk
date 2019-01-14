
# IOS LenddoEFL Onboarding Sdk Wrapper (@lenddo/react-native-sdK)

## Getting started

`$ npm install @lenddo/react-native-sdk --save`

### Mostly automatic installation

`$ react-native link  @lenddo/react-native-sdk`

###Issue during installation
You might encounter auto-linking of ‘LenddoEFLSdk.framework’ file, as shown in the picture below



To manual link of @lenddo/react-native-sdk’s LenddoEFLSdk.framework
1. In Xcode, select the project, then select the main target (under "Targets"), then go to the "Build Settings" tab, and find the "Framework Search Paths" section. Add “../node_modules/@lenddo/react-native-sdk/ios/Frameworks” (non-recursive) for each of your configurations (e.g. Debug and Release).
2. Find the LenddoEFLSdk.framework file in “../node_modules/@lenddo/react-native-sdk/ios/Frameworks” and drag it into Xcode under the "Frameworks" section. In the dialog that pops up, uncheck "Copy items if needed", choose "Create groups", and ensure your main target is checked under "Add to targets".
3. In Xcode, select the project, then select the main target (under "Targets"), then go to the "General" tab and find the "Embedded Binaries" section. Click the "+" icon and select LenddoEFLSdk.framework which appears under "Frameworks" then click "Add".
4. In Xcode do "Product" -> "Clean".

### Manual installation

#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `@lenddo/react-native-sdk` and add `RNLenddoEFLLibrary.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNLenddoEFLLibrary.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

## Usage
```javascript
import {RNOnboardingSdkWrapperIOS} from '@lenddo/react-native-sdk';

// Call showAuthorizeWithFormData method to run LenddoEFL onboarding
if (Platform.OS === 'ios') {
	RNOnboardingSdkWrapperIOS.showAuthorizeWithFormData(this.state.formData, (error, events) => {
		if (error) {
			console.error(error);
		} else {
			console.log(JSON.stringify(events));
		}
	})
}
```
```formData``` is an model object that contain key-value variable to setup and initialize onboarding. You must copy-paste the object and add values on your app. You may delete some variables that you might not need and set it to there default values. There are few variables that are required and will be discussed further below.

```javascript
this.state = {
      formData: {
        authorizeApiGateway: 'https://authorize-api%@.lendqa.com',
        binApiGateway: 'https://bin-api%@.lendqa.com',
        partnerScriptId: '55e80b6caa9612375fe0a54f',
        secret: '',
        applicationId: 'asdasd231232ss312asda',
        region: '',
        installationId: '',
        enableKYC: false,
        enableDataCollection: false,

        firstName: '',
        middleName: '',
        lastName: '',

        email: '',
        workEmail: '',
        birthday: '',

        mobilePhone: '',
        homePhone: '',

        employerName: '',
        employmentStartDate: '',
        employmentEndDate: '',

        motherFirstName: '',
        motherLastName: '',
        motherMiddleName: '',

        addressLine1: '',
        addressLine2: '',
        city: '',
        administrativeDivision: '',
        countryCode: '',
        postalCode: '',

        workAddressLine1: '',
        workAddressLine2: '',
        workCity: '',
        workAdministrativeDivision: '',
        workCountryCode: '',
        workPostalCode: '',

        themeColor: '',

        enableAssistedPsychometrics: false,
        psychometricsApiGateway: ''
      },
    }
``` 

Applying theme color, you must create an object as shown below and assign it to formData.theme.

```javascript
class ThemeColor  {
  constructor(red, green, blue, alpha) {
    this.red = red;
    this.green = green;
    this.blue = blue;
    this.alpha = alpha;
  }
}

formData.theme = new ThemeColor(0x00, 0xff, 0x00, 1);
```

