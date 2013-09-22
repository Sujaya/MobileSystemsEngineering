#import <Foundation/Foundation.h>
#import "phonebook.h"
#import "phCard.h"

@implementation phonebook
@synthesize cards;

-(id)initWithName:(NSString *)name
{
	self=[super init];
	if(self)
	{
	bname=[[NSString alloc]initWithString:name];
	cards=[[NSMutableArray alloc]init];
	}
	return self;
}

-(id)init
{
	return [self initWithName:@"No Name"];
}

-(void) removeCard:(NSString *)name
{
	phoneCard* temp=[self search:name];
	[cards removeObject:temp];
	[temp release];
}

-(void) edit
{
	char str[10];
	int ph;
	NSLog(@"Enter Name to be Edited\n");
	scanf("%s",str);
	phoneCard* temp=[self search:[NSString stringWithUTF8String:str]];
	NSLog(@"Enter new Name\n");
	NSString* new=[NSString stringWithUTF8String:str];
	[temp setName:new];
	NSLog(@"Enter new Email\n");
	scanf("%s",str);
	NSString* newe=[NSString stringWithUTF8String:str];
   [temp setEmail:newe];
	NSLog(@"Enter new Phone Number\n");
	scanf("%d",&ph);
   [temp setPhno:ph];
}

-(void) printDetails
{
	for(phoneCard* next in cards)
	[next print];
}

-(void) count
{	
	int  count=0;
	for(phoneCard* next in cards)
	{
		++count;
	}
	NSLog(@"Number of Entries: %d",count);
}


-(phoneCard *) search:(NSString*)sName
{
	for(phoneCard* next in cards)
	{
		if([next.name caseInsensitiveCompare:sName]==NSOrderedSame)
		return next;
	}
	return nil;
}

@end