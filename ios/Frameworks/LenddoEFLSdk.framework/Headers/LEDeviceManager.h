//
//  LEDeviceManager.h
//  LenddoEFLSdk
//
//  Created by Neil Mosca on 17/08/2018.
//  Copyright © 2018 Lenddo Pte. Ltd. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface LEDeviceManager : NSObject

@property BOOL allowedByDeveloper;

-(NSMutableArray*) getBatteryInformationDetails;
-(NSMutableArray*) getDeviceInformationDetails;
-(void) requestForDeviceInformationAccess: (Boolean) recursive;
-(bool) hasDeviceInformationAccess;
@end
