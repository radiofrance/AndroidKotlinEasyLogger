Android Kotlin Logger
===

This a library that provide easy Kotlin extensions for Android.

No need to configure log level, just link to the matching dependency.


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
- `Verbose` for `Debug variant.

```gradle
dependencies {
  
  releaseImplementation 'com.radiofrance.logger:log-noop:x.x.x'
  debugImplementation 'com.radiofrance.logger:log-verbose:x.x.x'
  
}
```


How to use
--------


