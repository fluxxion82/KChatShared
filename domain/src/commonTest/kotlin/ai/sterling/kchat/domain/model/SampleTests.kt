package ai.sterling.kchat.domain.model

import ai.sterling.kchat.domain.model.Sample
import kotlin.test.Test
import kotlin.test.assertTrue

class SampleTests {
    @Test
    fun testMe() {
        assertTrue(Sample().checkMe() > 0)
    }
}