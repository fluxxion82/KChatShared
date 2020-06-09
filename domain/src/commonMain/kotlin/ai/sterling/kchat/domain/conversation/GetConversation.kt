package ai.sterling.kchat.domain.conversation

import ai.sterling.kchat.domain.base.Usecase
import ai.sterling.kchat.domain.conversation.model.Conversation
import ai.sterling.kchat.domain.conversation.repository.ConversationRepository
import ai.sterling.kinject.Inject
import ai.sterling.kinject.Named
import kotlinx.coroutines.flow.Flow

class GetConversation @Inject constructor(
    @Named("local") private val chatRepository: ConversationRepository
) : Usecase<Unit, Flow<Conversation>> {

    override suspend fun invoke(param: Unit): Flow<Conversation> = chatRepository.getConversation()
}