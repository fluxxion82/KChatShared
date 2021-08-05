package ai.sterling.kchat.domain.chat.exception

import ai.sterling.kchat.domain.exception.Failure

sealed class ChatFailure {
    object GeneralChatFailure : Failure.FeatureFailure()
    data class FailedToConnect(val message: String) : Failure.FeatureFailure()
    object SendChatMessageFailure : Failure.FeatureFailure()
}
