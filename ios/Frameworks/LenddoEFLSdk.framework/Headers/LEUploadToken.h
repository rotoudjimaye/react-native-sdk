//
//  LEUploadToken.h
//  LenddoEFLSdk
//
//  Created by Neil Mosca on 29/10/2018.
//  Copyright © 2018 Lenddo Pte. Ltd. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface LEUploadToken : NSObject

@property NSString *token;
    
-(id) initWithValuesForKeysWithDictionary:(NSDictionary<NSString *,id> *)keyedValues;
-(void) setValuesForKeysWithDictionary:(NSDictionary<NSString *,id> *)keyedValues;
    
@end
