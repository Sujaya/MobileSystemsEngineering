#import <Foundation/Foundation.h>

#import "dictionary.h"

int main(int argc, char *argv[])
{
	NSAutoreleasePool *myPool = [[NSAutoreleasePool alloc] init];
	dictionary *Dictionary=[[dictionary alloc] init];
	NSArray *keys=[NSArray arrayWithObjects:@"centimeter", @"pound", @"ounce", @"kilogram", @"yard", @"millimeter", @"kilometer", @"milligram", @"gram", @"meter", nil];	

	NSArray *objects=[NSArray arrayWithObjects:[NSNumber numberWithInt:10], [NSNumber numberWithInt:40], [NSNumber numberWithInt:50], [NSNumber numberWithInt:20], [NSNumber numberWithInt:30], [NSNumber numberWithInt:10], [NSNumber numberWithInt:10], [NSNumber numberWithInt:20], [NSNumber numberWithInt:20], [NSNumber numberWithInt:10],nil];
	NSDictionary* diction=[[NSDictionary alloc]  initWithObjects:objects forKeys:keys];	
	[Dictionary setDict: diction];	
	[Dictionary print];
	[diction release];	
	[Dictionary release];	
	[myPool drain];
	return 0;
}