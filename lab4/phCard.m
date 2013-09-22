#import<Foundation/Foundation.h>

#import "phCard.h"

@implementation phCard

@synthesize name,email,phno;

-(void) print
{
	NSLog(@"Name: %@",name);
	NSLog(@"Email: %@",email);
	NSLog(@"Phone No: %d",phno);
}

@end