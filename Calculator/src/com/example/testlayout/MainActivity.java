package com.example.testlayout;

import android.app.Activity;
import android.graphics.LightingColorFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	static float answer;
	static float operand1;
	StringBuffer sb;
	StringBuffer op1;
	EditText e1;
	TextView t1;
	static char operator, operator2;
	Button equalBtn;
	static int i,tempvar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		e1 = (EditText) findViewById(R.id.editText1);
		sb = new StringBuffer();
		op1 = new StringBuffer();
		operator = 'a';
		operator2 = 'b';
		tempvar=0;

		operand1 = 0;
		t1 = (TextView) findViewById(R.id.textView1);

		answer = 0;
		i = 0;
		equalBtn = (Button) findViewById(R.id.buttonEqual);
	}

	public void getInput(View view) {

		

		Button b1 = (Button) findViewById(view.getId());
		sb.append(b1.getText().toString());
		e1.append(b1.getText().toString());
		

	}

	public void calculate(View view) {

		if ((((Button) findViewById(view.getId())).getText().toString()) == "ok") {
			op1.delete(0, op1.length());
		
			sb.delete(0, sb.length());
			t1.setText("");
			e1.setText("");
			tempvar=0;
			answer = 0;
			equalBtn.setText("=");
			i = 0;
			}
	

		else {
			sb.append("=");
			i = 0;
			if (sb.length()<=3)
			{
				i=sb.length()+1;
				e1.setText("invalid");
			}
			while (i < sb.length()) {
				operator2 = operator;
				
				if ((sb.charAt(i) >= '0' && sb.charAt(i) <= '9')||sb.charAt(i) =='.') {
					op1.append(sb.charAt(i));
					i++;
					
				} 
				else {
					operator = sb.charAt(i);
					operand1 = Float.parseFloat(op1.toString());
					i++;
					Log.d("try1", "operand1"+operand1);
					
					switch (operator) {
					case ('+'):
					{
						answer = answer + operand1;
						op1.delete(0, op1.length());
						Log.d("try", ""+answer);

					}
					break;

					case ('-'): {
						if (tempvar == 0) {
							answer = answer + operand1;
							tempvar++;
						} else {
							answer = answer - operand1;
						}
						op1.delete(0, op1.length());

					}break;
					
					case ('x'): {
						if (tempvar == 0) {
							answer = answer + operand1;
							tempvar++;
						} else {
							answer = answer * operand1;
						}
						op1.delete(0, op1.length());

					}break;
					
					
					
					
					case('/'):
					{
						if(tempvar==0)
						{
							answer= answer+operand1;
							tempvar++;
							op1.delete(0, op1.length());
						
						}
						else
						{
														
							if (operand1!=0)
							{
								
							answer=answer/operand1;
							op1.delete(0, op1.length());
							
							}
							else
							{
								e1.setText("division by zero not possible");
							}
						
						}
						
						
					}
					break;
					case ('='): {

						if (operator2 == '+') {
						
							answer = answer + operand1;
							Log.d("try", ""+answer);
						}
						if (operator2 == '-') {
							answer = answer - operand1;
						}
						if (operator2 == 'x') {
							answer = answer * operand1;
						}
						if (operator2=='/')
						{
							if (operand1!=0)
							{
								answer = answer / operand1;
								Log.d("jobin: in the last if",""+answer);
							}
							else
							{
								e1.setText("division by zero not possible");
							}
						}

					}break;

					default: {
						t1.setText("invalid");
					}break;

					};

				}

			}

			t1.setText("" + answer);
			equalBtn.setText("ok");
			//equalBtn.getBackground().setColorFilter(new LightingColorFilter(0xFFFFFFFF, 0xFFAA0000));
			
		}
	}
}
