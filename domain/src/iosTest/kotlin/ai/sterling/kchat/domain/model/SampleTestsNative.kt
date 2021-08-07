package ai.sterling.kchat.domain.model

import ai.sterling.kchat.domain.goodbye
import kotlin.test.Test
import kotlin.test.assertTrue

class SampleTestsNative {
    @Test
    fun testHello() {
        assertTrue("iOS" in goodbye())
    }
}