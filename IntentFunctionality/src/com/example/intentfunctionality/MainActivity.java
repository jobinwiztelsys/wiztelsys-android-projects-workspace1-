package com.example.intentfunctionality;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	//Button B1,B2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
//		B1=(Button)findViewById(R.id.button1);
//		B2=(Button)findViewById(R.id.loadMap);
		
		
	}
public void movetosecondpage(View v)
{Intent I= null,chooser=null;
	
	if(v.getId()==R.id.button1)
	{
	// this intent uses package name instead of usual (this,secondclass.class)

	I=new Intent();
	I.setClassName("com.example.intentfunctionality","com.example.intentfunctionality.Secondactivity");
	startActivity(I);
	}
	
	if(v.getId()==R.id.loadMap)
	{
		
		I=new Intent(android.content.Intent.ACTION_VIEW);

		
		I.setData(Uri.parse("geo:19.076,73.000"));
	
		startActivity(I);
	}
	if (v.getId()== R.id.sendimageBtn)
	{
		Uri senduri=Uri.parse("android.resource://com.example.intentfunctionality/drawable/"+R.drawable.ic_launcher);
	I= new Intent(Intent.ACTION_SEND);
	I.setType("image/");// set that the file is an image
	I.putExtra(Intent.EXTRA_STREAM, senduri);// sets that file to send is binary
	I.putExtra(Intent.EXTRA_TEXT, "Hi, this is test mail");//adds email content
	chooser=Intent.createChooser(I, "send image");// gives a list of email apps(gmail, outlok etc..) to choose from to send the image
	startActivity(chooser);
	
	}
	
}
	}
