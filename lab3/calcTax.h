#import<Foundation/Foundation.h>
#import "tax.h"
#import "bill.h"

@interface calcTax:NSObject

-(void)calculateF:(Bill*) bill;

@end