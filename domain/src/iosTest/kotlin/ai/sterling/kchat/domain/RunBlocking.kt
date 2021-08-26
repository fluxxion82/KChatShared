package ai.sterling.kchat.domain

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Runnable
import kotlinx.coroutines.runBlocking
import platform.darwin.dispatch_async
import platform.darwin.dispatch_get_main_queue
import kotlin.coroutines.CoroutineContext

actual val testCoroutineContext: CoroutineContext =
    MainDispatcher()
actual fun runBlockingTest(block: suspend CoroutineScope.() -> Unit) =
    runBlocking(testCoroutineContext) { this.block() }

private class MainDispatcher : CoroutineDispatcher() {
    override fun dispatch(context: CoroutineContext, block: Runnable) {
        dispatch_async(dispatch_get_main_queue()) { block.run() }
    }
}
