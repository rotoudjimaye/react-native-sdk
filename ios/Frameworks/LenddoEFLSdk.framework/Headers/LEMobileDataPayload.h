//
//  LEMobileDataPayload.h
//  LenddoEFLSdk
//
//  Created by Neil Mosca on 06/08/2018.
//  Copyright © 2018 Lenddo Pte. Ltd. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface LEMobileDataPayload : NSObject

@property NSString *type;
@property NSString *timezone;
@property NSString *version;
@property NSMutableArray *details;

-(NSDictionary*) toDictionary;

@end
