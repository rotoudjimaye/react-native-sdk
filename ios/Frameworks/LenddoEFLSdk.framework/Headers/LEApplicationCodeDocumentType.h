//
//  LEApplicationCodeDocumentType.h
//  LenddoEFLSdk
//
//  Created by Neil Mosca on 11/01/2019.
//  Copyright © 2019 Lenddo Pte. Ltd. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface LEApplicationCodeDocumentType : NSObject

@property NSString *_id;
@property NSString *name;
@property NSString *translation_key;
@property NSString *country_code;
@property Boolean has_face;
@property Boolean has_signature;
@property Boolean is_id;
@property Boolean is_video;
@property NSArray *parts;
@property NSArray *document_fields;

-(id) initWithValuesForKeysWithDictionary:(NSDictionary<NSString *,id> *)keyedValues;
-(void) setValuesForKeysWithDictionary:(NSDictionary<NSString *,id> *)keyedValues;

@end

