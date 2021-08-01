package ai.sterling.kchat.domain.base

import ai.sterling.logging.KLogger
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

internal actual class DefaultContextFacade @Inject constructor() : CoroutinesContextFacade {
    override val io = Dispatchers.IO
    override val main = Dispatchers.Main
    override val default = Dispatchers.Default
    override val errorHandler = CoroutineExceptionHandler { _, error ->
        KLogger.e(error) { "coroutine exception: ${error.message}" }
        when (error.cause) {
            else -> throw error
        }
    }
}
