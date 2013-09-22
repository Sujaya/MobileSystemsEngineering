#import<Foundation/Foundation.h>
#import "tax.h"
#import "bill.h"
#import "calcTax.h"
#import "vat.h"
#import "kst.h"

@implementation calcTax
-(void)calculateF:(Bill*) bill
{
	NSString *type=[[NSString alloc]init];
	type=[bill type];
	if([type isEqualToString:@"1"])
	{
		kst *ks=[[kst alloc]init];
		[ks calculateKST:bill];
		[ks print];
	}
	else if([type isEqualToString:@"2"])
	{	
		vat *va=[[vat alloc]init];
		[va calculateVat:bill];
		[va print];		
	}
	else
		NSLog(@"Invalid Input!\n");
	[type release];
}

@end