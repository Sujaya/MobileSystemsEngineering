#import <Foundation/Foundation.h>
#import "bill.h"
#import "calcTax.h"
#import "tax.h"

int main(int argc,char *argv[])
{
	NSAutoreleasePool *myPool = [[NSAutoreleasePool alloc] init];
	Bill *bill=[[Bill alloc]init];

	char input[10];
	float amt;

	NSLog(@"Enter Bill type: 1.Finished/Export 2.Grocery\n");
	scanf("%s",input);

	NSLog(@"Enter Bill Amount\n");
	scanf("%f",&amt);

	NSString *type=[NSString stringWithUTF8String:input];
	[bill setType:type];
	[bill setBillamount:amt];

	calcTax *calc=[[calcTax alloc]init];
	[calc calculateF:bill];
	[bill release];	
	[calc release];	
	[myPool drain];
	return 0;
}