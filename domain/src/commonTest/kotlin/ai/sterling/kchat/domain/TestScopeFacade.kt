package ai.sterling.kchat.domain

import ai.sterling.kchat.domain.base.CoroutineScopeFacade
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

internal class TestScopeFacade(job: Job, dispatcher: CoroutineDispatcher = Dispatchers.Unconfined) :
    CoroutineScopeFacade {
    override val globalScope: CoroutineScope = TestScope(job + dispatcher)
}

private class TestScope(override val coroutineContext: CoroutineContext) : CoroutineScope
