
#import "RNOnboardingSdkWrapperIOS.h"

@implementation RNOnboardingSdkWrapperIOS

static NSArray *providers;

- (dispatch_queue_t)methodQueue {
    return dispatch_get_main_queue();
}
RCT_EXPORT_MODULE();

RCT_EXPORT_METHOD(addEvent:(NSString *)name location:(NSString *)location) {
    RCTLogInfo(@"Pretending to create an event %@ at %@", name, location);
}

RCT_EXPORT_METHOD(showAuthorize:(NSDictionary *) formDataDictionary callback:(RCTResponseSenderBlock)callback) {
    NSString* partnerScriptId = [formDataDictionary objectForKey:@"partnerScriptId"];
    NSString* secret = [formDataDictionary objectForKey:@"secret"];
    NSString* authorizeApiGateway = [formDataDictionary objectForKey:@"authorizeApiGateway"];
    NSString* region = [formDataDictionary objectForKey:@"region"];
    NSString* clientId = [formDataDictionary objectForKey:@"applicationId"];
    NSString* installationId = [formDataDictionary objectForKey:@"installationId"];
    NSString* facebookToken = [formDataDictionary objectForKey:@"facebookToken"];
    // NSString* expiration = [formDataDictionary objectForKey:@"expiration"];
    
    if ([partnerScriptId length] == 0) {
        NSMutableDictionary* details = [NSMutableDictionary dictionary];
        [details setValue:@"PartnerScriptId must not be empty" forKey:NSLocalizedDescriptionKey];
        NSError *error = [NSError errorWithDomain:@"NSInvalidArgument" code:300 userInfo:details];
        callback(@[error, [NSNull null]]);
        return;
    }
    
    NSString* binApiGateway = [formDataDictionary objectForKey:@"binApiGateway"];
    Boolean enableKYC = [[formDataDictionary objectForKey:@"enableKYC"] boolValue];
    Boolean enableDataCollection = [[formDataDictionary objectForKey:@"enableDataCollection"] boolValue];
    
    NSString* lastName = [formDataDictionary objectForKey:@"lastName"];
    NSString* firstName = [formDataDictionary objectForKey:@"firstName"];
    NSString* middleName = [formDataDictionary objectForKey:@"middleName"];
    
    NSString* email = [formDataDictionary objectForKey:@"email"];
    NSString* workEmail = [formDataDictionary objectForKey:@"workEmail"];
    NSString* birthday = [formDataDictionary objectForKey:@"birthday"];
    
    // Convert string to date object
    NSDateFormatter *dateFormat = [[NSDateFormatter alloc] init];
    [dateFormat setDateFormat:@"yyyy/MM/dd"];
    
    NSDate *birthdayDate = [dateFormat dateFromString:birthday];
    if ([birthday length] != 0 && birthdayDate == nil) {
        NSMutableDictionary* details = [NSMutableDictionary dictionary];
        [details setValue:@"Birthday must be in (yyyy/MM/dd) format" forKey:NSLocalizedDescriptionKey];
        // populate the error object with the details
        NSError *error = [NSError errorWithDomain:@"NSInvalidArgument" code:300 userInfo:details];
        
        callback(@[error, [NSNull null]]);
        return;
    }
    
    NSString* employerName = [formDataDictionary objectForKey:@"employerName"];
    NSString* employmentStartDateString = [formDataDictionary objectForKey:@"employmentStartDate"];
    NSString* employmentEndDateString = [formDataDictionary objectForKey:@"employmentEndDate"];
    NSString* mobilePhone = [formDataDictionary objectForKey:@"mobilePhone"];
    NSString* homePhone = [formDataDictionary objectForKey:@"homePhone"];
    
    NSDate *employmentStartDate = [dateFormat dateFromString:employmentStartDateString];
    if ([employmentStartDateString length] != 0 && employmentStartDate == nil) {
        NSMutableDictionary* details = [NSMutableDictionary dictionary];
        [details setValue:@"Employment start date must be in (yyyy/MM/dd) format" forKey:NSLocalizedDescriptionKey];
        // populate the error object with the details
        NSError *error = [NSError errorWithDomain:@"NSInvalidArgument" code:300 userInfo:details];
        
        callback(@[error, [NSNull null]]);
        return;
    }
    
    NSDate *employmentEndDate = [dateFormat dateFromString:employmentEndDateString];
    if ([employmentEndDateString length] != 0 && employmentEndDate == nil) {
        NSMutableDictionary* details = [NSMutableDictionary dictionary];
        [details setValue:@"Employment end date must be in (yyyy/MM/dd) format" forKey:NSLocalizedDescriptionKey];
        // populate the error object with the details
        NSError *error = [NSError errorWithDomain:@"NSInvalidArgument" code:300 userInfo:details];
        
        callback(@[error, [NSNull null]]);
        return;
    }
    
    NSString* motherFirstName = [formDataDictionary objectForKey:@"motherFirstName"];
    NSString* motherLastName = [formDataDictionary objectForKey:@"motherLastName"];
    NSString* motherMiddleName = [formDataDictionary objectForKey:@"motherMiddleName"];
    
    NSString* universityName = [formDataDictionary objectForKey:@"universityName"];
    
    NSString* addressLine1 = [formDataDictionary objectForKey:@"addressLine1"];
    NSString* addressLine2 = [formDataDictionary objectForKey:@"addressLine2"];
    NSString* city = [formDataDictionary objectForKey:@"city"];
    NSString* administrativeDivision = [formDataDictionary objectForKey:@"administrativeDivision"];
    NSString* countryCode = [formDataDictionary objectForKey:@"countryCode"];
    NSString* postalCode = [formDataDictionary objectForKey:@"postalCode"];
    /*
    TODO Remove for new KBAB
    NSString* latitude = [formDataDict objectForKey:@"latitude"];
    NSString* longitude = [formDataDict objectForKey:@"longitude"];
    */
    
    /*
    TODO Ticket for adding work_address on onboarding session
    NSString* workAddressLine1 = [formDataDict objectForKey:@"workAddressLine1"];
    NSString* workAddressLine2 = [formDataDict objectForKey:@"workAddressLine2"];
    NSString* workCity = [formDataDict objectForKey:@"workCity"];
    NSString* workAdministrativeDivision = [formDataDict objectForKey:@"workAdministrativeDivision"];
    NSString* workCountryCode = [formDataDict objectForKey:@"workCountryCode"];
    NSString* workPostalCode = [formDataDict objectForKey:@"workPostalCode"];
    NSString* workLatitude = [formDataDict objectForKey:@"workLatitude"];
    NSString* workLongitude = [formDataDict objectForKey:@"workLongitude"];
    */
    
    NSDictionary* fields = [formDataDictionary objectForKey:@"fields"];
    
    NSDictionary* themeColorDict = [formDataDictionary objectForKey:@"themeColor"];
    NSString* themeColorRed = [themeColorDict objectForKey:@"red"];
    NSString* themeColorBlue = [themeColorDict objectForKey:@"blue"];
    NSString* themeColorGreen = [themeColorDict objectForKey:@"green"];
    NSString* themeColorAlpha = [themeColorDict objectForKey:@"alpha"];
    LEThemeColor* themeColor = [[LEThemeColor alloc] initWithRed:[themeColorRed intValue] green:[themeColorGreen intValue] blue:[themeColorBlue intValue] alpha:[themeColorAlpha intValue]];
    
    Boolean enableAssistedPsychometrics = [[formDataDictionary objectForKey:@"enableAssistedPsychometrics"] boolValue];
    NSString* psychometricsApiGateway = [formDataDictionary objectForKey:@"psychometricsApiGateway"];
    
    RCTLogInfo(@"Show Authorize %@ with %@", partnerScriptId, clientId);
    
    LEOnboardingData *formData = [[LEOnboardingData alloc] init];
    formData.lastName = firstName;
    formData.firstName = lastName;
    formData.middleName = middleName;
    
    formData.email = email;
    formData.workEmail = workEmail;
    formData.birthday = birthdayDate;
    
    formData.employerName = employerName;
    formData.employmentStartDate = employmentStartDate;
    formData.employmentEndDate = employmentEndDate;
    formData.mobilePhone = mobilePhone;
    formData.homePhone = homePhone;
    
    formData.motherFirstName = motherFirstName;
    formData.motherLastName = motherLastName;
    formData.motherMiddleName = motherMiddleName;
    
    formData.universityName = universityName;
    
    formData.addressLine1 = addressLine1;
    formData.addressLine2 = addressLine2;
    formData.city = city;
    formData.administrativeDivision = administrativeDivision;
    formData.countryCode = countryCode;
    formData.postalCode = postalCode;

    formData.fields = fields;
    
    formData.themeColor = themeColor;
    formData.enableAssistedPsychometrics = &(enableAssistedPsychometrics);
    formData.psychometricsApiGateway = psychometricsApiGateway;
    
    formData.partnerScriptId = partnerScriptId;
    formData.enableKYC = enableKYC;
    formData.enableDataCollection = enableDataCollection;
    formData.binApiGateway =  binApiGateway;
    
    formData.partnerScriptId = partnerScriptId;
    formData.secret = secret;
    formData.authorizeApiGateway = authorizeApiGateway;
    formData.region = region;
    formData.installationId = installationId;
    formData.facebookToken = facebookToken;
    // formData.expiration = expiration;
    formData.clientId = clientId;
    
    UIViewController *rootViewController = [UIApplication sharedApplication].delegate.window.rootViewController;
    
    // [LEController openAuthorize:rootViewController withData:formData withDelegate:self];
    
    [LEController openAuthorize:rootViewController withProviders: providers withData:formData withDelegate:self];
}

- (NSArray<NSString *> *)supportedEvents {
    return @[@"onAuthorizeCancelled",
             @"onAuthorizeComplete",
             @"onAuthorizeError",
             @"onAuthorizeStarted"
             ];
}

- (void)onAuthorizeCancelled {
    RCTLogInfo(@"onAuthorizeCancelled");
    NSDictionary *body = [NSDictionary dictionaryWithObjectsAndKeys:
                          [NSNumber numberWithInt:300], @"statusCode",
                          [NSNumber numberWithInt:2], @"action",
                          nil];
    
    [self sendEventWithName:@"onAuthorizeCancelled" body:body];
}

- (void)onAuthorizeComplete {
    RCTLogInfo(@"onAuthorizeComplete");
    NSDictionary *body = [NSDictionary dictionaryWithObjectsAndKeys:
                          [NSNumber numberWithInt:200], @"statusCode",
                          [NSNumber numberWithInt:1], @"action",
                          nil];
    
    [self sendEventWithName:@"onAuthorizeComplete" body:body];
}

- (void)onAuthorizeError:(NSError *)error {
    RCTLogInfo(@"onAuthorizeError");
    NSDictionary *body = [NSDictionary dictionaryWithObjectsAndKeys:
                          [NSNumber numberWithLong:[error code]], @"statusCode",
                          [NSNumber numberWithInt:3], @"action",
                          error.localizedDescription, @"message",
                          nil];
    
    [self sendEventWithName:@"onAuthorizeError" body:body];
}

- (void)onAuthorizeStarted {
    RCTLogInfo(@"onAuthorizeStarted");
    NSDictionary *body = [NSDictionary dictionaryWithObjectsAndKeys:
                          [NSNumber numberWithInt:201], @"statusCode",
                          [NSNumber numberWithInt:0], @"action",
                          nil];
    
    [self sendEventWithName:@"onAuthorizeStarted" body:body];
}

+ (void) setProviders:(NSArray *) aProviders {
    providers = aProviders;
}

@end
  
