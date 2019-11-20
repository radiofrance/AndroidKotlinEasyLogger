package com.radiofrance.logger

import android.os.Build
import android.util.Log

private val LOG_TAG_MAX_LENGTH = if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.N) 23 else 100
const val DEFAULT_TAG = "DefaultLogTag"
const val DEFAULT_MESSAGE = " "

internal fun makeLogTag(stackTrace: Array<StackTraceElement>? = Thread.currentThread().stackTrace, defaultTag: String = DEFAULT_TAG) =
    stackTrace
        ?.firstOrNull { it.fileName != "VMStack.java" && it.fileName != "Thread.java" && it.fileName != "LogInline.kt" }
        ?.let { stack ->
            stack.className.split(".").last().split("\$Companion").first().replace("$", "::") +
                    (stack.methodName.takeIf { it != "invoke" }?.let { "::$it" } ?: "")
        }
        ?.take(LOG_TAG_MAX_LENGTH)
        ?: defaultTag

/**
 * No Operation
 */
fun logv(msg: String? = ":") = -1

/**
 * No Operation
 */
fun logv(tag: String, msg: String) = -1

/**
 * No Operation
 */
fun logv(msg: String, tr: Throwable) = -1

/**
 * No Operation
 */
fun logv(tag: String, msg: String, tr: Throwable) = -1

/**
 * No Operation
 */
fun logd(msg: String? = ":") = -1

/**
 * No Operation
 */
fun logd(tag: String, msg: String) = -1

/**
 * No Operation
 */
fun logd(msg: String, tr: Throwable) = -1

/**
 * No Operation
 */
fun logd(tag: String, msg: String, tr: Throwable) = -1

/**
 * No Operation
 */
fun logi(msg: String? = ":") = -1

/**
 * No Operation
 */
fun logi(tag: String, msg: String) = -1

/**
 * No Operation
 */
fun logi(msg: String, tr: Throwable) = -1

/**
 * No Operation
 */
fun logi(tag: String, msg: String, tr: Throwable) = -1

/**
 * No Operation
 */
fun logw(msg: String? = ":") = -1

/**
 * No Operation
 */
fun logw(tag: String, msg: String) = -1

/**
 * No Operation
 */
fun logw(msg: String, tr: Throwable) = -1

/**
 * No Operation
 */
fun logw(tag: String, msg: String, tr: Throwable) = -1

/**
 * Send a [.ERROR] log message.
 *
 * @param msg The message you would like logged.
 */
fun loge(msg: String? = DEFAULT_MESSAGE) = log(Log.ERROR, null, msg, null)

/**
 * Send a [.ERROR] log message.
 *
 * @param tag Used to identify the source of a log message. It usually identifies the class or activity where the log call occurs.
 * @param msg The message you would like logged.
 */
fun loge(tag: String, msg: String) = log(Log.ERROR, tag, msg, null)

/**
 * Send a [.ERROR] log message and log the exception.
 *
 * @param msg The message you would like logged.
 * @param tr An exception to log
 */
fun loge(msg: String, tr: Throwable) = log(Log.ERROR, null, msg, tr)

/**
 * Send a [.ERROR] log message and log the exception.
 *
 * @param tag Used to identify the source of a log message. It usually identifies the class or activity where the log call occurs.
 * @param msg The message you would like logged.
 * @param tr An exception to log
 */
fun loge(tag: String, msg: String, tr: Throwable) = log(Log.ERROR, tag, msg, tr)

/**
 * Send a [.DEBUG] log message and log the exception.
 *
 * @param level The log level
 * @param tag Used to identify the source of a log message. It usually identifies the class or activity where the log call occurs.
 * @param msg The message you would like logged.
 * @param tr An exception to log
 */
private fun log(level: Int, tag: String?, msg: String? = DEFAULT_MESSAGE, tr: Throwable?): Int {
    val tagNonNull = tag ?: makeLogTag()
    return when (level) {
        Log.VERBOSE -> Log.v(tagNonNull, msg, tr)
        Log.DEBUG -> Log.d(tagNonNull, msg, tr)
        Log.INFO -> Log.i(tagNonNull, msg, tr)
        Log.WARN -> Log.w(tagNonNull, msg, tr)
        Log.ERROR -> Log.e(tagNonNull, msg, tr)
        else -> -1
    }
}

