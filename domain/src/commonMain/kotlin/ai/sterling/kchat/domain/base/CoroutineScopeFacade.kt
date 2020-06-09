package ai.sterling.kchat.domain.base

import ai.sterling.kinject.Inject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

interface CoroutineScopeFacade {
    val globalScope: CoroutineScope
}

internal class DefaultScopeFacade @Inject constructor(
    contextFacade: CoroutinesContextFacade
) : CoroutineScopeFacade {
    val job = SupervisorJob()
    override val globalScope: CoroutineScope = CoroutineScope(contextFacade.default + job)
}
