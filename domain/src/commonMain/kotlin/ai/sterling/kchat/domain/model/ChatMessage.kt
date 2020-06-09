package ai.sterling.kchat.domain.model

data class ChatMessage(val id: Int, val username: String, val type: Int, var message: String, val date: Long)