package ai.sterling.kchat.domain.base

import ai.sterling.kinject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Runnable
import platform.Foundation.NSRunLoop
import platform.Foundation.performBlock
import platform.darwin.dispatch_get_main_queue
import platform.darwin.dispatch_queue_t
import kotlin.coroutines.CoroutineContext

internal actual class DefaultContextFacade @Inject constructor() : CoroutinesContextFacade {
    override val io = NsQueueDispatcher(dispatch_get_main_queue())
    override val main = NsQueueDispatcher(dispatch_get_main_queue())
    override val default = Dispatchers.Default
    override val errorHandler = CoroutineExceptionHandler { _, error ->
        when (error.cause) {
            else -> throw error
        }
    }

    internal class NsQueueDispatcher(
        private val dispatchQueue: dispatch_queue_t
    ) : CoroutineDispatcher() {
        override fun dispatch(context: CoroutineContext, block: Runnable) {
            NSRunLoop.mainRunLoop().performBlock {
                block.run()
            }
        }
    }
}
