Android Kotlin Easy Logger
===

Easy Logger is a library that provide Kotlin extensions for Android logging.

No need to configure log level, just gradle link to the matching dependency.

If is not specified, Log tag is automatically generated with name of the class and current method.


Download
--------

```gradle
dependencies {
  
    // Choose log level with matching dependency
    implementation 'com.radiofrance.logger:log-noop:x.x.x'
    implementation 'com.radiofrance.logger:log-verbose:x.x.x'
    implementation 'com.radiofrance.logger:log-debug:x.x.x'
    implementation 'com.radiofrance.logger:log-info:x.x.x'
    implementation 'com.radiofrance.logger:log-warning:x.x.x'
    implementation 'com.radiofrance.logger:log-error:x.x.x'
  
}
```

*Exemple* 
- `No Operation` for `Release` variant
- `Verbose` for `Debug` variant.

```gradle
dependencies {
  
    releaseImplementation 'com.radiofrance.logger:log-noop:x.x.x'
    debugImplementation 'com.radiofrance.logger:log-verbose:x.x.x'
  
}
```


How do I use Easy Logger?
--------

```kotlin
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        logv()
        // Logcat output : "V/MainActivity::onCreate:: :"

        logv("logv with message")
        // Logcat output : "V/MainActivity::onCreate:: logv with message"

        logv("LOG_TAG", "logv with makeLogTag and message")
        // Logcat output : "V/LOG_TAG: logv with makeLogTag and message"

        logv("logv message and exception", Exception("Exception message"))
        // Logcat output : "V/MainActivity::onCreate:: logv message and exception
        //    java.lang.Exception: Exception message
        //        at com.radiofrance.logger.demo.MainActivity.onCreate(MainActivity.kt:20)
        //        at android.app.Activity.performCreate(Activity.java:6679)
        //        at android.app.Instrumentation.callActivityOnCreate(Instrumentation.java:1118)
        //        at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:2618)"

        logv("LOG_TAG", "logv with makeLogTag, message and exception", Exception("Exception message"))
        // Logcat output : "V/LOG_TAG:: logv message and exception
        //    java.lang.Exception: Exception message
        //        at com.radiofrance.logger.demo.MainActivity.onCreate(MainActivity.kt:20)
        //        at android.app.Activity.performCreate(Activity.java:6679)
        //        at android.app.Instrumentation.callActivityOnCreate(Instrumentation.java:1118)
        //        at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:2618)"

        // Logs on other levels
        logd()
        logd("logd with message")
        logd("LOG_TAG", "logd with makeLogTag and message")
        logd("logd message and exception", Exception("Exception message"))
        logd("LOG_TAG", "logd with makeLogTag, message and exception", Exception("Exception message"))

        logi()
        logi("logi with message")
        logi("LOG_TAG", "logi with makeLogTag and message")
        logi("logi message and exception", Exception("Exception message"))
        logi("LOG_TAG", "logi with makeLogTag, message and exception", Exception("Exception message"))

        logw()
        logw("logw with message")
        logw("LOG_TAG", "logw with makeLogTag and message")
        logw("logw message and exception", Exception("Exception message"))
        logw("LOG_TAG", "logw with makeLogTag, message and exception", Exception("Exception message"))

        loge()
        loge("loge with message")
        loge("LOG_TAG", "loge with makeLogTag and message")
        loge("loge message and exception", Exception("Exception message"))
        loge("LOG_TAG", "loge with makeLogTag, message and exception", Exception("Exception message"))
    }
   
}
```
