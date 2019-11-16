package com.radiofrance.logger

import android.os.Build
import android.util.Log

private val LOG_TAG_MAX_LENGTH = if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.N) 23 else 100
const val DEFAULT_TAG = "DefaultLogTag"
const val DEFAULT_MESSAGE = " "

internal fun makeLogTag(stackTrace: Array<StackTraceElement>? = Thread.currentThread().stackTrace, defaultTag: String = DEFAULT_TAG) =
    stackTrace
        ?.firstOrNull { it.fileName != "VMStack.java" && it.fileName != "Thread.java" && it.fileName != "LogInline.kt"}
        ?.let { stack -> "${stack.className.split(".").last().split("$").first()}::${stack.methodName}" }
        ?.take(LOG_TAG_MAX_LENGTH)
        ?: defaultTag

/**
 * Send a [.VERBOSE] log message.
 *
 * @param msg The message you would like logged.
 */
fun logv(msg: String? = DEFAULT_MESSAGE) = log(Log.VERBOSE, null, msg, null)

/**
 * Send a [.VERBOSE] log message.
 *
 * @param tag Used to identify the source of a log message. It usually identifies the class or activity where the log call occurs.
 * @param msg The message you would like logged.
 */
fun logv(tag: String, msg: String) = log(Log.VERBOSE, tag, msg, null)

/**
 * Send a [.VERBOSE] log message and log the exception.
 *
 * @param msg The message you would like logged.
 * @param tr An exception to log
 */
fun logv(msg: String, tr: Throwable) = log(Log.VERBOSE, null, msg, tr)

/**
 * Send a [.VERBOSE] log message and log the exception.
 *
 * @param tag Used to identify the source of a log message. It usually identifies the class or activity where the log call occurs.
 * @param msg The message you would like logged.
 * @param tr An exception to log
 */
fun logv(tag: String, msg: String, tr: Throwable) = log(Log.VERBOSE, tag, msg, tr)

/**
 * Send a [.DEBUG] log message.
 *
 * @param msg The message you would like logged.
 */
fun logd(msg: String? = DEFAULT_MESSAGE) = log(Log.DEBUG, null, msg, null)

/**
 * Send a [.DEBUG] log message.
 *
 * @param tag Used to identify the source of a log message. It usually identifies the class or activity where the log call occurs.
 * @param msg The message you would like logged.
 */
fun logd(tag: String, msg: String) = log(Log.DEBUG, tag, msg, null)

/**
 * Send a [.DEBUG] log message and log the exception.
 *
 * @param msg The message you would like logged.
 * @param tr An exception to log
 */
fun logd(msg: String, tr: Throwable) = log(Log.DEBUG, null, msg, tr)

/**
 * Send a [.DEBUG] log message and log the exception.
 *
 * @param tag Used to identify the source of a log message. It usually identifies the class or activity where the log call occurs.
 * @param msg The message you would like logged.
 * @param tr An exception to log
 */
fun logd(tag: String, msg: String, tr: Throwable) = log(Log.DEBUG, tag, msg, tr)

/**
 * Send a [.INFO] log message.
 *
 * @param msg The message you would like logged.
 */
fun logi(msg: String? = DEFAULT_MESSAGE) = log(Log.INFO, null, msg, null)

/**
 * Send a [.INFO] log message.
 *
 * @param tag Used to identify the source of a log message. It usually identifies the class or activity where the log call occurs.
 * @param msg The message you would like logged.
 */
fun logi(tag: String, msg: String) = log(Log.INFO, tag, msg, null)

/**
 * Send a [.INFO] log message and log the exception.
 *
 * @param msg The message you would like logged.
 * @param tr An exception to log
 */
fun logi(msg: String, tr: Throwable) = log(Log.INFO, null, msg, tr)

/**
 * Send a [.INFO] log message and log the exception.
 *
 * @param tag Used to identify the source of a log message. It usually identifies the class or activity where the log call occurs.
 * @param msg The message you would like logged.
 * @param tr An exception to log
 */
fun logi(tag: String, msg: String, tr: Throwable) = log(Log.INFO, tag, msg, tr)

/**
 * Send a [.WARN] log message.
 *
 * @param msg The message you would like logged.
 */
fun logw(msg: String? = DEFAULT_MESSAGE) = log(Log.WARN, null, msg, null)

/**
 * Send a [.WARN] log message.
 *
 * @param tag Used to identify the source of a log message. It usually identifies the class or activity where the log call occurs.
 * @param msg The message you would like logged.
 */
fun logw(tag: String, msg: String) = log(Log.WARN, tag, msg, null)

/**
 * Send a [.WARN] log message and log the exception.
 *
 * @param msg The message you would like logged.
 * @param tr An exception to log
 */
fun logw(msg: String, tr: Throwable) = log(Log.WARN, null, msg, tr)

/**
 * Send a [.WARN] log message and log the exception.
 *
 * @param tag Used to identify the source of a log message. It usually identifies the class or activity where the log call occurs.
 * @param msg The message you would like logged.
 * @param tr An exception to log
 */
fun logw(tag: String, msg: String, tr: Throwable) = log(Log.WARN, tag, msg, tr)

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

