#import<Foundation/Foundation.h>
#import "date.h"

int main(int argc, char* argv[])
{
	NSAutoreleasePool *myPool = [[NSAutoreleasePool alloc] init];
	date *Date=[[date alloc]init];	
	NSDate* currDate=[NSDate date];	
	NSDate* pastDate = [NSDate dateWithTimeIntervalSinceNow:2*24*60*60];
	NSDate* tenDate = [NSDate dateWithTimeIntervalSinceNow:10*24*60*60];
	[Date setCurrent:currDate];
	[Date setDayafter: pastDate];
	[Date setTenth:tenDate];	
	[Date display];
	[Date lastthursday];
	[Date earlydate];
	[Date release];
	[currDate release];
	[myPool drain];
	return 0;
}
