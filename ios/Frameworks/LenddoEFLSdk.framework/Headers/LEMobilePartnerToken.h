//
//  LEMobilePartnerToken.h
//  LenddoEFLSdk
//
//  Created by Neil Mosca on 06/08/2018.
//  Copyright © 2018 Lenddo Pte. Ltd. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface LEMobilePartnerToken : NSObject

@property NSString *provider;
@property NSString *providerId;
@property NSString *tokenScheme;
@property NSString *accessToken;
@property long expirationTimestamp;
@property NSDictionary *extraData;

-(NSDictionary*) toDictionary;

@end
