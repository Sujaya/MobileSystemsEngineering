//
//  newViewController.m
//  loginPRS
//
//  Created by MSE on 19/09/13.
//  Copyright (c) 2013 MSE. All rights reserved.
//

#import "newViewController.h"
#import"ViewController.h"
@interface newViewController ()

@end

@implementation newViewController

@synthesize userOutput, temp;

- (id)initWithNibName:(NSString *)nibNameOrNil bundle:(NSBundle *)nibBundleOrNil
{
    self = [super initWithNibName:nibNameOrNil bundle:nibBundleOrNil];
    if (self) {
        // Custom initialization
    }
    return self;
}

- (void)viewDidLoad
{
    userOutput.text= temp;    [super viewDidLoad];
    // Do any additional setup after loading the view from its nib.
    //userOutput.text= temp;
    self.view.backgroundColor = [UIColor colorWithPatternImage:[UIImage imageNamed:@"pes.jpg"]];
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

- (IBAction)logout:(UIButton *)sender {
    ViewController *back=[[ViewController alloc]init];
    [self willMoveToParentViewController:back];
   [self.view removeFromSuperview];
  [self removeFromParentViewController];
  
    //[self presentModalViewController:back animated:YES];
}
@end
