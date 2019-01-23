//
//  LAIdentityToken.h
//  LenddoEFLSdk
//
//  Created by Neil Mosca on 21/03/2017.
//  Copyright © 2017 Lenddo Pte. Ltd. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface LEIdentityToken : NSObject

@property (nonatomic, strong) NSString *provider;
@property (nonatomic, strong) NSString *oauthVersion;
@property (nonatomic, strong) NSString *clientId;
@property (nonatomic, strong) NSString *accessToken;
@property (nonatomic, strong) NSString *idToken;
@property (nonatomic, strong) NSString *refreshToken;
@property (nonatomic, strong) NSDictionary *state;

-(id) initWithValuesForKeysWithDictionary:(NSDictionary<NSString *,id> *)keyedValues;
-(void) setValuesForKeysWithDictionary:(NSDictionary<NSString *,id> *)keyedValues;
-(NSDictionary*) toDictionary;

@end
