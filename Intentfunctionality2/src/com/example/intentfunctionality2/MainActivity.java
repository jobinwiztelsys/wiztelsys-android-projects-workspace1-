package com.example.intentfunctionality2;


import java.io.File;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;

public class MainActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	}

	public void handleClick(View v)
	{
		Intent i = null, chooser = null; 
		if (v == findViewById(R.id.intentMapBtn))
		{
			i = new Intent(android.content.Intent.ACTION_VIEW);
			i.setData(Uri.parse("geo:9.371390, 76.710908"));
			chooser = Intent.createChooser(i, "send image");
			startActivity(chooser);
		}
		if (v == findViewById(R.id.intentImageUploadBtn))
		{
			Uri j = Uri
					.parse("android.resource://com.example.intentfunctionality2/drawable/"
							+ R.drawable.ic_launcher);
			i = new Intent(Intent.ACTION_SEND);
			i.setType("image/*");
			i.putExtra(Intent.EXTRA_STREAM, j);
			i.putExtra(Intent.EXTRA_TEXT, "Hi, i have send an image");
			chooser = Intent.createChooser(i, "send image");
			startActivity(chooser);
			Log.d("jobin", "chooser executed");

		}
		if (v == findViewById(R.id.intentPlayserviceBtn))
		{
			i = new Intent(android.content.Intent.ACTION_VIEW);
			i.setData(Uri
					.parse("market://details?id=com.kiloo.subwaysurf&hl=en"));
			chooser = Intent.createChooser(i, "download subway surfers");
			startActivity(chooser);
		}
		if (v == findViewById(R.id.intentSendimgSDCardBtn)) 
		{

			File pics=Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
			String piclist[]=pics.list();
			Uri uri=null;
			ArrayList<Uri>arraylist=new ArrayList<Uri>();
			for(String picture: piclist)
			{
				uri=Uri.parse("file://"+pics.toString()+"/"+picture);
				arraylist.add(uri);
			}
			i= new Intent(Intent.ACTION_SEND_MULTIPLE);
			i.setType("image/*");
			i.putExtra(Intent.EXTRA_STREAM, arraylist);
			chooser = Intent.createChooser(i, "send multiple images");
			startActivity(chooser);
		}
				
			
			


		if (v == findViewById(R.id.intentSendEmailBtn)) 
		{

			i= new Intent(Intent.ACTION_SEND);
			i.setData(Uri.parse("mailto:"));
			String to[]={"jophi89@gmail.com"};
			i.putExtra(Intent.EXTRA_EMAIL,to);
			i.putExtra(Intent.EXTRA_SUBJECT, "send from my app");
			i.putExtra(Intent.EXTRA_TEXT, "hi, this is body of text");
			i.setType("message/rfc822");
			chooser = Intent.createChooser(i, "send email");
			startActivity(chooser);
		}

	}

}
