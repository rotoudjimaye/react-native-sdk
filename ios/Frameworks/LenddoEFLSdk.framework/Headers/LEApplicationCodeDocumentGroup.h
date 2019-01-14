//
//  LEApplicationCodeDocumentGroup.h
//  LenddoEFLSdk
//
//  Created by Neil Mosca on 11/01/2019.
//  Copyright © 2019 Lenddo Pte. Ltd. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface LEApplicationCodeDocumentGroup : NSObject

@property NSString *_id;
@property NSString *name;
@property NSArray *document_types;

-(id) initWithValuesForKeysWithDictionary:(NSDictionary<NSString *,id> *)keyedValues;
-(void) setValuesForKeysWithDictionary:(NSDictionary<NSString *,id> *)keyedValues;

@end
