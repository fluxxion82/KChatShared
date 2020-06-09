package ai.sterling.kchat.domain.conversation

import ai.sterling.kchat.domain.base.Usecase
import ai.sterling.kchat.domain.conversation.repository.ConversationRepository
import ai.sterling.kinject.Inject
import ai.sterling.kinject.Named

class UpdateChatPayloads @Inject constructor(
    @Named("remote") private val chatRepository: ConversationRepository
) : Usecase<List<String>, Unit> {

    override suspend fun invoke(param: List<String>) = chatRepository.updateChatPayloads(param)
}