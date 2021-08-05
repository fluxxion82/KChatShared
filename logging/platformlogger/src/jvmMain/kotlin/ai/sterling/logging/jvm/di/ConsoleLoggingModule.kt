package ai.sterling.logging.jvm.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ai.sterling.logging.jvm.JvmLogger

@Module
@InstallIn(SingletonComponent::class)
class ConsoleLoggingModule {

    @Provides
    fun jvmConsoleLogger() = JvmLogger
}
