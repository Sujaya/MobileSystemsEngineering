package com.example.pharmacy;

import java.util.ArrayList;
import java.util.List;

import com.example.pharmacy.DatabaseHandler;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.view.*;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class PlaceOrder extends Activity {
	ListView listView;
    List<Medicine> rowItems;
	DatabaseHandler db = new DatabaseHandler(this);
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.placeorder);
        
        Button back=(Button)findViewById(R.id.menu3);
        Button order=(Button)findViewById(R.id.order);
        
        TextView textView1 = (TextView) findViewById(R.id.text5);
        textView1.setTextColor(Color.WHITE);
        
        TextView textView2 = (TextView) findViewById(R.id.text6);
        textView2.setTextColor(Color.WHITE);
        
      
        back.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent mainIntent = new Intent(PlaceOrder.this,MenuList.class);
	             startActivity(mainIntent);
	             finish();
				
			}
		});
        
        order.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try
				{
				boolean  noerror = true;
				AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(PlaceOrder.this);
				
				 EditText name = (EditText) findViewById(R.id.editText1);
			        String medname = name.getText().toString();
			        
			        EditText quant = (EditText) findViewById(R.id.editText2);
			        Integer quantity = Integer.parseInt(quant.getText().toString());
				
				if(medname.equals(""))
				{
					dlgAlert.setMessage("No Medicine Name mentioned");
					dlgAlert.setTitle("Invalid Medicine Name");
					dlgAlert.setPositiveButton("OK", null);
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					noerror=false;
					
					
				}
				
				if (quantity == 0)
				{
					dlgAlert.setMessage("No Quantity mentioned");
					dlgAlert.setTitle("Invalid Quantity");
					dlgAlert.setPositiveButton("OK", null);
					dlgAlert.setCancelable(true);
					dlgAlert.create().show();
					noerror=false;
				}
				
				if (noerror==true)
				{
					Medicine old_md ;
					old_md = db.getMedicine(medname);
					Integer qnt = Integer.parseInt( old_md.getQuantity()) - quantity;
					Medicine md = new Medicine(medname, qnt.toString());
					db.updateMedicine(md);
					Toast.makeText(getApplicationContext(), "Your order has been placed. The database is updated", Toast.LENGTH_LONG).show();			    
				}
				
			}
			
			catch(Exception e)
			{
				Toast.makeText(getApplicationContext(), "Invalid name or quantity", Toast.LENGTH_LONG).show();
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
