package ai.sterling.kchat.domain

import kotlinx.coroutines.CoroutineScope
import kotlin.coroutines.CoroutineContext

expect fun runBlockingTest(block: suspend CoroutineScope.() -> Unit)
expect val testCoroutineContext: CoroutineContext
