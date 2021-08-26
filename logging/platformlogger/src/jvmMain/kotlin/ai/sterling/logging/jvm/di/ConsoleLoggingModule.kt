package ai.sterling.logging.jvm.di

import ai.sterling.logging.jvm.JvmLogger
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class ConsoleLoggingModule {

    @Provides
    fun jvmConsoleLogger() = JvmLogger
}
