
package com.droidutility.logapplication;

import com.droidutility.utils.DroidUtil;
import android.app.Application;
import android.content.Context;

/**
 * This class is used to store the application level context
 */
public class DroidApplication extends Application
{
	/**
	 * Reference to {@link Context} instance
	 */
	private static Context sContext = null;

	/**
	 * Accessor for the application level context
	 * 
	 * @return returns context
	 */
	public static Context getsContext()
	{
		return sContext;
	}

	/**
	 * Setting app level context
	 */
	@Override
	public void onCreate()
	{
		super.onCreate();
		sContext = this;
	}

	/**
	 * This method is to be overridden by subclasses to provide implementation specific to reboot of device.
	 * 
	 * @param iParams boolean representing last shutdown state
	 */
	public void postShutDown(Object iParams)
	{
		// TODO Override this method
	}
}
