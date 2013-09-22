#import<Foundation/Foundation.h>
#import "bill.h"
#import "kst.h"
#import "tax.h"

@implementation kst
-(void) calculateKST:(Bill*) bill
{
	float amount=[bill billamount];
	float temp=0.14;	
	totaltax=temp*amount;
	totalamt=totaltax+amount;
}

@end