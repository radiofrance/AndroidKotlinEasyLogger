package com.radiofrance.logger.test.utils.data

import android.util.Log
import com.radiofrance.logger.logd
import com.radiofrance.logger.loge
import com.radiofrance.logger.logi
import com.radiofrance.logger.logv
import com.radiofrance.logger.logw

data class LogTestData(
    val name: String,
    val level: Int,
    val logExecution: () -> Unit,
    val messages: Array<String>
) {

    override fun toString() = name
    
    companion object {

        private const val CLASS_NAME_TAG = "LogTestData"

        private fun testMethodWithLogV() {
            logv()
        }

        val TEST_PARAMS = listOf(
            arrayOf(
                LogTestData(
                    name = "Test logv method with no message and no tag specified",
                    level = Log.VERBOSE,
                    logExecution = { logv() },
                    messages = arrayOf("V/$CLASS_NAME_TAG:")
                )
            ),
            arrayOf(
                LogTestData(
                    name = "Test logv method with no message and no tag specified, in a specific method",
                    level = Log.VERBOSE,
                    logExecution = { testMethodWithLogV() },
                    messages = arrayOf("V/$CLASS_NAME_TAG::testMethodWithLogV:")
                )
            ),
            arrayOf(
                LogTestData(
                    name = "Test logv method with message and no tag specified",
                    level = Log.VERBOSE,
                    logExecution = { logv("This is a verbose message.") },
                    messages = arrayOf("V/$CLASS_NAME_TAG: This is a verbose message.")
                )
            ),
            arrayOf(
                LogTestData(
                    name = "Test logv method with message and a tag specified",
                    level = Log.VERBOSE,
                    logExecution = { logv("TEST_TAG", "This is a verbose message.") },
                    messages = arrayOf("V/TEST_TAG: This is a verbose message.")
                )
            ),
            arrayOf(
                LogTestData(
                    name = "Test logv method with message, an exception and no tag specified",
                    level = Log.VERBOSE,
                    logExecution = { logv("This is a verbose message.", Exception("This a test exception")) },
                    messages = arrayOf("V/$CLASS_NAME_TAG: This is a verbose message.", "java.lang.Exception: This a test exception")
                )
            ),
            arrayOf(
                LogTestData(
                    name = "Test logv method with message, an exception and a tag specified",
                    level = Log.VERBOSE,
                    logExecution = { logv("TEST_TAG", "This is a verbose message.", Exception("This a test exception")) },
                    messages = arrayOf("V/TEST_TAG: This is a verbose message.", "java.lang.Exception: This a test exception")
                )
            ),
            arrayOf(
                LogTestData(
                    name = "Test logd method with no message and no tag specified",
                    level = Log.DEBUG,
                    logExecution = { logd() },
                    messages = arrayOf("D/$CLASS_NAME_TAG:")
                )
            ),
            arrayOf(
                LogTestData(
                    name = "Test logd method with message and no tag specified",
                    level = Log.DEBUG,
                    logExecution = { logd("This is a debug message.") },
                    messages = arrayOf("D/$CLASS_NAME_TAG: This is a debug message.")
                )
            ),
            arrayOf(
                LogTestData(
                    name = "Test logd method with message and a tag specified",
                    level = Log.DEBUG,
                    logExecution = { logd("TEST_TAG", "This is a debug message.") },
                    messages = arrayOf("D/TEST_TAG: This is a debug message.")
                )
            ),
            arrayOf(
                LogTestData(
                    name = "Test logd method with message, an exception and no tag specified",
                    level = Log.DEBUG,
                    logExecution = { logd("This is a debug message.", Exception("This a test exception")) },
                    messages = arrayOf("D/$CLASS_NAME_TAG: This is a debug message.", "java.lang.Exception: This a test exception")
                )
            ),
            arrayOf(
                LogTestData(
                    name = "Test logd method with message, an exception and a tag specified",
                    level = Log.DEBUG,
                    logExecution = { logd("TEST_TAG", "This is a debug message.", Exception("This a test exception")) },
                    messages = arrayOf("D/TEST_TAG: This is a debug message.", "java.lang.Exception: This a test exception")
                )
            ),
            arrayOf(
                LogTestData(
                    name = "Test logi method with no message and no tag specified",
                    level = Log.INFO,
                    logExecution = { logi() },
                    messages = arrayOf("I/$CLASS_NAME_TAG:")
                )
            ),
            arrayOf(
                LogTestData(
                    name = "Test logi method with message and no tag specified",
                    level = Log.INFO,
                    logExecution = { logi("This is a info message.") },
                    messages = arrayOf("I/$CLASS_NAME_TAG: This is a info message.")
                )
            ),
            arrayOf(
                LogTestData(
                    name = "Test logi method with message and a tag specified",
                    level = Log.INFO,
                    logExecution = { logi("TEST_TAG", "This is a info message.") },
                    messages = arrayOf("I/TEST_TAG: This is a info message.")
                )
            ),
            arrayOf(
                LogTestData(
                    name = "Test logi method with message, an exception and no tag specified",
                    level = Log.INFO,
                    logExecution = { logi("This is a info message.", Exception("This a test exception")) },
                    messages = arrayOf("I/$CLASS_NAME_TAG: This is a info message.", "java.lang.Exception: This a test exception")
                )
            ),
            arrayOf(
                LogTestData(
                    name = "Test logi method with message, an exception and a tag specified",
                    level = Log.INFO,
                    logExecution = { logi("TEST_TAG", "This is a info message.", Exception("This a test exception")) },
                    messages = arrayOf("I/TEST_TAG: This is a info message.", "java.lang.Exception: This a test exception")
                )
            ),
            arrayOf(
                LogTestData(
                    name = "Test logw method with no message and no tag specified",
                    level = Log.WARN,
                    logExecution = { logw() },
                    messages = arrayOf("W/$CLASS_NAME_TAG:")
                )
            ),
            arrayOf(
                LogTestData(
                    name = "Test logw method with message and no tag specified",
                    level = Log.WARN,
                    logExecution = { logw("This is a warn message.") },
                    messages = arrayOf("W/$CLASS_NAME_TAG: This is a warn message.")
                )
            ),
            arrayOf(
                LogTestData(
                    name = "Test logw method with message and a tag specified",
                    level = Log.WARN,
                    logExecution = { logw("TEST_TAG", "This is a warn message.") },
                    messages = arrayOf("W/TEST_TAG: This is a warn message.")
                )
            ),
            arrayOf(
                LogTestData(
                    name = "Test logw method with message, an exception and no tag specified",
                    level = Log.WARN,
                    logExecution = { logw("This is a warn message.", Exception("This a test exception")) },
                    messages = arrayOf("W/$CLASS_NAME_TAG: This is a warn message.", "java.lang.Exception: This a test exception")
                )
            ),
            arrayOf(
                LogTestData(
                    name = "Test logw method with message, an exception and a tag specified",
                    level = Log.WARN,
                    logExecution = { logw("TEST_TAG", "This is a warn message.", Exception("This a test exception")) },
                    messages = arrayOf("W/TEST_TAG: This is a warn message.", "java.lang.Exception: This a test exception")
                )
            ),
            arrayOf(
                LogTestData(
                    name = "Test loge method with no message and no tag specified",
                    level = Log.ERROR,
                    logExecution = { loge() },
                    messages = arrayOf("E/$CLASS_NAME_TAG:")
                )
            ),
            arrayOf(
                LogTestData(
                    name = "Test loge method with message and no tag specified",
                    level = Log.ERROR,
                    logExecution = { loge("This is a error message.") },
                    messages = arrayOf("E/$CLASS_NAME_TAG: This is a error message.")
                )
            ),
            arrayOf(
                LogTestData(
                    name = "Test loge method with message and a tag specified",
                    level = Log.ERROR,
                    logExecution = { loge("TEST_TAG", "This is a error message.") },
                    messages = arrayOf("E/TEST_TAG: This is a error message.")
                )
            ),
            arrayOf(
                LogTestData(
                    name = "Test loge method with message, an exception and no tag specified",
                    level = Log.ERROR,
                    logExecution = { loge("This is a error message.", Exception("This a test exception")) },
                    messages = arrayOf("E/$CLASS_NAME_TAG: This is a error message.", "java.lang.Exception: This a test exception")
                )
            ),
            arrayOf(
                LogTestData(
                    name = "Test loge method with message, an exception and a tag specified",
                    level = Log.ERROR,
                    logExecution = { loge("TEST_TAG", "This is a error message.", Exception("This a test exception")) },
                    messages = arrayOf("E/TEST_TAG: This is a error message.", "java.lang.Exception: This a test exception")
                )
            )
        )
        
    }

}