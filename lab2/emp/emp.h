#import<Foundation/Foundation.h>

@interface emp:NSObject
{
	char* name;
	char* dept;
	int eid;
}

@property char* name;
@property char* dept;
@property int eid;
/*
-(void)setName:(NSString*)nam;
-(void)setDept:(NSString*)dep;
-(void)setEid:(int)ed;
*/
-(void)print;

@end