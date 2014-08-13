package com.wiztelsys.sqlitedemo2;



import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class dbhelperadapter 
{
	dbhelper dbhelperobj;
	
	public dbhelperadapter(Context context)
	{
		dbhelperobj=new dbhelper(context);
		Toast.makeText(context," constructor cllaed", Toast.LENGTH_LONG).show();
		
	}
	
	
public long adduser(String uname, String uaddress)
{
	SQLiteDatabase db = dbhelperobj.getWritableDatabase();
	ContentValues contentValues = new ContentValues();
	contentValues.put(dbhelper.UName,uname );
	contentValues.put(dbhelper.UAddress, uaddress);
	long id = db.insert(dbhelper.Table_name, null, contentValues);
	return id;
}
	
	
	
	
	static class dbhelper extends SQLiteOpenHelper
	{

		
		public dbhelper(Context context) 
		{
			super(context, Database_name, null, Database_Version);
			this.context = context;
			Toast.makeText(context," 2nd constructor cllaed", Toast.LENGTH_LONG).show();
			
		}
		
		private static final String Database_name="JobinDB";
		private static final String Table_name="mytable";
		private static final String Uid="uid";
		private static final String UName="Name";
		private static final String UAddress="Address";
		private Context context;
		private static final int Database_Version =1;

		
		private static final String createTable="CREATE TABLE "+Table_name+"("+Uid+" INTEGER PRIMARY KEY AUTOINCREMENT, "+UName+" VARCHAR (200), "+UAddress+" VARCHAR (200));";
		@Override
		public void onCreate(SQLiteDatabase db)
		{
			try {
				db.execSQL(createTable);
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				message.message(context, ""+e);
			}
			
		}
		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) 
		{
			
		}
		
		
		
		
		
	}

}
