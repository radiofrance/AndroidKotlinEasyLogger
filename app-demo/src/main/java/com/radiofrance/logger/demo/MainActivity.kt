package com.radiofrance.logger.demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import fr.radiofrance.logger.logd
import fr.radiofrance.logger.loge
import fr.radiofrance.logger.logi
import fr.radiofrance.logger.logv
import fr.radiofrance.logger.logw

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        logv()
        logd()
        logi()
        logw()
        loge()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        testMethod()
    }

    private fun testMethod() {
        logv()
        logv("logd with message")
        logv("LOG_TAG", "logd with tag and message")
        logv("logd message and exception", Exception("Exception message"))
        logv("LOG_TAG", "logd with tag, message and exception", Exception("Exception message"))

        logd()
        logd("logd with message")
        logd("LOG_TAG", "logd with tag and message")
        logd("logd message and exception", Exception("Exception message"))
        logd("LOG_TAG", "logd with tag, message and exception", Exception("Exception message"))

        logi()
        logi("logd with message")
        logi("LOG_TAG", "logd with tag and message")
        logi("logd message and exception", Exception("Exception message"))
        logi("LOG_TAG", "logd with tag, message and exception", Exception("Exception message"))

        logw()
        logw("logd with message")
        logw("LOG_TAG", "logd with tag and message")
        logw("logd message and exception", Exception("Exception message"))
        logw("LOG_TAG", "logd with tag, message and exception", Exception("Exception message"))

        loge()
        loge("logd with message")
        loge("LOG_TAG", "logd with tag and message")
        loge("logd message and exception", Exception("Exception message"))
        loge("LOG_TAG", "logd with tag, message and exception", Exception("Exception message"))
    }
}
