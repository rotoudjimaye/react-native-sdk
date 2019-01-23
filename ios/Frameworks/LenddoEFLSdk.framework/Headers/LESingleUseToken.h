//
//  LESingleUseToken.h
//  LenddoEFLSdk
//
//  Created by Neil Mosca on 06/08/2018.
//  Copyright © 2018 Lenddo Pte. Ltd. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface LESingleUseToken : NSObject

@property NSString *token;
@property long ttl;

-(id) initWithValuesForKeysWithDictionary:(NSDictionary<NSString *,id> *)keyedValues;
-(void) setValuesForKeysWithDictionary:(NSDictionary<NSString *,id> *)keyedValues;

@end
