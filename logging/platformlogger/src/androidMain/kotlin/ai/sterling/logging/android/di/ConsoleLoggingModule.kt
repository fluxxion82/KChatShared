package ai.sterling.logging.android.di

import dagger.Module
import dagger.Provides
import ai.sterling.logging.android.AndroidLogger
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class ConsoleLoggingModule {

    @Provides
    fun androidConsoleLogger() = AndroidLogger
}
