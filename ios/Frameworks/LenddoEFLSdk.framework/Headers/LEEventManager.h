//
//  LEEventManager.h
//  LenddoEFLSdk
//
//  Created by Neil Mosca on 15/08/2018.
//  Copyright © 2018 Lenddo Pte. Ltd. All rights reserved.
//
#import <UIKit/UIKit.h>

@interface LEEventManager : NSObject

@property BOOL allowedByDeveloper;
    
-(NSMutableArray*) getCalendarEventListDetails;
-(void) requestForCalendarEventsAccess: (Boolean) recursive;
-(bool) hasCalendarEventsAccess;
@end
