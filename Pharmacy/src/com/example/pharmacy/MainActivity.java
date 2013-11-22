package com.example.pharmacy;





import android.os.Bundle;
import android.app.Activity;
import android.view.*;
import android.graphics.Color;
import android.widget.*;
import android.os.*;
import android.content.*;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
    	final int SPLASH = 3000;
    	
    	
        super.onCreate(savedInstanceState); 
        setContentView(R.layout.activity_main);
        
        TextView textView = (TextView) findViewById(R.id.text);
        textView.setTextColor(Color.BLACK);
        
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(MainActivity.this,MenuList.class);
                startActivity(mainIntent);
                finish();
            }
        },  SPLASH);
        
       
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}






