//
//  LAAttachment.h
//  LenddoEFLSdk
//
//  Created by Neil Mosca on 12/09/2017.
//  Copyright © 2017 Lenddo Pte. Ltd. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface LEPsychoSelfie : NSObject

@property NSString *format;
@property NSString *value;
@property NSString *ps_token;

-(NSDictionary*) toDictionary;

@end
