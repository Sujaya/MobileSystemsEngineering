package com.example.pharmacy;


public class Medicine {
	
	//private variables
	
	String _name;
	String _quantity;
	
	// Empty constructor
	public Medicine(){
		
	}
	
	
	// constructor
	public Medicine(String name, String _quantity){
		this._name = name;
		this._quantity = _quantity;
	}

	
	
	// getting name
	public String getName(){
		return this._name;
	}
	
	// setting name
	public void setName(String name){
		this._name = name;
	}
	
	// getting phone number
	public String getQuantity(){
		return this._quantity;
	}
	
	// setting phone number
	public void setQuantity(String quantity){
		this._quantity = quantity;
	}
}

