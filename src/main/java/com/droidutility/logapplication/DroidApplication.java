package com.droidutility.logapplication;

import android.app.Application;
import android.content.Context;

/**
 * This class is used to store the application level context
 */
public class DroidApplication extends Application {
    /**
     * Reference to {@link Context} instance
     */
    private static Context sContext = null;

    /**
     * Accessor for the application level context
     *
     * @return returns context
     */
    public static Context getsContext() {
        return sContext;
    }

    /**
     * Setting app level context
     */
    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;
    }

}
