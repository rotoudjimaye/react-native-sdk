//
//  LEApplicationCodeVerificationFormRules.h
//  LenddoEFLSdk
//
//  Created by Neil Mosca on 11/01/2019.
//  Copyright © 2019 Lenddo Pte. Ltd. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface LEApplicationCodeVerificationFormRules : NSObject

@property NSString *type;
@property int min;
@property int max;
@property NSString *regex;

-(id) initWithValuesForKeysWithDictionary:(NSDictionary<NSString *,id> *)keyedValues;
-(void) setValuesForKeysWithDictionary:(NSDictionary<NSString *,id> *)keyedValues;

@end

