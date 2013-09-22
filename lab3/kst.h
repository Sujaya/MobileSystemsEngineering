#import<Foundation/Foundation.h>
#import "bill.h"
#import "tax.h"

@interface kst:Tax

-(void) calculateKST:(Bill*) bill;
@end