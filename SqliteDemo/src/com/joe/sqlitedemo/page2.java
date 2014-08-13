package com.joe.sqlitedemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class page2 extends Activity{
	HelperAdapter helperobj;
	EditText e1;
	Button B1,B2,B3;
	String strname;
	String straddress,id,deletename;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.page12);
		helperobj =new HelperAdapter(page2.this);
		e1=(EditText)findViewById(R.id.searchidtxt);
		B1=(Button)findViewById(R.id.searchbtn);
		B1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
							
				String s1= e1.getText().toString();
			strname =s1.substring(0, s1.indexOf(" "));
			straddress=s1.substring(s1.indexOf(" ")+1);
			
			String id=	helperobj.searchid(strname, straddress);
				message.message(page2.this, id);
			}
			
		} );
		
	}
	public void deleterecord(View view)
	{
		deletename=e1.getText().toString();
		helperobj.deleterecord(deletename);
		
	}
	public void update(View view)
	{
		String s=e1.getText().toString();
		String sub1=(s.substring(0, s.indexOf(" ")));
		String sub2=(s.substring(s.indexOf(" ")+1));
	//	Toast.makeText(page2.this, "hi", Toast.LENGTH_SHORT).show();
	
		helperobj.updaterecord(sub1,sub2);
	}
	public void truncate(View view)
	{
		helperobj.truncate();
		
	}
	

}
