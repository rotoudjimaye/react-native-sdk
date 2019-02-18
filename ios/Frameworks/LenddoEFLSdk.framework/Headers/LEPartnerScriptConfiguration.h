//
//  LAPartnerScriptConfiguration.h
//  LenddoEFLSdk
//
//  Created by Neil Mosca on 25/01/2017.
//  Copyright © 2017 Neil Mosca. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface LEPartnerScriptConfiguration : NSObject

@property NSString *baseUrl;
@property NSString *brand;
@property NSString *image;
@property NSString *language;
@property NSString *workflowId;

-(id) initWithValuesForKeysWithDictionary:(NSDictionary<NSString *,id> *)keyedValues;
-(void) setValuesForKeysWithDictionary:(NSDictionary<NSString *,id> *)keyedValues;

@end
