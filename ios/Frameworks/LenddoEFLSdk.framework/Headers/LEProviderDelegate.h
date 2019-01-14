//
//  LAProviderDelegate.h
//  LenddoEFLSdk
//
//  Created by Neil Mosca on 29/03/2017.
//  Copyright © 2017 Lenddo Pte. Ltd. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "LEIdentityToken.h"

@protocol LEProviderDelegate <NSObject>

-(void) signInWithIdentityToken: (LEIdentityToken *) identityToken
               withError: (NSError *) error;
@end
