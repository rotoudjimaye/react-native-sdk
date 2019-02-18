//
//  LAThemeColor.h
//  LenddoEFLSdk
//
//  Created by Neil Mosca on 18/07/2017.
//  Copyright © 2017 Lenddo Pte. Ltd. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>

@interface LEThemeColor : NSObject


@property int red;
@property int green;
@property int blue;
@property int alpha;

-(id) initWithRed: (int) aRed
            green: (int) aGreen
             blue: (int) aBlue
            alpha: (int) aAlpha;

- (UIColor*) getColor;

@end
