//
//  LELivenessInstruction.h
//  LenddoEFLSdk
//
//  Created by Neil Mosca on 05/11/2018.
//  Copyright © 2018 Lenddo Pte. Ltd. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface LELivenessInstruction : NSObject

@property NSArray *instructions;

-(id) initWithValuesForKeysWithDictionary:(NSDictionary<NSString *,id> *)keyedValues;
-(void) setValuesForKeysWithDictionary:(NSDictionary<NSString *,id> *)keyedValues;

@end

