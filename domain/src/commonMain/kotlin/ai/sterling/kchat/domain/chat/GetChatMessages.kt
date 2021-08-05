package ai.sterling.kchat.domain.chat

import ai.sterling.kchat.domain.base.Usecase
import ai.sterling.kchat.domain.chat.model.ChatEvent
import ai.sterling.kchat.domain.chat.model.ChatMessage
import ai.sterling.kchat.domain.chat.persistence.ChatEventPersistence
import ai.sterling.kchat.domain.chat.repository.ChatRepository
import ai.sterling.kinject.Inject
import kotlinx.coroutines.flow.*

class GetChatMessages @Inject constructor(
    private val chatRepository: ChatRepository,
    private val chatEventPersistence: ChatEventPersistence
) : Usecase<Unit, Flow<ChatMessage>> {
    override suspend fun invoke(param: Unit): Flow<ChatMessage> = chatEventPersistence.events()
        .consumeAsFlow()
        .filter {
            println("filter event")
            it is ChatEvent.MessageReceived || it is ChatEvent.MessageSent
        }
        .map {
            println("map event")
            when (it) {
                is ChatEvent.MessageSent -> it.chatMessage
                else -> (it as ChatEvent.MessageReceived).chatMessage
            }
        }
        .onStart {
            println("on start")
            chatRepository.getChatMessages().collect { emit(it) }
        }
        .distinctUntilChanged()
}
