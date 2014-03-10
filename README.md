droidutility
============
A simple library project that you can use in your android projects for various application level utilities like logging, toast display and many more application services etc.

Important about Usage:

To use it properly you need to need create an application(MyApplication.java) class that extends DroidApplication 

and set this class as with full qualification the value for name attribute of application tag in your manifest.xml

 <application
        android:name="com.yourpackagename.activities.MyApplication"   // This attribute
        android:allowBackup="true"
        ...... >
        
Now this will enable the main app to use the system services implementation defined in the library app.
        
        
        
