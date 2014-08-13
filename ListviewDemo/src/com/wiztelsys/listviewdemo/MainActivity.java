package com.wiztelsys.listviewdemo;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemClickListener {
ListView lv;
String days[]={"sun", "mon", "tue", "wed", "thu", "fri", "sat","jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lv=(ListView)findViewById(R.id.listView1);
		ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,days);
		lv.setAdapter(arrayAdapter);
		lv.setOnItemClickListener(this);
	}
	@Override
	public void onItemClick(AdapterView<?> lv, View view, int i, long arg3) {
		// TODO Auto-generated method stub
		TextView temptv=  (TextView) view;
		Toast.makeText(this, temptv.getText()+""+i,Toast.LENGTH_LONG).show();
		
	}

	
}
