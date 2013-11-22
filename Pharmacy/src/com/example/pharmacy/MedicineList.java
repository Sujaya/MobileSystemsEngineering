package com.example.pharmacy;


import android.os.Bundle;
import android.app.Activity;
import android.view.*;
import java.util.List;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;


import android.content.*;


public class MedicineList extends Activity{
	
	   
	   ListView listView;
       List<Medicine> rowItems;
       DatabaseHandler db; 
       
       
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.listofmedicines);
	        
	        Button back=(Button)findViewById(R.id.menu1);
	        Button update=(Button)findViewById(R.id.update1);
	        
	        db=new DatabaseHandler(this);
	     
	        rowItems = new ArrayList<Medicine>();
	        Medicine m=new Medicine("Name","Quantity");
	        db.deleteMedicine(m);
	        
	     
	        rowItems = db.getAllMedicines();
	       
	        
	    
            listView = (ListView) findViewById(R.id.listView1);
	        
	       CustomListView adapter = new CustomListView(this,
	                R.layout.list_item, rowItems);
	        
	       listView.setAdapter(adapter);

	        
	        back.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
					Intent mainIntent = new Intent(MedicineList.this,MenuList.class);
		             startActivity(mainIntent);
		             finish();
					
				}
			});
	        
	        update.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
					Intent mainIntent = new Intent(MedicineList.this,Update.class);
		             startActivity(mainIntent);
		             finish();
					
				}
			});
	 }
	 
	 

}
