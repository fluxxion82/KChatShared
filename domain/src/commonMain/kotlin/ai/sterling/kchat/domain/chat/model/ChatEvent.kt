package ai.sterling.kchat.domain.chat.model

sealed class ChatEvent {
    object Connect : ChatEvent()
    object Disconnect : ChatEvent()
    data class MessageReceived(val chatMessage: ChatMessage) : ChatEvent()
    data class MessageSent(val chatMessage: ChatMessage) : ChatEvent()
    data class Error(val message: String) : ChatEvent()
}
