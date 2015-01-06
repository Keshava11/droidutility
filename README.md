# droidutility

### A simple library project that you can use in your android projects for various application level utilities like logging, toast display, location and many more application services etc.

### Prerequisites :
- Android Studio 1.0 or above
- Android SDK 9 or above

### Important about Default Usage:
- Just checkout this branch and import it as a module to your current project in Android Studio as 
    File -> Import Module -> <path to the root of this branch>
- To use it properly you will need to add the following line in your main module's build.gradle file
    **compile project(':droidutility')**
```sh
 .....
 dependencies {
     compile fileTree(dir: 'libs', include: ['*.jar'])
     compile 'com.android.support:appcompat-v7:21.0.3'
     compile project(':droidutility')
 }
 .....
```
        
- Now this will enable the main module to use the system services implementation defined in the library app.

### Disconnect Util Usage:

- Disconnect Utils includes the code in the package **com.droidutility.disconnect.utils** . This is a utility implementation that provides information about the last shutdown that whether it was **Normal** or **Abrupt(ShutDown due to Battery Detachment)**.
- To get it usable in your application code you will need to add a class and some changes in your **application's manifest** file.
    
     You will first need to create a Receiver class that extends
    
    ```sh
            public class MyDisconnectReceiver extends DisconnectReceiver {
                @Override
                public void postShutDown(Object iParams) {
                    super.postShutDown(iParams);
                    // TODO Your app specific code like 
                    DroidUtil.showToast(((Boolean) iParams) ? ("Last shutdown was abrupt.") : ("Last shutdown was normal."));
                }
            }
        ```
    
     and then under ``` <application> ``` tag, add the following entry for receiver

    ```sh
     <!-- Receiver to checks for broadcast for ACTIONs : ACTION_SHUTDOWN and ACTION_BOOT_COMPLETED -->
        <receiver android:name="yourpackagename.MyDisconnectReceiver" >
            <intent-filter>
                <action android:name="android.intent.action.ACTION_SHUTDOWN" />
                <action android:name="android.intent.action.BOOT_COMPLETED" />
            </intent-filter>
        </receiver>
    ```
- And the last step will be to override **postShutDown(Object iParams)** in your  **MyDisconnectReceiver.java**


### Location Utils Usage
- To get Location updates with GoogleApiClient, you will need to first get the instance of LocationClientUtil
    ```sh
        LocationClientUtil locationClientUtil = LocationClientUtil.getLocationUtils();
        LocationRequest locationRequest = new LocationRequest();
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        locationClientUtil.initAndConnect(true, locationRequest);
    ```
    
- Fetch the updated location as :
    ```sh
       Location updatedLoc = locationClientUtil.getmLastLocation();
    ```
