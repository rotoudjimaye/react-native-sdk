//
//  LEApiGatewayManager.h
//  LenddoEFLSdk
//
//  Created by Neil Mosca on 13/08/2018.
//  Copyright © 2018 Lenddo Pte. Ltd. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "LEApiGatewayClient.h"
#import "LECollectionEventDelegate.h"
#import "LERequestAccessEventDelegate.h"

@interface LEDataManager : NSObject

@property (nonatomic, weak) id <LECollectionEventDelegate> collectionEventDelegate;
@property (nonatomic, weak) id <LERequestAccessEventDelegate> requestAccessEventDelegate;

@property bool allowCalendarEvents;
@property bool allowContacts;
@property bool allowLocation;
@property bool allowDeviceInfo;
@property bool allowBatteryInfo;
@property bool allowConnectivityInfo;
@property bool allowBluetoothInfo;
@property bool allowPedometerLogs;
@property bool allowMotionActivity;

+ (instancetype)sharedInstance;

-(id) initWithAttributes: (NSString *) aPartnerScriptId
                  secret: (NSString *) aSecret
                  gateway: (NSString *) aGateway
                  installationId: (NSString *) anInstallationId
                 deviceId: (NSString *) aDeviceId;

-(id) initWithApiClient: (LEApiGatewayClient *) anApiClient;

-(void) setPartnerScriptId:(NSString *) aPartnerScriptId;
-(void) setSecret:(NSString *) aSecret;
-(void) setGateway:(NSString *) aGateway;
-(void) setInstallationId:(NSString *) anInstallationId;
-(void) setDeviceId:(NSString *) aDeviceId;

-(void) requestAccessForAllowedByDevelopers;
-(void) sendDataForAllowedByDevelopers;
-(bool) doAllAccessAreAuthorizeForAllowedByDevelopers;

-(void) registerInstallationWithApplicationId:(NSString *) anApplicationId
                                      withSuccess:(void(^)(bool))aSuccess
                                       andFailure:(void(^)(NSError*))aFailure;

-(void) verifimeInstallationWithApplicationId:(NSString *) anApplicationId
                                  withSuccess:(void(^)(bool))aSuccess
                  andFailure:(void(^)(NSError*))aFailure;

@end
