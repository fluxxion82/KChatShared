package ai.sterling.kchat.domain.chat

import ai.sterling.kchat.domain.base.invoke
import ai.sterling.kchat.domain.conversation.GetConversation
import ai.sterling.kchat.domain.conversation.model.Conversation
import ai.sterling.kchat.domain.conversation.model.Message
import ai.sterling.kchat.domain.conversation.repository.ConversationRepository
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.stub
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.singleOrNull
import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetConversationTest {

    lateinit var usecase: GetConversation
    @Mock
    lateinit var repository: ConversationRepository

    @Before
    fun setUp() {
        usecase = GetConversation(repository)
    }

    @Test
    fun `returns conversation`() {
        runBlocking {
            val conversation = Conversation(
                mapOf(
                    Pair("ID1", getMessages("ID1", "ID1")),
                    Pair("ID2", getMessages("ID2", "ID2"))
                )
            )
            repository.stub {
                onBlocking { getConversation() } doReturn flowOf(conversation)
            }

            val result = async { usecase() }

            assertThat(result.await().singleOrNull()).isEqualTo(conversation)
        }
    }

    private fun getMessages(vararg ids: String): List<Message> = ids.mapIndexed { index, id ->
        Message(
            id,
            "Test message",
            "",
            "ID$index",
            "",
            reply = false,
            mine = false
        )

    }
}