#import<Foundation/Foundation.h>
#import "phCard.h"

@interface phonebook:NSObject
{
	NSString* bname;
	NSMutableArray *cards;
}

@property (copy)NSMutableArray* cards;

-(void) removeCard:(NSString*) name;
-(void) edit;
-(void) printDetails;
-(void) count;
-(phoneCard *) search:(NSString*)sName;

@end