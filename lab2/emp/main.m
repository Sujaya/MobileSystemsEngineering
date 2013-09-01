#import<Foundation/Foundation.h>
#import "e.h"

int main(int argc,char* argv[])
{
	e *emp=[[e alloc]init];
	[emp setName:"Ayesha"];
	[emp setDept:"ISE"];
	[emp setEid:1123];
	[emp print];
	[emp release];
	return 0;
}