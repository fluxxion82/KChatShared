package ai.sterling.kchat.domain.base

import ai.sterling.kinject.Inject
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers

internal actual class DefaultContextFacade @Inject constructor() : CoroutinesContextFacade {
    override val io = Dispatchers.Default
    override val main = Dispatchers.Main
    override val default = Dispatchers.Default
    override val errorHandler = CoroutineExceptionHandler { _, error ->
        when (error.cause) {
            else -> throw error
        }
    }
}
