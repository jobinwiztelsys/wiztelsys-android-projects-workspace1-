package com.Wiztelsys.mysplendidapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button moveon=(Button)findViewById(R.id.moveOnBtn);
		moveon.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i= new Intent(MainActivity.this,Home.class);
				startActivity(i);
			}
		});

	}

	

}
