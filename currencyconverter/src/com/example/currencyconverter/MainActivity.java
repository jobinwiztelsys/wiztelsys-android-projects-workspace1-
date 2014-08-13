package com.example.currencyconverter;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements
		AdapterView.OnItemSelectedListener {

	String apiurl = "http://openexchangerates.org/api/latest.json?app_id=5252e0bd65684b04b9a3b53b9d48b839";

	public static String selctedincurrencytype, selctedoutcurrencytype,	incurrencyAbbrevation, outcurrencyAbbrevation;

	String currencyTypes[] = { "British Pound	GBP", "Euro	EUR",
			"Japanese Yen	JPY", "Swiss Franc	CHF", "US Dollar	USD",
			"Australian Dollar	AUD", "Bangladeshi Taka	BDT",
			"Bhutan Ngultrum	BTN", "Brazilian Real	BRL", "Canadian Dollar	CAD",
			"Chinese Yuan/Renminbi	CNY", "Egyptian Pound	EGP",
			"Hong Kong Dollar	HKD", "Indian Rupee	INR", "Iranian Rial	IRR",
			"Iraqi Dinar	IQD", "Israeli New Shekel	ILS", "Kuwaiti Dinar	KWD",
			"Malaysian Ringgit	MYR", "Nepalese Rupee	NPR",
			"Pakistan Rupee	PKR", "Philippine Peso	PHP", "Russian Rouble	RUB",
			"Saudi Riyal	SAR", "Singapore Dollar	SGD",
			"South African Rand	ZAR", "South-Korean Won	KRW",
			"Sri Lanka Rupee	LKR", "United Arab Emir Dirham	AED" };

	Spinner fromSpinner, toSpinner;
	
	public static float fromcurrencyRate,toCurrencyRate,finalResult, currencyCount;
	
	EditText currencyCountET;
	
	TextView incurrency, outcurency;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		fromcurrencyRate=0;
		toCurrencyRate=0;
		finalResult=0; 
		currencyCount=0;
		currencyCountET = (EditText) findViewById(R.id.currencyValueET);
		fromSpinner = (Spinner) findViewById(R.id.fromCurrencySpinner);
		toSpinner = (Spinner) findViewById(R.id.toCurrencySpinner);
		ArrayAdapter<String> a1 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, currencyTypes);
		fromSpinner.setAdapter(a1);
		fromSpinner.setOnItemSelectedListener(this);
		toSpinner = (Spinner) findViewById(R.id.toCurrencySpinner);
		toSpinner.setAdapter(a1);
		toSpinner.setOnItemSelectedListener(this);
		incurrency = (TextView) findViewById(R.id.incurrencytypeTV);
		outcurency = (TextView) findViewById(R.id.OutCurrencyrateTV);
		
		
		

	}

	public void currencyConvert(View view)
	{
		currencyCount = Float.parseFloat(currencyCountET.getText().toString());
		new getWebPageTask().execute(apiurl);
		
		if(finalResult==0)
		{
			Toast.makeText(this, "Loading...\n Please try after some time",Toast.LENGTH_SHORT).show();
		}
		else
		{
		incurrency.setText(currencyCount + " " + incurrencyAbbrevation + "="+ finalResult + "" + outcurrencyAbbrevation);
		finalResult=0;
		currencyCount =0;
	
		}
	}


	private String getWebsite(String address) {
		StringBuffer stringBuffer = new StringBuffer();
		BufferedReader reader = null;
		try {
			URL url = new URL(address);
			HttpURLConnection urlConnection = (HttpURLConnection) url
					.openConnection();
			InputStream in = new BufferedInputStream(
					urlConnection.getInputStream());
			reader = new BufferedReader(new InputStreamReader(in));
			String line = "";
			while ((line = reader.readLine()) != null) {
				stringBuffer.append(line);

			}
		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			if (reader != null) {
				try {
					reader.close();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return stringBuffer.toString();
	}

	public class getWebPageTask extends AsyncTask<String, Void, String> {

		@Override
		protected void onPostExecute(String result) {
			Log.d("jobin", result);
			super.onPostExecute(result);

			try {
				Log.d("jobin ", "in the try block");
				JSONObject jsonObj = new JSONObject(result);
				JSONObject ratesobj = jsonObj.getJSONObject("rates");
				float inCurrencyvalue = (float) ratesobj
						.getDouble(incurrencyAbbrevation);
				float outCurrencyvalue = (float) ratesobj
						.getDouble(outcurrencyAbbrevation);

				finalResult = currencyCount
						* (outCurrencyvalue / inCurrencyvalue);
				Log.d("jobin", finalResult+"");
			
			} catch (JSONException e) {

				Log.d("Jobin:error", e+"");
			}

		}

		@Override
		protected void onPreExecute() {

			super.onPreExecute();
		}

		@Override
		protected void onProgressUpdate(Void... values) {

			super.onProgressUpdate(values);
		}

		@Override
		protected String doInBackground(String... params) {

			return getWebsite(apiurl);

		}

	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View view, int arg2,
			long arg3) {

		TextView spinnertxt = (TextView) view;

		switch (arg0.getId()) {
		case (R.id.fromCurrencySpinner): {
			selctedincurrencytype = spinnertxt.getText().toString();
		//	Toast.makeText(this, "incurrency" + selctedincurrencytype,Toast.LENGTH_LONG).show();
			int start = (selctedincurrencytype.length()) - 3;

			incurrencyAbbrevation = selctedincurrencytype.substring(start,
					selctedincurrencytype.length());

		}
		case (R.id.toCurrencySpinner): {
			selctedoutcurrencytype = spinnertxt.getText().toString();
		//	Toast.makeText(this, "outcurrency" + selctedoutcurrencytype,Toast.LENGTH_LONG).show();
			int start = (selctedoutcurrencytype.length()) - 3;

			outcurrencyAbbrevation = selctedoutcurrencytype.substring(start,
					selctedoutcurrencytype.length());
		}

		}

	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {

	}
}
