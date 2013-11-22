package com.example.pharmacy;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {

	// All Static variables
	// Database Version
	private static final int DATABASE_VERSION = 1;

	// Database Name
	private static final String DATABASE_NAME = "Pharmacy";

	// Contacts table name
	private static final String TABLE_MEDICINES = "Medicines";

	// Contacts Table Columns names
	//private static final String KEY_ID = "id";
	private static final String KEY_NAME = "MedicineName";
	private static final String KEY_QUANTITY = "Quantity";

	public DatabaseHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	// Creating Tables
	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_MEDICINES_TABLE = "CREATE TABLE " + TABLE_MEDICINES + "("
				/*+ KEY_ID + " INTEGER PRIMARY KEY,"*/ + KEY_NAME + " TEXT,"
				+ KEY_QUANTITY + " TEXT" + ")";
		db.execSQL(CREATE_MEDICINES_TABLE);
	}

	// Upgrading database
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}

	/**
	 * All CRUD(Create, Read, Update, Delete) Operations
	 */

	// Adding new medicine
	void addMedicine(Medicine medicine) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		//values.put(KEY_ID, medicine.getID());
		values.put(KEY_NAME, medicine.getName()); // Contact Name
		values.put(KEY_QUANTITY, medicine.getQuantity()); // Contact Phone

		// Inserting Row
		db.insert(TABLE_MEDICINES, null, values);
		db.close(); // Closing database connection
	}
	
	// Getting single medicine
	Medicine getMedicine(String name) {
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.query(TABLE_MEDICINES, new String[] {
				KEY_NAME, KEY_QUANTITY }, KEY_NAME + "=?",
				new String[] {name }, null, null, null, null);
		if (cursor != null)
			cursor.moveToFirst();

		Medicine medicine = new Medicine(cursor.getString(0), cursor.getString(1));
		// return contact
		return medicine;
	}
	
	// Getting All Contacts
	public List<Medicine> getAllMedicines() {
		List<Medicine> MedList = new ArrayList<Medicine>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_MEDICINES;

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Medicine medicine = new Medicine();
				//medicine.setID(cursor.getInt(0));
				medicine.setName(cursor.getString(0));
				medicine.setQuantity(cursor.getString(1));
				// Adding contact to list
				MedList.add(medicine);
			} while (cursor.moveToNext());
		}

		// return contact list
		return MedList;
	}

	// Updating single contact
	public int updateMedicine(Medicine medicine) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_NAME, medicine.getName());
		values.put(KEY_QUANTITY, medicine.getQuantity());

		// updating row
		return db.update(TABLE_MEDICINES, values, KEY_NAME + " = ?",
				new String[] { medicine.getName() });
	}

	// Deleting single contact
	public void deleteMedicine(Medicine medicine) {
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(TABLE_MEDICINES, KEY_NAME + " = ?",
				new String[] { medicine.getName() });
		db.close();
	}
	
	public List<Medicine> getAllMedicinesWithZeroQuantity() {
		List<Medicine> MedList = new ArrayList<Medicine>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_MEDICINES + " WHERE " + KEY_QUANTITY + "='0'" ;

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Medicine medicine = new Medicine();
				//medicine.setID(cursor.getInt(0));
				medicine.setName(cursor.getString(0));
				medicine.setQuantity(cursor.getString(1));
				// Adding contact to list
				MedList.add(medicine);
			} while (cursor.moveToNext());
		}
		
		return MedList;
	}

/*
	// Getting contacts Count
	public int getMedicinesCount() {
		String countQuery = "SELECT  * FROM " + TABLE_MEDICINES;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(countQuery, null);
		cursor.close();

		// return count
		return cursor.getCount();
	}*/

}
