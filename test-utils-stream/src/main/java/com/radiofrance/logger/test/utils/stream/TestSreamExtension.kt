package com.radiofrance.logger.test.utils.stream

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.robolectric.shadows.ShadowLog
import java.io.ByteArrayOutputStream
import java.io.PrintStream

private const val BUFFER_SIZE = 1024

fun invokeToOutputStrem(test: ()->Unit): ByteArrayOutputStream {
    val outputStream = getLogOutputStream()
    test.invoke()
    return outputStream
}

fun getLogOutputStream() = ByteArrayOutputStream(BUFFER_SIZE).apply {
    val printStream = PrintStream(this)
    ShadowLog.stream = printStream
}

fun ByteArrayOutputStream.assertMessageIsLogged(message: String) {
    val loggedMessages = this.getMessages()
    assertTrue("Expected message=\"$message\" was not found in logged messages=\"$loggedMessages\"", message in loggedMessages)
}

fun ByteArrayOutputStream.assertMessageIsNotLogged(message: String) {
    val loggedMessages = this.getMessages()
    assertFalse("Non expected message=\"$message\" was found in logged messages=\"$loggedMessages\"", message in loggedMessages)
}

fun ByteArrayOutputStream.getMessages() = this.toString().apply { print(this) }