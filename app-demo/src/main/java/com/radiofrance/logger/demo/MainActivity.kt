package com.radiofrance.logger.demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.radiofrance.logger.logd
import com.radiofrance.logger.loge
import com.radiofrance.logger.logi
import com.radiofrance.logger.logv
import com.radiofrance.logger.logw

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        methodContainingLogs()
    }

    private fun methodContainingLogs() {
        logv()
        logv("logv with message")
        logv("LOG_TAG", "logv with makeLogTag and message")
        logv("logv message and exception", Exception("Exception message"))
        logv("LOG_TAG", "logv with makeLogTag, message and exception", Exception("Exception message"))

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
