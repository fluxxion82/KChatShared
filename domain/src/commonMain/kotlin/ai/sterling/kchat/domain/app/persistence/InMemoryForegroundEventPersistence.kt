package ai.sterling.kchat.domain.app.persistence

import ai.sterling.kinject.Inject
import ai.sterling.kinject.Singleton
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.channels.ReceiveChannel

@Singleton
internal class InMemoryForegroundEventPersistence @Inject constructor() : ForegroundEventPersistence {
    private val foregroundEvent = ConflatedBroadcastChannel<Boolean>()

    override fun getForegroundEvent(): ReceiveChannel<Boolean> = foregroundEvent.openSubscription()

    override suspend fun update(foreground: Boolean) {
        foregroundEvent.send(foreground)
    }
}
