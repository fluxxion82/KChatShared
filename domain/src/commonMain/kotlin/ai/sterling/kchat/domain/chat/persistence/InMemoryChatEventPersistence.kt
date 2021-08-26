package ai.sterling.kchat.domain.chat.persistence

import ai.sterling.kchat.domain.base.CoroutinesContextFacade
import ai.sterling.kchat.domain.chat.model.ChatEvent
import ai.sterling.kinject.Inject
import ai.sterling.kinject.Singleton
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.withContext

@Singleton
internal class InMemoryChatEventPersistence @Inject constructor(
    private val contextFacade: CoroutinesContextFacade
) : ChatEventPersistence {
    private val channel = ConflatedBroadcastChannel<ChatEvent>()

    override fun events(): ReceiveChannel<ChatEvent> = channel.openSubscription()

    override suspend fun update(event: ChatEvent) = withContext(contextFacade.default) {
        println("event update: $event")
        channel.send(event)
    }
}
