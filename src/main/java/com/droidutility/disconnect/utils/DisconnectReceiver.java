package com.droidutility.disconnect.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

import com.droidutility.logapplication.DroidApplication;
import com.droidutility.utils.DroidUtil;

/**
 * This class checks for the broadcast intents with action like ACTION_SHUTDOWN and ACTION_BOOT_COMPLETED
 *
 * @author ravikumar
 */
public class DisconnectReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equalsIgnoreCase(Intent.ACTION_BOOT_COMPLETED)) {
            int shutDownCode = PreferenceManager.getDefaultSharedPreferences(DroidApplication.getsContext()).getInt(
                    DisconnectConstants.KEY_NORMAL, 0);

            // Checking for the last shutdown value
            if (shutDownCode == 1) {
                // Reset the last value
                Editor editor = PreferenceManager.getDefaultSharedPreferences(DroidApplication.getsContext()).edit();
                editor.putInt(DisconnectConstants.KEY_NORMAL, 0);
                editor.commit();

                postShutDown(false);
            } else if (shutDownCode == 0) {
                postShutDown(true);
            }
        } else if (intent.getAction().equalsIgnoreCase(Intent.ACTION_SHUTDOWN)) {
            Editor editor = PreferenceManager.getDefaultSharedPreferences(DroidApplication.getsContext()).edit();
            editor.putInt(DisconnectConstants.KEY_NORMAL, 1);
            editor.commit();
        }
    }

    /**
     * This method is to be overridden by subclasses to provide implementation specific to reboot of device.
     *
     * @param iParams boolean representing last shutdown state
     */
    public void postShutDown(Object iParams) {
        // TODO Override this method
        DroidUtil.LogV(DisconnectReceiver.class.getSimpleName(), "Last shutdown state was :" + ((Boolean) iParams));
    }
}
