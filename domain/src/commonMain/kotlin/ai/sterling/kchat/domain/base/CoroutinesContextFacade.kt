package ai.sterling.kchat.domain.base

import kotlin.coroutines.CoroutineContext

interface CoroutinesContextFacade {
    val io: CoroutineContext
    val main: CoroutineContext
    val default: CoroutineContext
    val errorHandler: CoroutineContext
}

internal expect class DefaultContextFacade
