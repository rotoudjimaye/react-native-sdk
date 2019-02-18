//
//  LEMotionActivityManager.h
//  LenddoEFLSdk
//
//  Created by Neil Mosca on 19/09/2018.
//  Copyright © 2018 Lenddo Pte. Ltd. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface LEMotionActivityManager : NSObject

@property BOOL allowedByDeveloper;

-(NSMutableArray*) getMotionActivityDetails;
-(void) requestForMotionAndFitnessAccess: (Boolean) recursive;
-(bool) hasMotionAndFitnessAccess;
-(bool) isSupported;
@end
