package ai.sterling.kchat.domain.di

import ai.sterling.kchat.domain.app.persistence.ForegroundEventPersistence
import ai.sterling.kchat.domain.base.CoroutineScopeFacade
import ai.sterling.kchat.domain.base.CoroutinesContextFacade
import ai.sterling.kchat.domain.chat.persistence.ChatEventPersistence
import ai.sterling.kchat.domain.settings.GetServerInfo
import ai.sterling.kchat.domain.settings.UpdateServerInfo
import ai.sterling.kchat.domain.user.GetUserState
import ai.sterling.kchat.domain.user.LoginUser
import ai.sterling.kchat.domain.user.persistences.UserEventsPersistence

interface DomainModule {
    val getServerInfo: GetServerInfo
    val updateServerInfo: UpdateServerInfo
    val loginUser: LoginUser
    val getUserState: GetUserState
//    val getChatMessages: GetChatMessages
//    val sendChatMessage: SendChatMessage
//    val exitApp: ExitApp

    fun dispatchersFacade(): CoroutinesContextFacade
    fun scopeFacade(): CoroutineScopeFacade
    fun foregroundEvent(): ForegroundEventPersistence
    fun userEvents(): UserEventsPersistence
    fun chatEvents(): ChatEventPersistence
}
