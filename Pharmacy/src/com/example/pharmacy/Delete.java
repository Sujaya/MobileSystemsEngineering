package com.example.pharmacy;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Delete extends Activity {
	DatabaseHandler db = new DatabaseHandler(this);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_delete);
		Button del =(Button)findViewById(R.id.button1);
		del.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(Delete.this);
				EditText med = (EditText) findViewById(R.id.editText1);
			    String medname = med.getText().toString();
			    
			   if (medname.equals(""))
			    {
			    	dlgAlert.setMessage("No Medicine Name mentioned");
					dlgAlert.setTitle("Invalid Medicine Name");
					dlgAlert.setPositiveButton("OK", null);
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
							    	
			    }
			   else
			   {
				   Medicine medicine = db.getMedicine(medname);
				   Log.i("suj",medicine.getName());
				   db.deleteMedicine(medicine);
				 Toast.makeText( getApplicationContext(), "Deleted", Toast.LENGTH_LONG).show();
				 
				   
			   }
				 
			   
			}
		});
		Button back=(Button)findViewById(R.id.button2);
		
		back.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent mainIntent = new Intent(Delete.this,MenuList.class);
	             startActivity(mainIntent);
	             finish();
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_delete, menu);
		
		
		
		return true;
	}

}
