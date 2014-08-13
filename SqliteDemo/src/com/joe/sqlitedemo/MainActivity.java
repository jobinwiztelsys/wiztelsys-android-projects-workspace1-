package com.joe.sqlitedemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends Activity 
{
	HelperAdapter helper;

	EditText username, address, search;
	String userstring, addressstring,searchstring,strname,straddress;


	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		username = (EditText) findViewById(R.id.usertxt);
		address = (EditText) findViewById(R.id.addresstxt);
		search=(EditText)findViewById(R.id.getaddresstxt);
		helper = new HelperAdapter(MainActivity.this);

	}

	public void adduser(View view)
	{
		userstring = username.getText().toString();
		addressstring = address.getText().toString();
		long id = helper.adduser(userstring, addressstring);
		if (id < 0)
		{
			message.message(this, "wrong");
		}
		else 
		{
			message.message(this, "success");
		}
	}
	public void viewDetails(View view)
	{
		String details=helper.viewDetails();
		message.message(this, details);
	}
	public void searchAddress(View view)
	{
		searchstring=search.getText().toString();
		message.message(this,"search started");
		String address=helper.searchaddress(searchstring);
		message.message(this, address);
	}
	public void menuredirect(View view)
	{
		Intent I= new Intent(this, page2.class);
		startActivity(I);
		/*String s1= search.getText().toString();
		strname =s1.substring(0, s1.indexOf(" "));
		straddress=s1.substring(s1.indexOf(" ")+1);
		String id=	helper.searchid(strname, straddress);
		message.message(this, id);
		*/
	}

}
