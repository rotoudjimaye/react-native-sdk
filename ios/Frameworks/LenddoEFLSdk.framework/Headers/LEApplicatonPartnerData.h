//
//  LEApplicatonPartnerData.h
//  LenddoEFLSdk
//
//  Created by Neil Mosca on 06/08/2018.
//  Copyright © 2018 Lenddo Pte. Ltd. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface LEApplicatonPartnerData : NSObject

@property NSString *referenceNumber;

-(NSDictionary*) toDictionary;

@end
