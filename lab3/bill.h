#import<Foundation/Foundation.h>

@interface Bill:NSObject
{
	NSString* type;
	float billamount; 
}

@property float billamount;
@property (retain) NSString *type;

@end