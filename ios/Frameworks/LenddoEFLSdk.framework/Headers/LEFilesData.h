//
//  LEFilesData.h
//  LenddoEFLSdk
//
//  Created by Neil Mosca on 12/11/2018.
//  Copyright © 2018 Lenddo Pte. Ltd. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface LEFilesData : NSObject

@property NSString *upload_token;
@property NSString *search_key;
@property NSString *source;

// content
@property NSString *format;
@property NSString *value;

// meta
@property NSString *application_code;
@property NSString *application_id;
@property NSString *partner_script_id;
@property NSString *document_type_id;
@property NSString *filename;
@property NSString *filetype;
@property int file_count;
@property NSString *upload_time;
@property NSString *lenddosdk_version;
@property bool is_video;
@property bool is_id;

-(NSDictionary*) toDictionary;

@end
