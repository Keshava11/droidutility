package com.droidutility.utils;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import com.droidutility.logapplication.DroidApplication;

public class DroidLocationServer {
	
	private static final String TAG = DroidLocationServer.class.getSimpleName();
	private static DroidLocationServer sLocationServer = null;
	private LocationManager mLocationMgr = null;
	private Location mLastLocation = null;
	
	private DroidLocationServer()
	{

	}

	public static DroidLocationServer getLocationInstance()
	{
		if (sLocationServer == null)
			sLocationServer = new DroidLocationServer();
		return sLocationServer;
	}

	public void initListener()
	{
		mLocationMgr = (LocationManager) DroidApplication.getsContext().getSystemService(
				Context.LOCATION_SERVICE);

		mLocationMgr.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, mLocationListener);
		DroidUtil.LogI(TAG, "Location Server initialieses");
	}

	private LocationListener mLocationListener = new LocationListener()
	{
		@Override
		public void onStatusChanged(String provider, int status, Bundle extras)
		{
			DroidUtil.LogD(TAG, "Status Changed :: " + provider + "--" + status + "---" + extras);
		}

		@Override
		public void onProviderEnabled(String provider)
		{
			DroidUtil.LogD(TAG, "onProviderEnabled:: " + provider);
		}

		@Override
		public void onProviderDisabled(String provider)
		{
			DroidUtil.LogD(TAG, "onProviderDisabled :: " + provider);
		}

		@Override
		public void onLocationChanged(Location location)
		{
			DroidUtil.LogV(TAG, "onLocationChanged :: " + location);
			DroidUtil.showToast("Location changed :: "+location);
			mLastLocation = location;
			stopListener();
		}
	};

	public void stopListener()
	{
		try
		{
			mLocationMgr.removeUpdates(mLocationListener);
			DroidUtil.LogI(TAG, "Location Server removed");
		}
		catch (NullPointerException e)
		{
			e.printStackTrace();
		}
	}

	public Location getmLastLocation()
	{
		if(mLastLocation==null)
		{
			DroidUtil.LogE(TAG, "Location fetched is null. So setting last known location");
//			mLastLocation=mLocationMgr.getLastKnownLocation(LocationManager.GPS_PROVIDER);
		}
		return mLastLocation;
	}

}