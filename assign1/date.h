#import <Foundation/Foundation.h>
@interface date:NSObject
{
	NSDate *current;
	NSDate *dayafter;
	NSDate *tenth;
}

@property (retain, nonatomic) NSDate *current;
@property (retain, nonatomic) NSDate *dayafter;
@property (retain, nonatomic) NSDate *tenth;

-(void) display;
-(void) earlydate;
-(void) lastthursday;


@end