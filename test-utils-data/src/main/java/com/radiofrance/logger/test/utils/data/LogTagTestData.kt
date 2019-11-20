package com.radiofrance.logger.test.utils.data

data class LogTagTestData(
    val name: String,
    val stacktrace: Array<StackTraceElement>,
    val defaultTag: String,
    val expectedLogTag: String,
    val expectedLogTagOnAndroidLowerThanO: String
) {

    override fun toString() = name

    companion object {
        private const val DEFAULT_TAG = "DefaultTestLogTag"
        private const val TAG_SIZE_MAX_ON_ANDROID_LOWER_THAN_O = 23

        val TEST_PARAMS = listOf(
            arrayOf(
                LogTagTestData(
                    name = "Test Default tag on empty stacktrace",
                    stacktrace = emptyArray(),
                    defaultTag = DEFAULT_TAG,
                    expectedLogTag = DEFAULT_TAG,
                    expectedLogTagOnAndroidLowerThanO = DEFAULT_TAG.take(TAG_SIZE_MAX_ON_ANDROID_LOWER_THAN_O)
                )
            ),
            arrayOf(
                LogTagTestData(
                    name = "Test correct tag on stacktrace with class name and method name",
                    stacktrace = arrayOf(
                        StackTraceElement(
                            "dalvik.system.VMStack",
                            "getThreadStackTrace",
                            "VMStack.java",
                            0
                        ),
                        StackTraceElement(
                            "java.lang.Thread",
                            "getStackTrace",
                            "Thread.java",
                            1555
                        ),
                        StackTraceElement(
                            "com.radiofrance.logger.demo.MainActivity",
                            "onCreate",
                            "MainActivity.kt",
                            110
                        )
                    ),
                    defaultTag = DEFAULT_TAG,
                    expectedLogTag = "MainActivity::onCreate",
                    expectedLogTagOnAndroidLowerThanO = "MainActivity::onCreate".take(TAG_SIZE_MAX_ON_ANDROID_LOWER_THAN_O)
                )
            ),
            arrayOf(
                LogTagTestData(
                    name = "Test correct tag on stacktrace with class name and very long method name",
                    stacktrace = arrayOf(
                        StackTraceElement(
                            "dalvik.system.VMStack",
                            "getThreadStackTrace",
                            "VMStack.java",
                            0
                        ),
                        StackTraceElement(
                            "java.lang.Thread",
                            "getStackTrace",
                            "Thread.java",
                            1555
                        ),
                        StackTraceElement(
                            "com.radiofrance.logger.demo.MainActivity",
                            "onLongLongLongLongLongLongLongLongLongCreate",
                            "MainActivity.kt",
                            110
                        )
                    ),
                    defaultTag = DEFAULT_TAG,
                    expectedLogTag = "MainActivity::onLongLongLongLongLongLongLongLongLongCreate",
                    expectedLogTagOnAndroidLowerThanO = "MainActivity::onLongLongLongLongLongLongLongLongLongCreate".take(TAG_SIZE_MAX_ON_ANDROID_LOWER_THAN_O)
                )
            ),
            arrayOf(
                LogTagTestData(
                    name = "Test correct tag on stacktrace with class name and method name, avoiding Companion kitlin subclass",
                    stacktrace = arrayOf(
                        StackTraceElement(
                            "dalvik.system.VMStack",
                            "getThreadStackTrace",
                            "VMStack.java",
                            0
                        ),
                        StackTraceElement(
                            "java.lang.Thread",
                            "getStackTrace",
                            "Thread.java",
                            1555
                        ),
                        StackTraceElement(
                            "com.radiofrance.logger.demo.MainActivity\$Companion\$getParameters\$1",
                            "onCreate",
                            "MainActivity.kt",
                            110
                        )
                    ),
                    defaultTag = DEFAULT_TAG,
                    expectedLogTag = "MainActivity::onCreate",
                    expectedLogTagOnAndroidLowerThanO = "MainActivity::onCreate".take(TAG_SIZE_MAX_ON_ANDROID_LOWER_THAN_O)
                )
            ),
            arrayOf(
                LogTagTestData(
                    name = "Test correct tag on stacktrace with inner class name and method name",
                    stacktrace = arrayOf(
                        StackTraceElement(
                            "dalvik.system.VMStack",
                            "getThreadStackTrace",
                            "VMStack.java",
                            0
                        ),
                        StackTraceElement(
                            "java.lang.Thread",
                            "getStackTrace",
                            "Thread.java",
                            1555
                        ),
                        StackTraceElement(
                            "com.radiofrance.echoes.core.domain.player.PlayerDomain\$AutoRefreshInfoDataHandler",
                            "reset",
                            "PlayerDomain.kt",
                            605
                        )
                    ),
                    defaultTag = DEFAULT_TAG,
                    expectedLogTag = "PlayerDomain::AutoRefreshInfoDataHandler::reset",
                    expectedLogTagOnAndroidLowerThanO = "PlayerDomain::AutoRefreshInfoDataHandler::reset".take(TAG_SIZE_MAX_ON_ANDROID_LOWER_THAN_O)
                )
            )
        )
    }

}