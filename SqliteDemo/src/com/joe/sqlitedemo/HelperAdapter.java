package com.joe.sqlitedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class HelperAdapter 
{

	Helperclass helper;

	HelperAdapter(Context context) 
	{
		// helperadapeter constructor
		helper = new Helperclass(context);

	}
//////////////////////////////////////////////////////////////////////////////////////////////////////
	public long adduser(String username, String address)
	{
		SQLiteDatabase db = helper.getWritableDatabase();
		ContentValues contentValues = new ContentValues();
		contentValues.put(Helperclass.UName, username);
		contentValues.put(Helperclass.Address, address);
		long id = db.insert(Helperclass.Table_Name, null, contentValues);
		db.close();
		return id;
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////
	public String viewDetails()
	{
		SQLiteDatabase db = helper.getWritableDatabase();
		String columns[] = { helper.UID, helper.UName, helper.Address };
		Cursor cursor = db.query(helper.Table_Name, columns, null, null, null,
				null, null);
		StringBuffer buffer = new StringBuffer();
		while (cursor.moveToNext())
		{
			int id = cursor.getInt(0);
			String name = cursor.getString(1);
			String address = cursor.getString(2);
			buffer.append(id + " " + name + " " + address + "\n");
		}
		return buffer.toString();

	}
/////////////////////////////////////////////////////////////////////////////////////////////////////
	public String searchid(String name, String address)
	{

		SQLiteDatabase db = helper.getWritableDatabase();
		String columns[] = { helper.UID };
		String selectionArgs[] = {name,address};
		Cursor cursor = db.query(helper.Table_Name, columns, helper.UName
				+" =? AND "+ helper.Address +" =?", selectionArgs, null, null, null);
		StringBuffer buffer = new StringBuffer();
		while (cursor.moveToNext()) 
		{
			
			int indexid = cursor.getColumnIndex(helper.UID);
			int id = cursor.getInt(indexid);
			buffer.append(id + "\n");

		}
		return buffer.toString();

	}
////////////////////////////////////////////////////////////////////////////////////////////////////
	public String searchaddress(String searchstring)
	{
		SQLiteDatabase db = helper.getWritableDatabase();
		String columns[] = { helper.UName, helper.Address };

		Cursor cursor;

		cursor = db.query(helper.Table_Name, columns, helper.UName + " = '"
				+ searchstring + "'", null, null, null, null);

		StringBuffer buffer = new StringBuffer();
		while (cursor.moveToNext())
		{
			int nameindex = cursor.getColumnIndex(helper.UName);
			int addressint = cursor.getColumnIndex(helper.Address);
			String name = cursor.getString(nameindex);
			String address = cursor.getString(addressint);
			buffer.append(name + " " + address + "\n");

		}
		return buffer.toString();

	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		public void deleterecord(String deletename) 
		{
			
			SQLiteDatabase db=helper.getWritableDatabase();
			String whereArgs[]={deletename};
			db.delete(helper.Table_Name, helper.UName+"=?", whereArgs);

		}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		public void updaterecord(String oldname, String newname) 
		{
			SQLiteDatabase db=helper.getWritableDatabase();
			ContentValues contentValues=new ContentValues();
			contentValues.put(helper.UName, newname);
			String whereArgs[]={oldname};
			db.update(helper.Table_Name,contentValues, helper.UName+"=?", whereArgs);
			
			
		}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		public void truncate()
		{
			SQLiteDatabase db=helper.getWritableDatabase();
			
			db.delete(helper.Table_Name,null , null);
			//db.execSQL("DELETE FROM "+helper.Table_Name);
			
		}


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	static class Helperclass extends SQLiteOpenHelper 
	{

		public Helperclass(Context context) 
		{
			// helperclass constructor
			super(context, Database_Name, null, Database_Version);
			this.context = context;
			message.message(context, "constructor called");

		}
/////////////////////////////////////////////////////////////////////////////////////////////////////
		private static final String Database_Name = "MyDB";
		private static final String Table_Name = "Data_Table";
		private static final String UID = "_Id";
		private static final String UName = "Name";
		private static final String Address = "Address";
		private static final String Create_Table = "CREATE TABLE " + Table_Name
				+ "( " + UID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + UName
				+ " VARCHAR(255), " + Address + " VARCHAR(255));";
		private static final String Drop_Table = "DROP TABLE IF EXISTS "
				+ Table_Name + ";";
		private static final int Database_Version = 6;
		private Context context;
/////////////////////////////////////////////////////////////////////////////////////////////////////
		@Override
		public void onCreate(SQLiteDatabase db) 
		{
			// TODO Auto-generated method stub
			try {
				
				db.execSQL(Create_Table);
				message.message(context, "table created ");
				} 
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				message.message(context, "" + e);
			}

		}
/////////////////////////////////////////////////////////////////////////////////////////////////////
		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
		{
			// TODO Auto-generated method stub
			try {
				
				db.execSQL(Drop_Table);
				message.message(context, "on upgrade was called");
				onCreate(db);
				}
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				message.message(context, "" + e);
			}
		}

	}


	
	
}
