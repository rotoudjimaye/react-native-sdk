//
//  LEApplicationCodeDetails.h
//  LenddoEFLSdk
//
//  Created by Neil Mosca on 11/01/2019.
//  Copyright © 2019 Lenddo Pte. Ltd. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "LEApplicationCodeTheme.h"

@interface LEApplicationCodeDetails : NSObject

@property NSString *code;
@property NSString *partner_script_id;
@property NSString *partner_name;
@property NSString *language;
@property NSString *logo;
@property NSArray *verification_form;
@property LEApplicationCodeTheme *theme;

-(id) initWithValuesForKeysWithDictionary:(NSDictionary<NSString *,id> *)keyedValues;
-(void) setValuesForKeysWithDictionary:(NSDictionary<NSString *,id> *)keyedValues;

@end
