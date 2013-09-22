#import<Foundation/Foundation.h>
#import "tax.h"
#import "bill.h"

@interface vat:Tax
-(void) calculateVat:(Bill*) bill;

@end