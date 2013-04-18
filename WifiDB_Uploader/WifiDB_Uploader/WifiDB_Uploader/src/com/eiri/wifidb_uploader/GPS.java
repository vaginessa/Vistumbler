package com.eiri.wifidb_uploader;

import java.util.List;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;

public class GPS {
	private static final String TAG = "GPSClass";
	
	public double[] getGPS() {
		 LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		 List<String> providers = lm.getProviders(true);
		 
		 Location l = null;
		 
		 for (int i=providers.size()-1; i>=0; i--) {
		  l = lm.getLastKnownLocation(providers.get(i));
		  if (l != null) break;
		 }
		 
		 double[] gps = new double[2];
		 if (l != null) {
		  gps[0] = l.getLatitude();
		  gps[1] = l.getLongitude();
		 }
		 Log.d(TAG, "GPS:: Lat: " + gps[0] + " -- Long: " + gps[1]);
		 return gps;
	}

	private LocationManager getSystemService(String locationService) {
		// TODO Auto-generated method stub
		return null;
	}
}