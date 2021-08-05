package ai.sterling.kchat.domain.chat.model

import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

data class ChatMessage(val id: Int, val username: String, val type: Int, var message: String, val date: Long) {

    override fun toString(): String {
        return when (type) {
            LOGIN -> {
                message = "$username \n just joined"
                message
            }

            LOGOUT -> {
                message = "$username \n has logged out"
                message
            }

            REPLY, MESSAGE -> {
                val date = Instant.fromEpochMilliseconds(date).toLocalDateTime(TimeZone.currentSystemDefault())
                val min = if (date.minute < TEN_MIN) "0${date.minute}" else date.minute

                val time = """
                    ${
                    when {
                        date.hour == 0 -> date.hour + TWELVE_HRS
                        date.hour > TWELVE_HRS -> date.hour - TWELVE_HRS
                        else -> date.hour
                    }
                }:${min} ${if (date.hour >= TWELVE_HRS) { "PM" } else { "AM" }}
                """.trimIndent()

                """
                    ${if (type == REPLY) "$username:" else ""} $message
                    $time
                """.trimIndent()
            }

            else -> "Invalid operation.\n"
        }
    }

    companion object {
        const val MESSAGE = 0
        const val REPLY = 1
        const val LOGOUT = 2
        const val LOGIN = 3

        const val TEN_MIN = 10
        const val TWELVE_HRS = 12
    }
}
