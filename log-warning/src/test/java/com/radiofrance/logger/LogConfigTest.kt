package com.radiofrance.logger

import android.util.Log
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner


@RunWith(RobolectricTestRunner::class)
class LogConfigTest {

    companion object {
        private const val EXPECTED_LEVEL = Log.WARN
    }

    @Test
    fun `LogConfig return correct level`() {
        Assert.assertEquals(EXPECTED_LEVEL, LogConfig.getLevel())
    }

}