# droidutility

### A simple library project that you can use in your android projects for various application level utilities like logging, toast display and many more application services etc.

### Important about Usage:
- To use it properly you need to need create an application(**MyApplication.java**) class that extends DroidApplication and set this class as with full qualification the value for name attribute of application tag in your manifest.xml

```sh
 <application
        android:name="com.yourpackagename.activities.MyApplication"   // This attribute
        android:allowBackup="true"
        ...... >
```
        
- Now this will enable the main app to use the system services implementation defined in the library app.

### Disconnect Util Usage:

- Disconnect Utils includes the code in the package **com.droidutility.disconnect.utils** . This is a utility implementation that provides information about the last shutdown that whether it was **Normal** or **Abrupt(ShutDown due to Battery Detachment)**.
- To get it usable in your application code you will need some more changes in your **application's mainfest** file. 
    ```sh
    <!-- Permission for getting RECEIVE_BOOT_COMPLETED -->
    <uses-permission android:name="android.permission.RECEIVE_BOOT_COMPLETED" />
    ```
    And under ``` <application> ``` tag, add the following entry for receiver 
    
    ```sh
     <!-- Receiver to checks for broadcast for ACTIONs : ACTION_SHUTDOWN and ACTION_BOOT_COMPLETED -->
        <receiver android:name="com.droidutility.disconnect.utils.DisconnectReceiver" >
            <intent-filter>
                <action android:name="android.intent.action.ACTION_SHUTDOWN" />
                <action android:name="android.intent.action.BOOT_COMPLETED" />
            </intent-filter>
        </receiver>
    ```
- And the last step will be to override **postShutDown(Object iParams)** in your  ** MyApplication.java **
```sh
    @Override
	public void postShutDown(Object iParams)
	{
		super.postShutDown(iParams);
		DroidUtil.showToast(((Boolean) iParams) ? ("Last shutdown was abrupt.") : ("Last shutdown was normal."));
		
		//TODO Your app specific code 
	}
```