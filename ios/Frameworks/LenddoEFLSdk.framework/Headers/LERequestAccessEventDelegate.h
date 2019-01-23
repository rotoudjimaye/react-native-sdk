//
//  LERequestAccessEventDelegate.h
//  LenddoEFLSdk
//
//  Created by Neil Mosca on 12/09/2018.
//  Copyright © 2018 Lenddo Pte. Ltd. All rights reserved.
//
#import <Foundation/Foundation.h>

@protocol LERequestAccessEventDelegate <NSObject>

-(void) onRequestAccessComplete;

@end

