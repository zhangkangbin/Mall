# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

#AS必须加这两句
-dontwarn
-ignorewarnings
###
-optimizationpasses 7
-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclasses
-dontskipnonpubliclibraryclassmembers
-dontpreverify
-verbose
-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*

###

-keep public class * extends android.support.v4.**
-keep public class * extends android.app.Fragment
-keep public class * extends android.app.Application
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.preference.Preference
-keep public class com.android.vending.licensing.ILicensingService


-keep class com.jeremyfeinstein.slidingmenu.lib.**{*;}



-keepattributes Signature
-keepattributes *Annotation*
-dontwarn android.support.v4.**
-keep class org.jsoup.**


-keep class android.support.v4.** {
    <fields>;
    <methods>;
}

-keep interface  android.support.v4.app.** {
    <fields>;
    <methods>;
}





-keepclasseswithmembernames class * {
    native <methods>;
}

-keepclasseswithmembernames class * {
   public <init>(android.content.Context, android.util.AttributeSet);
}

-keepclasseswithmembernames class * {
   public <init>(android.content.Context, android.util.AttributeSet, int);
}

-keepclassmembers public class * extends android.view.View {
   void set*(***);
   *** get*();
}

-keepclassmembers class * extends android.app.Activity {
    public void *(android.view.View);
}

-keepclassmembers enum * {
   public static **[] values();
   public static ** valueOf(java.lang.String);
}

-keep class * implements android.os.Parcelable {
   public static final android.os.Parcelable$Creator *;
}

-keep class * implements android.os.Parcelable {
    <methods>;
}


-keepclassmembers class **.R$* {
    public static <fields>;
}

-keep class * extends android.widget.LinearLayout {
    public static final android.widget.LinearLayout$OnClickListener *;
    public static final android.widget.LinearLayout$OnTouchListener *;
}

-keep class * extends android.view.View {
    public static final android.view.View$OnClickListener *;
    public static final android.view.View$OnTouchListener *;
}

-keep public class * extends android.widget.LinearLayout {
    public *;
}

-keep public class * extends android.view.View {
    public *;
}

#混淆时把Log代码删除,log不会打包进去
-assumenosideeffects class android.util.Log {
    public static boolean isLoggable(java.lang.String, int);
    public static *** v(...);
    public static *** i(...);
    public static *** w(...);
    public static *** d(...);
    public static *** e(...);
}

-keep class android.**{*;}
-keep class **.Res$*
-keep class **.R
-keep class **.R$*{*;}


-dontwarn com.tencent.bugly.**
-keep public class com.tencent.bugly.**{*;}
-keep class android.support.**{*;}


##
-dontwarn okhttp3.**
-dontnote okhttp3.**
-keep class okhttp3.**{*;}
##
-dontwarn retrofit2.**
-dontnote retrofit2.**
-keep class retrofit2.**{*;}
##

##
-dontwarn java.lang.ref.**
-dontnote java.lang.ref.**
-keep class java.lang.ref.**{*;}

##---------------leakcanary----------
-dontwarn com.squareup.leakcanary.**
-dontnote com.squareup.leakcanary.**
-keep class com.squareup.leakcanary.**{*;}
##---------------leakcanary----------

##---------------64k方法----------
-keep class android.support.multidex.** {
  *;
}
