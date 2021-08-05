package ai.sterling.kchat.domain.di

import ai.sterling.kchat.domain.app.persistence.ForegroundEventPersistence
import ai.sterling.kchat.domain.app.persistence.InMemoryForegroundEventPersistence
import ai.sterling.kchat.domain.base.CoroutineScopeFacade
import ai.sterling.kchat.domain.base.CoroutinesContextFacade
import ai.sterling.kchat.domain.base.DefaultContextFacade
import ai.sterling.kchat.domain.base.DefaultScopeFacade
import ai.sterling.kchat.domain.chat.persistence.ChatEventPersistence
import ai.sterling.kchat.domain.chat.persistence.InMemoryChatEventPersistence
import ai.sterling.kchat.domain.user.persistences.InMemoryUserEventsPersistence
import ai.sterling.kchat.domain.user.persistences.UserEventsPersistence
import dagger.Binds
import dagger.Module

@Module
abstract class DomainModule {

    @Binds
    internal abstract fun dispatchersFacade(implementation: DefaultContextFacade): CoroutinesContextFacade

    @Binds
    internal abstract fun scopeFacade(implementation: DefaultScopeFacade): CoroutineScopeFacade

    @Binds
    internal abstract fun foregroundEvent(implementation: InMemoryForegroundEventPersistence): ForegroundEventPersistence

    @Binds
    internal abstract fun userEvents(implementation: InMemoryUserEventsPersistence): UserEventsPersistence

    @Binds
    internal abstract fun chatEvents(implementation: InMemoryChatEventPersistence): ChatEventPersistence
}
