//
//  LAServiceToken.h
//  LenddoEFLSdk
//
//  Created by Neil Mosca on 25/01/2017.
//  Copyright © 2017 Neil Mosca. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface LEServiceToken : NSObject

@property NSString *token;
@property long expirationTime;
@property long timestamp;

-(id) initWithValuesForKeysWithDictionary:(NSDictionary<NSString *,id> *)keyedValues;
-(void) setValuesForKeysWithDictionary:(NSDictionary<NSString *,id> *)keyedValues;

@end
