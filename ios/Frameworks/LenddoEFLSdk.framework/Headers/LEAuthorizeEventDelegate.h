//
//  LEAuthorizeEventDelegate.h
//  LenddoEFLSdk
//
//  Created by Neil Mosca on 25/01/2017.
//  Copyright © 2017 Neil Mosca. All rights reserved.
//

#import <Foundation/Foundation.h>

@protocol LEAuthorizeEventDelegate <NSObject>

-(void)onAuthorizeComplete;
-(void)onAuthorizeStarted;
-(void)onAuthorizeError:(NSError*)error;
-(void)onAuthorizeCancelled;

@end
