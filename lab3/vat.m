#import <Foundation/Foundation.h>
#import "vat.h"
#import "bill.h"
#import "calcTax.h"

@implementation vat

-(void) calculateVat:(Bill*) bill
{
	float amount=[bill billamount];
	float temp=0.08;	
	totaltax=temp*amount;
	totalamt=amount+totaltax;
}

@end