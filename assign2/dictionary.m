#import <Foundation/Foundation.h>
#import "dictionary.h"

@implementation dictionary

@synthesize dict;

-(void) print
{
	for ( id key in dict)
	{
		if([key rangeOfString:@"meter"].location!=NSNotFound)
		{	

			NSLog(@" Key: %@ Value: %@ \n",key,[dict objectForKey:key]);
		}
	}
}

@end