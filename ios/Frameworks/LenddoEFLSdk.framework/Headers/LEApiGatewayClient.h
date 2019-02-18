//
//  LEApiGatewayClient.h
//  LenddoEFLSdk
//
//  Created by Neil Mosca on 06/08/2018.
//  Copyright © 2018 Lenddo Pte. Ltd. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "LEGatewayStatus.h"
#import "LESingleUseToken.h"
#import "LEMobileDataPayload.h"
#import "LEMobilePartnerToken.h"
#import "LEApplicatonPartnerData.h"

@interface LEApiGatewayClient : NSObject

@property NSString *partnerScriptId;
@property NSString *secret;
@property NSString *gateway;
@property NSString *installationId;
@property NSString *deviceId;
@property NSString *serviceToken;
@property LESingleUseToken *singleUseToken;

-(id) initWithSessionManager: (id) sessionManager;

-(id) initWithAttributes: (NSString *) aPartnerScriptId
                  secret: (NSString *) aSecret
                 gateway: (NSString *) aGateway
                 installationId: (NSString *) anInstallationId
                 deviceId: (NSString *) aDeviceId;

-(void) getStatusWithSuccess:(void(^)(bool))aSuccess
                                 andFailure:(void(^)(NSError*))aFailure;

-(void) getSingleUseTokenWithSuccess:(void(^)(LESingleUseToken*))aSuccess
                                 andFailure:(void(^)(NSError*))aFailure;

-(void) postRegisterInstallationWithApplicationId:(NSString *) applicationId
                                      withSuccess:(void(^)(bool))aSuccess
                              andFailure:(void(^)(NSError*))aFailure;

-(void) postVerifymeInstallationWithApplicationId:(NSString *) applicationId
                                      withSuccess:(void(^)(bool))aSuccess
                                 andFailure:(void(^)(NSError*))aFailure;

-(void) postMobileDataWithPaylod:(LEMobileDataPayload *) payload
                                      withSuccess:(void(^)(id))aSuccess
                                       andFailure:(void(^)(NSError*))aFailure;

-(void) postMobilePartnerTokenWithToken:(LEMobilePartnerToken *) token
                     withSuccess:(void(^)(id))aSuccess
                      andFailure:(void(^)(NSError*))aFailure;

-(void) postApplicationPartnerWithData:(LEApplicatonPartnerData *) data
                            withSuccess:(void(^)(id))aSuccess
                             andFailure:(void(^)(NSError*))aFailure;
@end
