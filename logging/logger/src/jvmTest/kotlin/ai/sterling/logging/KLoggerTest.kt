package ai.sterling.logging

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.junit.After
import org.junit.Before
import org.junit.Test

class KLoggerTest {

    class InnerClass {
        fun doLog() = KLogger.d { "msg" }
    }

    private lateinit var loggers: Collection<Logger>

    @After
    fun cleanUp() {
        KLogger.unregisterLoggers(loggers)
    }

    @Before
    fun registerLoggers() {
        loggers = listOf<Logger>(mock(), mock()).also {
            KLogger.registerLoggers(it)
        }
    }

    @Test
    fun properTagIsGeneratedWhenLoggedFromTest() {
        KLogger.d { "msg" }
        loggers.forEach {
            verify(it).log(
                Logger.Priority.DEBUG,
                null,
                "KLoggerTest#properTagIsGeneratedWhenLoggedFromTest:33",
                "msg",
                null,
                null
            )
        }
    }

    @Test
    fun properTagIsGeneratedWhenLoggedFromClass() {
        SomeClass().doLog()
        loggers.forEach {
            verify(it).log(
                Logger.Priority.DEBUG,
                null,
                "SomeClass#doLog:77",
                "msg",
                null,
                null
            )
        }
    }

    @Test
    fun properTagIsGeneratedWhenLoggedFromInnerClass() {
        InnerClass().doLog()
        loggers.forEach {
            verify(it).log(
                Logger.Priority.DEBUG,
                null,
                "TwinLoggerTest\$InnerClass#doLog:13",
                "msg",
                null,
                null
            )
        }
    }
}

class SomeClass {
    fun doLog() = KLogger.d { "msg" }
}
