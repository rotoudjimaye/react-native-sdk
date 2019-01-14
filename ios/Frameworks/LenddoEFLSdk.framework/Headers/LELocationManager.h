//
//  LELocationManager.h
//  LenddoEFLSdk
//
//  Created by Neil Mosca on 23/08/2018.
//  Copyright © 2018 Lenddo Pte. Ltd. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <CoreLocation/CoreLocation.h>

@interface LELocationManager : NSObject <CLLocationManagerDelegate>

@property BOOL allowedByDeveloper;

-(NSMutableArray*) getLocationDetails;
-(void) requestForLocationAccess: (Boolean) recursive;
-(bool) hasLocationAccess;

@end
