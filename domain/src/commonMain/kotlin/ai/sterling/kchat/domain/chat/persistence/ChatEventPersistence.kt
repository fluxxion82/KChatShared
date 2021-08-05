package ai.sterling.kchat.domain.chat.persistence

import ai.sterling.kchat.domain.chat.model.ChatEvent
import kotlinx.coroutines.channels.ReceiveChannel

interface ChatEventPersistence {
    fun events(): ReceiveChannel<ChatEvent>
    suspend fun update(event: ChatEvent)
}
