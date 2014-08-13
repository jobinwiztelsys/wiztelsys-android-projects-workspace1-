package com.wiztelsys.sqlitedemo2;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	dbhelperadapter object;
	Button b1;
	EditText e1,e2;
	String s1,s2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	
		setContentView(R.layout.activity_main);
		e1=(EditText)findViewById(R.id.usrtxt);
		e2=(EditText)findViewById(R.id.adrstxt);
	
		object = new dbhelperadapter(MainActivity.this);
		
	}

	public void adduser(View view)
	{
		s1=e1.getText().toString();
		s2=e2.getText().toString();
		long id=object.adduser(s1, s2);
		if( id<0)
		{
			Toast.makeText(this," error", Toast.LENGTH_LONG).show();
		}
		else
		{
		Toast.makeText(this,id+" success", Toast.LENGTH_LONG).show();
		}
		
	}
}
