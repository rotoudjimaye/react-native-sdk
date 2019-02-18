
#if __has_include(<React/RCTBridgeModule.h>)
#import <React/RCTBridgeModule.h>
#else
#import "RCTBridgeModule.h"
#endif

#if __has_include(<React/RCTLog.h>)
#import <React/RCTLog.h>
#else
#import "RCTLog.h"
#endif

#if __has_include(<React/RCTEventEmitter.h>)
#import <React/RCTEventEmitter.h>
#else
#import "RCTEventEmitter.h"
#endif

#import <LenddoEFLSdk/LEAuthorizeEventDelegate.h>
#import <LenddoEFLSdk/LEController.h>
#import <LenddoEFLSdk/LEOnboardingData.h>
#import <LenddoEFLSdk/LEProvider.h>

@interface RNOnboardingSdkWrapperIOS : RCTEventEmitter <RCTBridgeModule, LEAuthorizeEventDelegate>

+(void) setProviders:(NSArray *) providers;

@end
  
