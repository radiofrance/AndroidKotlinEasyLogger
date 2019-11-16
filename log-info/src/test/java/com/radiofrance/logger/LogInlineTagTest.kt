package com.radiofrance.logger

import android.os.Build
import com.radiofrance.logger.test.utils.data.LogTagTestData
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.ParameterizedRobolectricTestRunner
import org.robolectric.annotation.Config


@RunWith(ParameterizedRobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.O])
class LogInlineTagTest(private val testData: LogTagTestData) {

    companion object {
        @JvmStatic
        @ParameterizedRobolectricTestRunner.Parameters(name = "{index}: {0}")
        fun getParameters() = LogTagTestData.TEST_PARAMS
    }

    @Test
    fun test() {
        with(testData) {
            // When
            val tag = makeLogTag(stacktrace, defaultTag)

            // Then
            assertEquals(tag, expectedLogTag)
        }
    }

}