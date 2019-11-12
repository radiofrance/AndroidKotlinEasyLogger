package com.radiofrance.logger

import android.os.Build
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.O])
class LogInlineTest {

    @Test(expected = NoClassDefFoundError::class)
    fun `logv expected NoClassDefFoundError in logger module`() {
        logv()
    }

    @Test(expected = NoClassDefFoundError::class)
    fun `logd expected NoClassDefFoundError in logger module`() {
        logd()
    }

    @Test(expected = NoClassDefFoundError::class)
    fun `logi expected NoClassDefFoundError in logger module`() {
        logi()
    }

    @Test(expected = NoClassDefFoundError::class)
    fun `logw expected NoClassDefFoundError in logger module`() {
        logw()
    }

    @Test(expected = NoClassDefFoundError::class)
    fun `loge expected NoClassDefFoundError in logger module`() {
        loge()
    }

    @Test
    fun `makeLogTag returning default tag on empty stacktrace`() {
        // Given
        val stackTraceElements = emptyArray<StackTraceElement>()

        // When
        val tag = makeLogTag(stackTraceElements)

        // Then
        assertEquals("DefaultLogTag", tag)
    }

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
        assertEquals("MainActivity::methodName", tag)
    }
    @Test
    fun `makeLogTag returning automatic tag on stacktrace with encapsuled class`() {
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
                "com.radiofrance.logger.demo.MainActivity\$Companion\$getParameters\$1",
                "methodName",
                "MainActivity.kt",
                110
            )
        )

        // When
        val tag = makeLogTag(stackTraceElements)

        // Then
        assertEquals("MainActivity::methodName", tag)
    }

}