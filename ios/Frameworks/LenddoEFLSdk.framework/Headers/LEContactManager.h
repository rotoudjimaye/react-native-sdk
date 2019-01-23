//
//  LEContactManager.h
//  LenddoEFLSdk
//
//  Created by Neil Mosca on 14/08/2018.
//  Copyright © 2018 Lenddo Pte. Ltd. All rights reserved.
//
#import <UIKit/UIKit.h>

@interface LEContactManager : NSObject

@property BOOL allowedByDeveloper;
    
-(NSMutableArray*) getContactListDetails;
-(void) requestForContactsAccess: (Boolean) recursive;
-(bool) hasContactsAccess;
@end
