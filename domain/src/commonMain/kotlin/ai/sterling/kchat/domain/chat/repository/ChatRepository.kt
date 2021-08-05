package ai.sterling.kchat.domain.chat.repository

import ai.sterling.kchat.domain.chat.model.ChatMessage
import kotlinx.coroutines.flow.Flow

interface ChatRepository {
    fun getChatMessages(): Flow<ChatMessage>
    suspend fun sendChatMessage(message: ChatMessage)
    suspend fun deleteAllChatMessages()
}
