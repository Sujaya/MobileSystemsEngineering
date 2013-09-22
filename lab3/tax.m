#import <Foundation/Foundation.h>
#import "bill.h"
#import "tax.h"

@implementation Tax
-(void)print
{
	NSLog(@"Bill Tax Amount= %.2f \n",totaltax);
	NSLog(@"Bill Total Amount=%.2f \n",totalamt);
}

@end