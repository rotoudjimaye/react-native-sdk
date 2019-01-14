//
//  LAProvider.h
//  LenddoEFLSdk
//
//  Created by Neil Mosca on 29/03/2017.
//  Copyright © 2017 Lenddo Pte. Ltd. All rights reserved.
//
#import <UIKit/UIKit.h>
#import <Foundation/Foundation.h>
#import "LEProviderDelegate.h"

@interface LEProvider : NSObject

@property (nonatomic, weak) id <LEProviderDelegate> providerDelegate;
@property (nonatomic, weak) NSString* provider;
@property (nonatomic, weak) UIViewController* viewController;

// Override this function on sub-class
-(void) openSignIn:(NSArray *) scopes;

-(id) initWithProvider: (NSString *) aProvider withViewController: (UIViewController*) aViewController withProviderDelegate: (id) providerDelegate;

@end
