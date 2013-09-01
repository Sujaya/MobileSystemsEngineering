#import<Foundation/Foundation.h>
//#import<stdio.h>
#import "Hello.h"

int main(int argc, char * argv[])
{
	Print *helloworld=[[Print alloc]init];//object creation is a two step process.1.Creation, 2.Initialization
	[helloworld addStringValue:"Hello World!"];//Calling method to return the value in the newly created object.
	[helloworld print];//send the object to the print function.
	[helloworld release];//deallocate the memory
	return 0;

}