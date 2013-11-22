package com.example.pharmacy;

import android.os.Bundle;
import android.app.Activity;
import android.view.*;

import android.widget.*;

import android.content.*;

public class MenuList extends Activity {
	
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.menu);
	        
	        Button list=(Button)findViewById(R.id.button1);
	        Button placeorder=(Button)findViewById(R.id.button2);
	        Button del=(Button)findViewById(R.id.button4);
	        
	        del.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					 Intent mainIntent = new Intent(MenuList.this, Delete.class);
		             startActivity(mainIntent);
		             finish();
					
				}
			});
	        
	        list.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					 Intent mainIntent = new Intent(MenuList.this,MedicineList.class);
		             startActivity(mainIntent);
		             finish();
				}
			});
	        
	        placeorder.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					 Intent mainIntent = new Intent(MenuList.this,PlaceOrder.class);
		             startActivity(mainIntent);
		             finish();
				}
			});


	       
	 }

	 @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        // Inflate the menu; this adds items to the action bar if it is present.
	        getMenuInflater().inflate(R.menu.menu, menu);
	        return true;
	    }
}
