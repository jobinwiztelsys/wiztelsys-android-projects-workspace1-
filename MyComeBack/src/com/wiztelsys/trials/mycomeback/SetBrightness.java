package com.wiztelsys.trials.mycomeback;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class SetBrightness extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		super.onCreate(savedInstanceState);
		
	
		 
		
		    
		setContentView(R.layout.brightnesspage);
		Button lbrightness=(Button)findViewById(R.id.lbrightness);
		Button mbrightness=(Button)findViewById(R.id.mbrightness);
		Button hbrightness=(Button)findViewById(R.id.hbrightness);
	/*hbrightness.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent i= new Intent(SetBrightness.this,highbrightness.class);
			startActivity(i);
			 Toast.makeText(getBaseContext(), "max brightness redirected" , Toast.LENGTH_SHORT ).show(); 
		}
	});
	*/
		
	
mbrightness.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent i= new Intent(SetBrightness.this,midbrightness.class);
			startActivity(i);
			 Toast.makeText(getBaseContext(), "mid brightness redirected" , Toast.LENGTH_SHORT ).show(); 
		}
	});
lbrightness.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent i= new Intent(SetBrightness.this,lowbrightness.class);
			startActivity(i);
			 Toast.makeText(getBaseContext(), "low brightness redirected" , Toast.LENGTH_SHORT ).show(); 
		}
	});
			
		}
	public void	highbrightness(View view)
	{
		WindowManager.LayoutParams lp = getWindow().getAttributes();
		lp.screenBrightness=1;
	    getWindow().setAttributes(lp);
	    Toast.makeText(getBaseContext(), "max brightness set" , Toast.LENGTH_SHORT ).show(); 
	}
	
	
		
	}


