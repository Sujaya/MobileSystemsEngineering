#import<Foundation/Foundation.h>
#import "calc.h"

int main(int argc, char*argv[])
{
	calc *op=[[calc alloc]init];
	[op setNum1:6];
	[op setNum2:3];
	[op calc:1];
	[op calc:2];
	[op calc:3];
	[op calc:4];
	[op release];
	return 0;
}