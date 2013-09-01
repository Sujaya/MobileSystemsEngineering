#import<Foundation/Foundation.h>

@interface Print:NSObject
{
	char buffer[15];
}

- addStringValue:(const char*)astring;
- print;

@end