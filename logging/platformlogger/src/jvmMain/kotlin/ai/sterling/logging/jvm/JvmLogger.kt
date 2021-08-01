package ai.sterling.logging.jvm

import ai.sterling.logging.Logger
import java.util.logging.Level

object JvmLogger : Logger {
    private val javaLogger = java.util.logging.Logger.getLogger(JvmLogger::class.qualifiedName)

    @Suppress("ComplexMethod")
    override fun log(
        priority: Logger.Priority,
        explicitTag: String?,
        inferredTag: String,
        message: String?,
        throwable: Throwable?,
        properties: Map<String, String>?
    ) {
        val tagToLog = explicitTag ?: inferredTag
        val messageToLog = message ?: throwable?.message.orEmpty()

        when (priority) {
            Logger.Priority.VERBOSE -> {
                throwable?.let {
                    javaLogger.log(Level.ALL, messageToLog, it)
                } ?: javaLogger.log(Level.ALL, tagToLog, messageToLog)
            }
            Logger.Priority.INFO -> {
                throwable?.let {
                    javaLogger.log(Level.INFO, messageToLog, it)
                } ?: javaLogger.log(Level.INFO, tagToLog, messageToLog)
            }
            Logger.Priority.DEBUG -> {
                throwable?.let {
                    javaLogger.log(Level.SEVERE, messageToLog, it)
                } ?: javaLogger.log(Level.SEVERE, tagToLog, messageToLog)
            }
            Logger.Priority.WARNING -> {
                throwable?.let {
                    if (message == null) {
                        javaLogger.log(Level.WARNING, tagToLog, it)
                    } else {
                        javaLogger.log(Level.WARNING, messageToLog, it)
                    }
                } ?: javaLogger.log(Level.WARNING, tagToLog, messageToLog)
            }
            Logger.Priority.ERROR -> {
                throwable?.let {
                    javaLogger.log(Level.SEVERE, messageToLog, it)
                } ?: javaLogger.log(Level.SEVERE, tagToLog, messageToLog)
            }
            Logger.Priority.WTF -> {
                throwable?.let {
                    if (message == null) {
                        javaLogger.log(Level.WARNING, tagToLog, it)
                    } else {
                        javaLogger.log(Level.WARNING, messageToLog, it)
                    }
                } ?: javaLogger.log(Level.WARNING, tagToLog, messageToLog)
            }
        }.let { }
    }
}
