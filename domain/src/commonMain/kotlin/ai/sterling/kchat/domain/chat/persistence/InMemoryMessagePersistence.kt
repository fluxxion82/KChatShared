package ai.sterling.kchat.domain.chat.persistence

import ai.sterling.kchat.domain.base.CoroutinesContextFacade
import ai.sterling.kchat.domain.chat.model.MessageEvent
import ai.sterling.kinject.Inject
import ai.sterling.kinject.Singleton
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.withContext

@Singleton
class InMemoryMessagePersistence @Inject constructor(
    private val contextFacade: CoroutinesContextFacade
) : ChatMessageEventPersistence {

    private val channel = ConflatedBroadcastChannel<MessageEvent>()

    override fun events(): ReceiveChannel<MessageEvent> = channel.openSubscription()

    override suspend fun update(event: MessageEvent) = withContext(contextFacade.default) {
        channel.send(event)
    }
}