//
//  LEPsychometricDelegate.h
//  LenddoEFLSdk
//
//  Created by Neil Mosca on 13/11/2018.
//  Copyright © 2018 Lenddo Pte. Ltd. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "LEPsychoSelfie.h"

@protocol LEPsychometricDelegate <NSObject>

-(void) onCameraRestrictedAlertDialogClicked;
-(void) onSelfieTaken:(LEPsychoSelfie*) aPsychoSelfie;
@end
