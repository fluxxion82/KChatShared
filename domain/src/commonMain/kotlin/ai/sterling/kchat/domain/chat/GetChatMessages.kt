package ai.sterling.kchat.domain.chat

import ai.sterling.kchat.domain.base.Usecase
import ai.sterling.kchat.domain.chat.model.ChatMessage
import ai.sterling.kchat.domain.chat.repository.ChatRespository
import ai.sterling.kinject.Inject
import kotlinx.coroutines.flow.Flow

class GetChatMessages @Inject constructor(
    private val chatRepository: ChatRespository
) : Usecase<Unit, Flow<List<ChatMessage>>> {
    override suspend fun invoke(param: Unit): Flow<List<ChatMessage>> = chatRepository.getChatMessages()
}
