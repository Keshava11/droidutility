
package com.droidutility.disconnect.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.droidutility.logapplication.DroidApplication;

/**
 * This class checks for the broadcast intents with action like ACTION_SHUTDOWN and ACTION_BOOT_COMPLETED
 * 
 * @author ravikumar
 */
public class DisconnectReceiver extends BroadcastReceiver
{
	@Override
	public void onReceive(Context context, Intent intent)
	{
		if (intent.getAction().equalsIgnoreCase(Intent.ACTION_BOOT_COMPLETED))
		{
			int shutDownCode = PreferenceManager.getDefaultSharedPreferences(DroidApplication.getsContext()).getInt(
					DisconnectConstants.KEY_NORMAL, 0);

			// Checking for the last shutdown value
			if (shutDownCode == 1)
			{
				// Reset the last value
				Editor editor = PreferenceManager.getDefaultSharedPreferences(DroidApplication.getsContext()).edit();
				editor.putInt(DisconnectConstants.KEY_NORMAL, 0);
				editor.commit();

				((DroidApplication)context.getApplicationContext()).postShutDown(false);
			}
			else if (shutDownCode == 0)
			{
				((DroidApplication)context.getApplicationContext()).postShutDown(true);
			}
		}
		else if (intent.getAction().equalsIgnoreCase(Intent.ACTION_SHUTDOWN))
		{
			Editor editor = PreferenceManager.getDefaultSharedPreferences(DroidApplication.getsContext()).edit();
			editor.putInt(DisconnectConstants.KEY_NORMAL, 1);
			editor.commit();
		}
	}
}
