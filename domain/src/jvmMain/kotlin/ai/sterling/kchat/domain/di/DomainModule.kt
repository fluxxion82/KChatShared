package ai.sterling.kchat.domain.di

import ai.sterling.kchat.domain.app.persistence.ForegroundEventPersistence
import ai.sterling.kchat.domain.app.persistence.InMemoryForegroundEventPersistence
import ai.sterling.kchat.domain.base.CoroutineScopeFacade
import ai.sterling.kchat.domain.base.CoroutinesContextFacade
import ai.sterling.kchat.domain.base.DefaultContextFacade
import ai.sterling.kchat.domain.base.DefaultScopeFacade
import dagger.Binds
import dagger.Module
import dagger.Provides
import org.threeten.bp.Clock

@Module
abstract class DomainModule {

    @Module
    companion object {

        @Provides
        @JvmStatic
        fun clock() = Clock.systemDefaultZone()
    }

    @Binds
    internal abstract fun dispatchersFacade(implementation: DefaultContextFacade): CoroutinesContextFacade

    @Binds
    internal abstract fun scopeFacade(implementation: DefaultScopeFacade): CoroutineScopeFacade

    @Binds
    internal abstract fun foregroundEvent(implementation: InMemoryForegroundEventPersistence): ForegroundEventPersistence
}
