//
//  LEApplicationCodeVerificationForm.h
//  LenddoEFLSdk
//
//  Created by Neil Mosca on 11/01/2019.
//  Copyright © 2019 Lenddo Pte. Ltd. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "LEApplicationCodeVerificationFormRules.h"

@interface LEApplicationCodeVerificationForm : NSObject

@property NSString *code;
@property Boolean is_required;
@property LEApplicationCodeVerificationFormRules *rules;

-(id) initWithValuesForKeysWithDictionary:(NSDictionary<NSString *,id> *)keyedValues;
-(void) setValuesForKeysWithDictionary:(NSDictionary<NSString *,id> *)keyedValues;


@end

