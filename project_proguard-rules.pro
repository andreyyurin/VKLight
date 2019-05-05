# hide the original source file name.
#-renamesourcefileattribute SourceFile

#--------------------------------
# Android Support - v4
#--------------------------------
#https://stackoverflow.com/questions/18978706/obfuscate-android-support-v7-widget-gridlayout-issue
-dontwarn android.support.v4.**
-keep class android.support.v4.app.** { *; }
-keep interface android.support.v4.app.** { *; }
-keep class android.support.v4.** { *; }

#--------------------------------
# Android Support - v7
#--------------------------------
-dontwarn android.support.v7.**
-keep class android.support.v7.internal.** { *; }
-keep interface android.support.v7.internal.** { *; }
-keep class android.support.v7.** { *; }

#--------------------------------
# Android Support Design
#--------------------------------
#@link http://stackoverflow.com/a/31028536
-dontwarn android.support.design.**
-keep class android.support.design.** { *; }
-keep interface android.support.design.** { *; }
-keep public class android.support.design.R$* { *; }

#--------------------------------
# Android proguard internet classes duplicates bug
# @link https://stackoverflow.com/questions/33047806/proguard-duplicate-definition-of-library-class
#--------------------------------
-dontnote android.net.http.*
-dontnote org.apache.commons.codec.**
-dontnote org.apache.http.**

#--------------------------------
# OkHttp
#--------------------------------
-dontwarn okhttp3.**
-dontwarn okio.**
-dontwarn javax.annotation.**
-dontwarn org.conscrypt.**

-dontwarn com.squareup.okhttp3.**
-keep class com.squareup.okhttp3.** { *; }
-keep interface com.squareup.okhttp3.** { *; }

# A resource is loaded with a relative path so the package of this class must be preserved.
-keepnames class okhttp3.internal.publicsuffix.PublicSuffixDatabase

#--------------------------------
# Retrofit
#--------------------------------
-dontwarn okio.**
-dontwarn retrofit2.Platform$Java8

-dontwarn org.codehaus.**
-dontwarn java.nio.**
-dontwarn java.lang.invoke.**
-dontwarn rx.**

#--------------------------------
# DATA MODULE data classes
#--------------------------------

#-keep class livetyping.com.confa_v30.data.models.** { *; }

#--------------------------------
# Error with proguard
# @link: https://github.com/google/dagger/issues/645
#--------------------------------
-dontwarn com.google.errorprone.annotations.*

