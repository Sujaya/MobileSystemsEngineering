#import <Foundation/Foundation.h>
#import "date.h"

@implementation date

@synthesize current,dayafter,tenth;

-(void) display
{
	NSLog(@"Today: %@ \n\n",current);
	NSLog(@"Day After: %@ \n\n",dayafter);
	NSLog(@"10th Day: %@ \n\n",tenth);
}


-(void) earlydate
{	
	NSLog(@"Comparing Dates:\n");
	if([current compare:dayafter]==NSOrderedAscending)
    		NSLog(@"Today is less\n\n");
	else if([current compare:dayafter]==NSOrderedDescending)
	    	NSLog(@"Day After is less\n\n");
	else
    		NSLog(@"Both dates are same\n\n");
}

-(void) lastthursday
{
	int i=0;
	NSDateFormatter* theDateFormatter = [[[NSDateFormatter alloc] init] autorelease];
	[theDateFormatter setFormatterBehavior:NSDateFormatterBehavior10_4];
	[theDateFormatter setDateFormat:@"EEEE"];
	NSString *weekDay =  [theDateFormatter stringFromDate:[NSDate date]];
	if ([weekDay isEqualToString:@"Monday"])
		i=4;
	else if([weekDay isEqualToString:@"Tuesday"])
		i=5;
	else if([weekDay isEqualToString:@"Wednesday"])
		i=6;
	else if([weekDay isEqualToString:@"Thursday"])
		i=7;
	else if([weekDay isEqualToString:@"Friday"])
		i=1;
	else if([weekDay isEqualToString:@"Saturday"])
		i=2;
	else 
		i=3;
	NSDate* lastThursday = [NSDate dateWithTimeIntervalSinceNow:-i*24*60*60];
	NSLog(@"Last Thursday: %@ \n\n",lastThursday);



}

@end