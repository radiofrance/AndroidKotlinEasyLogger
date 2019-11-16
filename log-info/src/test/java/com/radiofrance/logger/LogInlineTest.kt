package com.radiofrance.logger

import android.os.Build
import android.util.Log
import com.radiofrance.logger.test.utils.data.LogTestData
import com.radiofrance.logger.test.utils.stream.assertMessageIsLogged
import com.radiofrance.logger.test.utils.stream.assertMessageIsNotLogged
import com.radiofrance.logger.test.utils.stream.invokeToOutputStrem
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.ParameterizedRobolectricTestRunner
import org.robolectric.annotation.Config


@RunWith(ParameterizedRobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.O])
class LogInlineTest(private val testData: LogTestData) {

    companion object {
        @JvmStatic
        @ParameterizedRobolectricTestRunner.Parameters(name = "{index}: {0}")
        fun getParameters() = LogTestData.TEST_PARAMS
    }

    @Test
    fun test() {
        with(testData) {
            // When
            invokeToOutputStrem(logExecution).let { outputStream ->
                // Then
                messages.forEach {
                    if (level >= Log.INFO) {
                        outputStream.assertMessageIsLogged(it)
                    } else {
                        outputStream.assertMessageIsNotLogged(it)
                    }
                }
            }
        }
    }

}