//
//  ViewController.m
//  loginPRS
//
//  Created by MSE on 19/09/13.
//  Copyright (c) 2013 MSE. All rights reserved.
//

#import "ViewController.h"

@interface ViewController ()

@end

@implementation ViewController

@synthesize username, password;
- (void)viewDidLoad
{
    //NSAutoreleasePool *pool = [[NSAutoreleasePool alloc] init];
    [super viewDidLoad];
	// Do any additional setup after loading the view, typically from a nib.
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

- (IBAction)submit:(UIButton *)sender {
    
    if([password.text isEqualToString:username.text] )
    {
        newViewController *newView = [[newViewController alloc]initWithNibName:@"newViewController" bundle:[NSBundle mainBundle]];
        /*newViewController *newView = [[newViewController alloc]init];
         */
        
        [newView setTemp:username.text ];
       [self addChildViewController:newView];

        [self.view addSubview:newView.view];
        [newView didMoveToParentViewController:self];
        newView = nil;
        //[self presentModalViewController:newView animated:YES];
    }
    else
    {
        UIAlertView *message = [[UIAlertView alloc]initWithTitle:@"Error" message:@"Invalid password" delegate:nil cancelButtonTitle:@"OK" otherButtonTitles: nil];
       [message show];
    }
        
}
@end
