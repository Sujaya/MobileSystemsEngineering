#import <Foundation/Foundation.h>

@interface phCard: NSObject
{
NSString *name;
NSString *email;
int phno;
}

@property (copy)NSString* name;
@property (copy)NSString* email;
@property int phno;


-(void) print;
@end