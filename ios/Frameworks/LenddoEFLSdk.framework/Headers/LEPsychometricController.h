//
//  LEPsychometricController.h
//  LenddoEFLSdk
//
//  Created by Neil Mosca on 13/11/2018.
//  Copyright © 2018 Lenddo Pte. Ltd. All rights reserved.
//

#import <UIKit/UIKit.h>
#import <Foundation/Foundation.h>
#import "LEPsychometricDelegate.h"

@interface LEPsychometricController : NSObject

@property (nonatomic, weak) id <LEPsychometricDelegate> psychometricDelegate;
@property (nonatomic, strong) UIViewController *presenter;

-(id) initWithPresenter:(UIViewController*) aPresenter withDelegate: (id) aPsychometricDelegate;
-(void) interceptPsychometricSelfieUrl: (NSURL *) url;
-(void) stopSession;
-(void) checkCameraAccess;

@end
