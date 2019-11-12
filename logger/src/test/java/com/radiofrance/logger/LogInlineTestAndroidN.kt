package com.radiofrance.logger

import android.os.Build
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.N])
class LogInlineTestAndroidN {

    @Test
    fun `makeLogTag returning automatic tag on stacktrace`() {
        // Given
        val stackTraceElements = arrayOf(
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
                "methodName",
                "MainActivity.kt",
                110
            )
        )

        // When
        val tag = makeLogTag(stackTraceElements)

        // Then
        assertEquals("MainActivity::methodName:".take(LOG_TAG_MAX_LENGTH), tag)
    }

}