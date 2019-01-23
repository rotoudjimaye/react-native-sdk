//
//  LEPedometerManager.h
//  LenddoEFLSdk
//
//  Created by Neil Mosca on 01/10/2018.
//  Copyright © 2018 Lenddo Pte. Ltd. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface LEPedometerManager : NSObject

@property BOOL allowedByDeveloper;

-(NSMutableArray*) getPedometerLogDetails;
-(void) requestForMotionAndFitnessAccess: (Boolean) recursive;
-(bool) hasMotionAndFitnessAccess;
-(bool) isSupported;
@end
