@file:Suppress("NOTHING_TO_INLINE")

package fr.radiofrance.logger

import android.util.Log
import com.radiofrance.logger.BuildConfig

inline fun tag() =
    Thread.currentThread().stackTrace
        .first { it.fileName.endsWith(".kt") }
        .let { stack -> "${stack.fileName.removeSuffix(".kt")}::${stack.methodName}:" }

/**
 * Send a [.VERBOSE] log message.
 *
 * @param msg The message you would like logged.
 */
inline fun logv(msg: String? = ":") = log(Log.VERBOSE, tag(), msg, null)

/**
 * Send a [.VERBOSE] log message.
 *
 * @param tag Used to identify the source of a log message. It usually identifies the class or activity where the log call occurs.
 * @param msg The message you would like logged.
 */
inline fun logv(tag: String, msg: String) = log(Log.VERBOSE, tag, msg, null)

/**
 * Send a [.VERBOSE] log message and log the exception.
 *
 * @param msg The message you would like logged.
 * @param tr An exception to log
 */
inline fun logv(msg: String, tr: Throwable) = log(Log.VERBOSE, tag(), msg, tr)

/**
 * Send a [.VERBOSE] log message and log the exception.
 *
 * @param tag Used to identify the source of a log message. It usually identifies the class or activity where the log call occurs.
 * @param msg The message you would like logged.
 * @param tr An exception to log
 */
inline fun logv(tag: String, msg: String, tr: Throwable) = log(Log.VERBOSE, tag, msg, tr)

/**
 * Send a [.DEBUG] log message.
 *
 * @param msg The message you would like logged.
 */
inline fun logd(msg: String? = ":") = log(Log.DEBUG, tag(), msg, null)

/**
 * Send a [.DEBUG] log message.
 *
 * @param tag Used to identify the source of a log message. It usually identifies the class or activity where the log call occurs.
 * @param msg The message you would like logged.
 */
inline fun logd(tag: String, msg: String) = log(Log.DEBUG, tag, msg, null)

/**
 * Send a [.DEBUG] log message and log the exception.
 *
 * @param msg The message you would like logged.
 * @param tr An exception to log
 */
inline fun logd(msg: String, tr: Throwable) = log(Log.DEBUG, tag(), msg, tr)

/**
 * Send a [.DEBUG] log message and log the exception.
 *
 * @param tag Used to identify the source of a log message. It usually identifies the class or activity where the log call occurs.
 * @param msg The message you would like logged.
 * @param tr An exception to log
 */
inline fun logd(tag: String, msg: String, tr: Throwable) = log(Log.DEBUG, tag, msg, tr)

/**
 * Send a [.INFO] log message.
 *
 * @param msg The message you would like logged.
 */
inline fun logi(msg: String? = ":") = log(Log.INFO, tag(), msg, null)

/**
 * Send a [.INFO] log message.
 *
 * @param tag Used to identify the source of a log message. It usually identifies the class or activity where the log call occurs.
 * @param msg The message you would like logged.
 */
inline fun logi(tag: String, msg: String) = log(Log.INFO, tag, msg, null)

/**
 * Send a [.INFO] log message and log the exception.
 *
 * @param msg The message you would like logged.
 * @param tr An exception to log
 */
inline fun logi(msg: String, tr: Throwable) = log(Log.INFO, tag(), msg, tr)

/**
 * Send a [.INFO] log message and log the exception.
 *
 * @param tag Used to identify the source of a log message. It usually identifies the class or activity where the log call occurs.
 * @param msg The message you would like logged.
 * @param tr An exception to log
 */
inline fun logi(tag: String, msg: String, tr: Throwable) = log(Log.INFO, tag, msg, tr)

/**
 * Send a [.WARN] log message.
 *
 * @param msg The message you would like logged.
 */
inline fun logw(msg: String? = ":") = log(Log.WARN, tag(), msg, null)

/**
 * Send a [.WARN] log message.
 *
 * @param tag Used to identify the source of a log message. It usually identifies the class or activity where the log call occurs.
 * @param msg The message you would like logged.
 */
inline fun logw(tag: String, msg: String) = log(Log.WARN, tag, msg, null)

/**
 * Send a [.WARN] log message and log the exception.
 *
 * @param msg The message you would like logged.
 * @param tr An exception to log
 */
inline fun logw(msg: String, tr: Throwable) = log(Log.WARN, tag(), msg, tr)

/**
 * Send a [.WARN] log message and log the exception.
 *
 * @param tag Used to identify the source of a log message. It usually identifies the class or activity where the log call occurs.
 * @param msg The message you would like logged.
 * @param tr An exception to log
 */
inline fun logw(tag: String, msg: String, tr: Throwable) = log(Log.WARN, tag, msg, tr)

/**
 * Send a [.ERROR] log message.
 *
 * @param msg The message you would like logged.
 */
inline fun loge(msg: String? = ":") = log(Log.ERROR, tag(), msg, null)

/**
 * Send a [.ERROR] log message.
 *
 * @param tag Used to identify the source of a log message. It usually identifies the class or activity where the log call occurs.
 * @param msg The message you would like logged.
 */
inline fun loge(tag: String, msg: String) = log(Log.ERROR, tag, msg, null)

/**
 * Send a [.ERROR] log message and log the exception.
 *
 * @param msg The message you would like logged.
 * @param tr An exception to log
 */
inline fun loge(msg: String, tr: Throwable) = log(Log.ERROR, tag(), msg, tr)

/**
 * Send a [.ERROR] log message and log the exception.
 *
 * @param tag Used to identify the source of a log message. It usually identifies the class or activity where the log call occurs.
 * @param msg The message you would like logged.
 * @param tr An exception to log
 */
inline fun loge(tag: String, msg: String, tr: Throwable) = log(Log.ERROR, tag, msg, tr)

/**
 * Send a [.DEBUG] log message and log the exception.
 *
 * @param level The log level
 * @param tag Used to identify the source of a log message. It usually identifies the class or activity where the log call occurs.
 * @param msg The message you would like logged.
 * @param tr An exception to log
 */
inline fun log(level: Int, tag: String, msg: String? = ":", tr: Throwable?): Int {
    if (level < BuildConfig.LOG_LEVEL) {
        return -1
    }
    return when (level) {
        Log.VERBOSE -> Log.v(tag, msg, tr)
        Log.DEBUG -> Log.d(tag, msg, tr)
        Log.INFO -> Log.i(tag, msg, tr)
        Log.WARN -> Log.w(tag, msg, tr)
        Log.ERROR -> Log.e(tag, msg, tr)
        else -> -1
    }
}
