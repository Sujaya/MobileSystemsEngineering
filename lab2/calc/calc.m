#import<Foundation/Foundation.h>
#import "calc.h"


    @implementation calc
   
      @synthesize num1,num2;
   
       -(void)calc:(int)op
      {
         int res;
         if(num2==0)
            NSLog(@"Potential Divide by zero error!\n");
         else
         {
            switch(op)
            {
               case 1:res=num1+num2;
                  break;
               case 2:res=num1-num2;
                  break;
               case 3:res=num1*num2;
                  break;
               case 4:res=num1/num2;
                  break;
               default:printf("Invalid Operator\n");
            }
            NSLog(@"Result=%d \n",res);
         }
      }
   @end