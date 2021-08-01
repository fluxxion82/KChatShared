package ai.sterling.kchat.domain.chat.repository

import ai.sterling.kchat.domain.chat.model.ChatMessage
import kotlinx.coroutines.flow.Flow

interface ChatRespository {
    fun getChatMessages(): Flow<List<ChatMessage>>
    suspend fun insertChatMessage(message: ChatMessage)
    suspend fun deleteAllChatMessages()
}