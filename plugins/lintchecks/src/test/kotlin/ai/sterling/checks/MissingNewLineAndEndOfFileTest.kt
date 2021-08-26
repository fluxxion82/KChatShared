package ai.sterling.checks

import ai.sterling.SingleCheckBaseTest
import com.android.tools.lint.checks.infrastructure.TestFiles.xml
import org.junit.Test

class MissingNewLineAndEndOfFileTest : SingleCheckBaseTest(MissingNewLineAndEndOfFile.issue) {

    @Test
    fun `passes on valid xml`() {
        runLint(xml("res/layout/valid.xml", "<View />\n"))
            .expectClean()
    }

    @Test
    fun `fails on xml without empty line`() {
        runLint(xml("res/layout/invalid.xml", "<View />"))
            .expect("""
            |                res/layout/invalid.xml:2: Error: Missing empty line at the end of xml file [EmptyLineAtEndOfFile]
            |1 errors, 0 warnings
            """.trimMargin())
    }
}
