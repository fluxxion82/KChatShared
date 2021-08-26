package ai.sterling.kchat.domain.di

import ai.sterling.kchat.domain.app.persistence.ForegroundEventPersistence
import ai.sterling.kchat.domain.app.persistence.InMemoryForegroundEventPersistence
import ai.sterling.kchat.domain.base.CoroutineScopeFacade
import ai.sterling.kchat.domain.base.CoroutinesContextFacade
import ai.sterling.kchat.domain.base.DefaultContextFacade
import ai.sterling.kchat.domain.base.DefaultScopeFacade
import ai.sterling.kchat.domain.chat.persistence.ChatEventPersistence
import ai.sterling.kchat.domain.chat.persistence.InMemoryChatEventPersistence
import ai.sterling.kchat.domain.settings.GetServerInfo
import ai.sterling.kchat.domain.settings.UpdateServerInfo
import ai.sterling.kchat.domain.user.GetUserState
import ai.sterling.kchat.domain.user.LoginUser
import ai.sterling.kchat.domain.user.persistences.InMemoryUserEventsPersistence
import ai.sterling.kchat.domain.user.persistences.UserEventsPersistence
import ai.sterling.kchat.domain.user.persistences.UserPreferences
import ai.sterling.kchat.domain.user.persistences.UserRepository

class DomainModuleIos(
    private val userPreferences: UserPreferences,
    private val userRepository: UserRepository
//    ,
//    private val chatRepository: ChatRepository,
//    private val chatEventPersistence: ChatEventPersistence
) : DomainModule {
    override val getServerInfo: GetServerInfo by lazy {
        GetServerInfo(userPreferences)
    }
    override val updateServerInfo: UpdateServerInfo by lazy {
        UpdateServerInfo(userPreferences)
    }
    override val loginUser: LoginUser by lazy {
        LoginUser(userRepository, userEvents(), getUserState)
    }
    override val getUserState: GetUserState by lazy {
        GetUserState(userRepository, userEvents())
    }
//    override val getChatMessages: GetChatMessages by lazy {
//        GetChatMessages(chatRepository, chatEventPersistence)
//    }
//    override val sendChatMessage: SendChatMessage by lazy {
//        SendChatMessage(chatRepository)
//    }
//    override val exitApp: ExitApp by lazy {
//        ExitApp(userRepository, scopeFacade())
//    }

    override fun dispatchersFacade(): CoroutinesContextFacade = DefaultContextFacade()

    override fun scopeFacade(): CoroutineScopeFacade = DefaultScopeFacade(dispatchersFacade())

    override fun foregroundEvent(): ForegroundEventPersistence = InMemoryForegroundEventPersistence()

    override fun userEvents(): UserEventsPersistence = InMemoryUserEventsPersistence(dispatchersFacade())

    override fun chatEvents(): ChatEventPersistence = InMemoryChatEventPersistence(dispatchersFacade())
}
