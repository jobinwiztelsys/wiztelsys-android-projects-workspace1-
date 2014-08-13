package com.wiztelsys.trials.mycomeback;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class home extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_page);
		Button gameBtn=(Button)findViewById(R.id.gamebtn);
		Button brightnessbtn=(Button)findViewById(R.id.brightnessbtn);
		
		gameBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i =new Intent(home.this, gamepage.class);
				startActivity(i);
			}
		});
		
		
		Button mapButton=(Button)findViewById(R.id.mapbtn);
		mapButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent I=new Intent(home.this,mappage.class);
				startActivity(I);
				
			}
		});
		brightnessbtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent j=new Intent(home.this,SetBrightness.class);
				startActivity(j);
				
			}
		});
	}
	

}
