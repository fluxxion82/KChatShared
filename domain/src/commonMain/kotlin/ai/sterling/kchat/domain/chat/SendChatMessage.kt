package ai.sterling.kchat.domain.chat

import ai.sterling.kchat.domain.base.Usecase
import ai.sterling.kchat.domain.chat.model.ChatMessage
import ai.sterling.kchat.domain.chat.repository.ChatRepository
import ai.sterling.kinject.Inject

class SendChatMessage @Inject constructor(
    private val chatRepository: ChatRepository
) : Usecase<ChatMessage, Unit> {
    override suspend fun invoke(param: ChatMessage) = chatRepository.sendChatMessage(param)
}
