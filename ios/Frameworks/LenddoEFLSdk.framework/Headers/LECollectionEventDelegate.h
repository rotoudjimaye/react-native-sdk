//
//  LECollectionEventDelegate.h
//  LenddoEFLSdk
//
//  Created by Neil Mosca on 11/09/2018.
//  Copyright © 2018 Lenddo Pte. Ltd. All rights reserved.
//

#import <Foundation/Foundation.h>

@protocol LECollectionEventDelegate <NSObject>

-(void)onCollectionComplete;
-(void)onCollectionStarted;
-(void)onCollectionFailed:(NSError*)error;

@end
