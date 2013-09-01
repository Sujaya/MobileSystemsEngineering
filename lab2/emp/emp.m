#import<Foundation/Foundation.h>
#import "emp.h"
@implementation emp

@synthesize name;
@synthesize dept;
@synthesize eid;

-(void)print
{
NSLog(@"Name: %s",name);
NSLog(@"Department: %s",dept);
NSLog(@"EID: %d",eid);
}

@end