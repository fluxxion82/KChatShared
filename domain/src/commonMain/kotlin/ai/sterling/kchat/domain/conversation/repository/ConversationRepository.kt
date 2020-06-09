package ai.sterling.kchat.domain.conversation.repository

import ai.sterling.kchat.domain.conversation.model.Conversation
import kotlinx.coroutines.flow.Flow

interface ConversationRepository {
    fun getConversation(): Flow<Conversation>
    suspend fun updateChatPayloads(payload: List<String>)
}