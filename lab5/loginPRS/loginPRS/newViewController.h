//
//  newViewController.h
//  loginPRS
//
//  Created by MSE on 19/09/13.
//  Copyright (c) 2013 MSE. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "ViewController.h"

@interface newViewController : UIViewController
{
  //ing *temp;
}
@property (weak, nonatomic) IBOutlet UILabel *userOutput;
- (IBAction)logout:(UIButton *)sender;
@property (retain, nonatomic) NSString * temp;
@end
