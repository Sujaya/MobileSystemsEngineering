package com.example.pharmacy;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.*;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.app.AlertDialog;



public class Update extends Activity{
	
	static DatabaseHandler db;
	
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.addorupdate);
	        
	        db = new DatabaseHandler(this);
	        
	        TextView textView1 = (TextView) findViewById(R.id.text1);
	        textView1.setTextColor(Color.WHITE);
	        
	    
	        TextView textView3 = (TextView) findViewById(R.id.text3);
	        textView3.setTextColor(Color.WHITE);
	        

	        
	        Button back=(Button)findViewById(R.id.menu2);
	        Button update=(Button)findViewById(R.id.update2);
	        
	        
	        back.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
					Intent mainIntent = new Intent(Update.this,MenuList.class);
		             startActivity(mainIntent);
		             finish();
					
				}
			});
	        
	        update.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
				 //database update
					boolean noerror = true;
					AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(Update.this);
					
				    EditText med = (EditText) findViewById(R.id.editText1);
				    String medname = med.getText().toString();
				    
				   if (medname.equals(""))
				    {
				    	dlgAlert.setMessage("No Medicine Name mentioned");
						dlgAlert.setTitle("Invalid Medicine Name");
						dlgAlert.setPositiveButton("OK", null);
						dlgAlert.setCancelable(true);
						dlgAlert.create().show();
						noerror=false;
				    	
				    }
				    
				    EditText quant = (EditText) findViewById(R.id.editText2);
			        String quantvalue = quant.getText().toString();
			        
			        if (quantvalue.equals("") )
			        {
			        	dlgAlert.setMessage("No Quantity mentioned");
						dlgAlert.setTitle("Invalid Quantity");
						dlgAlert.setPositiveButton("OK", null);
						dlgAlert.setCancelable(true);
						dlgAlert.create().show();
						noerror=false;
						
			        	
			        }
				    
				    
			        if(noerror==true)
					{
			        	try
			        	{
			        		 Medicine medicine = db.getMedicine(medname);
			        		 Integer qnt = Integer.parseInt(medicine.getQuantity()) + Integer.parseInt(quantvalue);
			        		 medicine.setQuantity( qnt.toString());
			        		 db.updateMedicine(medicine);
			        	}
			        	
			       catch(Exception e){
			    	   
			    	   Medicine  medicine = new Medicine(medname,quantvalue);
			    	   db.addMedicine(medicine);
			    	   
			       }
			        	
			        
			       
			        
			        dlgAlert.setMessage("Database Updated");
					dlgAlert.setTitle("Database Status");
					dlgAlert.setPositiveButton("OK", null);
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					}
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
