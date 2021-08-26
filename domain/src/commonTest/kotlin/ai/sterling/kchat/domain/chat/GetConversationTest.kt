// package ai.sterling.kchat.domain.chat
//
// import ai.sterling.kchat.domain.base.invoke
// import ai.sterling.kchat.domain.chat.model.Conversation
// import ai.sterling.kchat.domain.chat.model.Message
// import ai.sterling.kchat.domain.chat.repository.ConversationRepository
// import ai.sterling.kchat.domain.runBlockingTest
// import io.mockk.MockKAnnotations
// import io.mockk.coEvery
// import io.mockk.impl.annotations.RelaxedMockK
// import io.mockk.mockk
// import kotlinx.coroutines.flow.flowOf
// import kotlinx.coroutines.flow.singleOrNull
// import kotlin.test.BeforeTest
// import kotlin.test.Test
// import kotlin.test.assertEquals
//
// class GetConversationTest {
//    @RelaxedMockK
//    lateinit var repository: ConversationRepository
//
//    lateinit var usecase: GetConversation
//
//    private val conversation = Conversation(
//        mapOf(
//            Pair("ID1", getMessages("ID1", "ID1")),
//            Pair("ID2", getMessages("ID2", "ID2"))
//        )
//    )
//
//    @BeforeTest
//    fun setUp() {
//        MockKAnnotations.init(this)
//
//        repository = mockk {
//            coEvery { getConversation() } returns flowOf(conversation)
//        }
//
//        usecase = GetConversation(repository)
//    }
//
//    @Test
//    fun `returns conversation`() {
//        runBlockingTest {
//            val result = usecase()
//
//            assertEquals(conversation, result.singleOrNull())
//        }
//    }
//
//    private fun getMessages(vararg ids: String): List<Message> = ids.mapIndexed { index, id ->
//        Message(
//            id,
//            "Test message",
//            "",
//            "ID$index",
//            "",
//            reply = false,
//            mine = false
//        )
//
//    }
//  }
