package ai.sterling.kchat.domain.model

import ai.sterling.kchat.domain.hello
import kotlin.test.Test
import kotlin.test.assertTrue

class SampleTestsJVM {
    @Test
    fun testHello() {
        assertTrue("JVM" in hello())
    }
}