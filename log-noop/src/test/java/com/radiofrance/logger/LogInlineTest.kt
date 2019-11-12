package com.radiofrance.logger

import com.radiofrance.logger.test.utils.stream.getMessages
import com.radiofrance.logger.test.utils.stream.invokeToOutputStrem
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.ParameterizedRobolectricTestRunner

@RunWith(ParameterizedRobolectricTestRunner::class)
class LogInlineTest(private val logExecution: () -> Unit) {

    companion object {
        @JvmStatic
        @ParameterizedRobolectricTestRunner.Parameters(name="{index}: Test log empty outputStream")
        fun getParameters() = listOf(
            arrayOf( { logv() }),
            arrayOf( { logv("This is a verbose message.") }),
            arrayOf( { logv("TEST_TAG", "This is a verbose message.") }),
            arrayOf( { logv("This is a verbose message.", Exception("This a test exception")) }),
            arrayOf( { logv("TEST_TAG", "This is a verbose message.", Exception("This a test exception")) }),
            arrayOf( { logd() }),
            arrayOf( { logd("This is a debug message.") }),
            arrayOf( { logd("TEST_TAG", "This is a debug message.") }),
            arrayOf( { logd("This is a debug message.", Exception("This a test exception")) }),
            arrayOf( { logd("TEST_TAG", "This is a debug message.", Exception("This a test exception")) }),
            arrayOf( { logi() }),
            arrayOf( { logi("This is a info message.") }),
            arrayOf( { logi("TEST_TAG", "This is a info message.") }),
            arrayOf( { logi("This is a info message.", Exception("This a test exception")) }),
            arrayOf( { logi("TEST_TAG", "This is a info message.", Exception("This a test exception")) }),
            arrayOf( { logw() }),
            arrayOf( { logw("This is a warn message.") }),
            arrayOf( { logw("TEST_TAG", "This is a warn message.") }),
            arrayOf( { logw("This is a warn message.", Exception("This a test exception")) }),
            arrayOf( { logw("TEST_TAG", "This is a warn message.", Exception("This a test exception")) }),
            arrayOf( { loge() }),
            arrayOf( { loge("This is a error message.") }),
            arrayOf( { loge("TEST_TAG", "This is a error message.") }),
            arrayOf( { loge("This is a error message.", Exception("This a test exception")) }),
            arrayOf( { loge("TEST_TAG", "This is a error message.", Exception("This a test exception")) })
        )
    }

    @Test
    fun test() {
        // When
        invokeToOutputStrem(logExecution).let { outputStream ->
            // Then
            Assert.assertTrue("Log outputStream should be empty", outputStream.getMessages().isEmpty())
        }
    }

}
