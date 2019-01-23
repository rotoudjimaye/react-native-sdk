//
//  LEConnectivityManager.h
//  LenddoEFLSdk
//
//  Created by Neil Mosca on 04/10/2018.
//  Copyright © 2018 Lenddo Pte. Ltd. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <CoreBluetooth/CoreBluetooth.h>

@interface LEConnectivityManager : NSObject <CBCentralManagerDelegate>

@property BOOL allowedByDeveloper;

-(NSMutableArray*) getNetworkConnectivityInformationDetails;
-(NSMutableArray*) getBluetoothConnectivityInformationDetails;
-(void) requestForConnectivityAccess: (Boolean) recursive;
-(bool) hasConnectivityInformationAccess;

@end
