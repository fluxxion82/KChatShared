package ai.sterling

import ai.sterling.checks.MissingNewLineAndEndOfFile
import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.detector.api.CURRENT_API
import com.android.tools.lint.detector.api.Issue

class IssuesRegistry : IssueRegistry() {

    override val issues: List<Issue>
        get() = listOf(
            MissingNewLineAndEndOfFile.issue
        )

    override val api: Int
        get() = CURRENT_API
}
