package com.wiztelsys.trials.mycomeback;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class mappage extends Activity {
	private GoogleMap mMap;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map);
		
		
		
		
		mMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        final LatLng CIU = new LatLng(35.21843892856462, 33.41662287712097);
        Marker ciu = mMap.addMarker(new MarkerOptions()
                                  .position(CIU).title("My Office"));
	}
	

}
