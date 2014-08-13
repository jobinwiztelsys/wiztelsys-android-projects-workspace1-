package com.wiztelsys.sqlitedemo2;


import android.content.Context;
import android.widget.Toast;

public class message{
	
	
	public static void message(Context context, String message)
	{
		Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
	}
	
}
