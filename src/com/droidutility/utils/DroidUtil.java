package com.droidutility.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;
import com.droidutility.logapplication.DroidApplication;

/**
 * Class providing debugging utilities and toast notification while debugging
 * 
 * @author ravikumar
 */
public class DroidUtil {
	/**
	 * boolean that decides whether its a debug or release mode
	 */
	public static boolean DEBUG = true;

	/**
	 * Utility to show Toast messages based upon DEBUG boolean
	 * 
	 * @param iMessage
	 *            message to be shown in the Toast
	 */
	/**
	 * Utility to show Toast messages based upon DEBUG boolean
	 * 
	 * @param iMessage
	 *            message to be shown in the Toast
	 * @throws NullPointerException
	 *             nullpointer exception will occur if you didn't created a
	 *             class in your main project that extends DroidApplication
	 *             class and added it to name attribute of application tag in
	 *             your main project's manifest.xml
	 */
	public static void showToast(String iMessage) throws NullPointerException {
		if (DEBUG)
			Toast.makeText(DroidApplication.getsContext(), iMessage,
					Toast.LENGTH_SHORT).show();
	}

	/**
	 * Method for logging verbose message based upon a boolean that decides for
	 * DEBUG/RELEASE mode
	 */
	public static void LogV(String iTag, String iMessage) {
		if (DEBUG)
			Log.v(iTag, iMessage);
	}

	/**
	 * Method for logging error message based upon a boolean that decides for
	 * DEBUG/RELEASE mode
	 */
	public static void LogE(String iTag, String iMessage) {
		if (DEBUG)
			Log.e(iTag, iMessage);
	}

	/**
	 * Method for logging debug message based upon a boolean that decides for
	 * DEBUG/RELEASE mode
	 */
	public static void LogD(String iTag, String iMessage) {
		if (DEBUG)
			Log.d(iTag, iMessage);
	}

	/**
	 * Method for logging warning message based upon a boolean that decides for
	 * DEBUG/RELEASE mode
	 */
	public static void LogW(String iTag, String iMessage) {
		if (DEBUG)
			Log.w(iTag, iMessage);
	}

	/**
	 * Method for logging info message based upon a boolean that decides for
	 * DEBUG/RELEASE mode
	 */
	public static void LogI(String iTag, String iMessage) {
		if (DEBUG)
			Log.i(iTag, iMessage);
	}

	/**
	 * Method that checks if there is any active network connection available or
	 * not
	 * 
	 * @return boolean based upon availability of network connection
	 */
	public static boolean isNetworkAvailable() {
		ConnectivityManager connMgr = (ConnectivityManager) DroidApplication
				.getsContext().getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo netInfo = connMgr.getActiveNetworkInfo();
		return (netInfo != null && netInfo.isConnected());
	}

}
