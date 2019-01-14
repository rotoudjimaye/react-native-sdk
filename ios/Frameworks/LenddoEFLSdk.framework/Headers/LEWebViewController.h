//
//  LAWebViewController.h
//  LenddoEFLSdk
//
//  Created by Neil Mosca on 26/01/2017.
//  Copyright © 2017 Neil Mosca. All rights reserved.
//

#import <UIKit/UIKit.h>
#import <WebKit/WebKit.h>
#import <LenddoEFLSdk/LenddoEFLSdk-Swift.h>
#import "LEAuthorizeEventDelegate.h"
#import "LEOnboardingData.h"
#import "LEProviderDelegate.h"
#import "LEProvider.h"
#import "LEBinApiClient.h"
#import "LEAuthorizeApiClient.h"
#import "LEPsychometricDelegate.h"

@interface LEWebViewController : UIViewController <WKNavigationDelegate, UIScrollViewDelegate, LEProviderDelegate, UIBarPositioningDelegate, LivenessCameraControllerDelegate, LEPsychometricDelegate, SignatureControllerDelegate, DocumentCaptureControllerDelegate>

@property LEOnboardingData *formData;
@property (nonatomic) LEProvider *googleProvider;
@property (nonatomic) LEProvider *facebookProvider;

@property (nonatomic, weak) id <LEAuthorizeEventDelegate> authorizeEventDelegate;

-(id) initWithData: (LEOnboardingData *) formData
          delegate: (id) authorizeEventDelegate;

-(id) initWithAuthorizeApiClient: (LEAuthorizeApiClient *) anAuthorizeApiClient withBinApiClient: (LEBinApiClient *) aBinApiClient;

@end
