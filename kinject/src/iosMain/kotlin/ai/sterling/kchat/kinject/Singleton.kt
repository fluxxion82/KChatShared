package ai.sterling.kchat.kinject

import ai.sterling.kinject.ChatMessage
import org.kodein.di.Kodein
import org.kodein.di.TypeToken
import org.kodein.di.bindings.NoArgSimpleBindingKodein
import org.kodein.di.bindings.RefMaker
import org.kodein.di.bindings.Scope
import org.kodein.di.bindings.Singleton
import org.kodein.di.erased
import org.kodein.di.erased.bind
import org.kodein.di.erased.singleton

actual class Singleton() = String

val kodein = Kodein {
    bind<ChatMessage>() with singleton {
        NoArgSimpleBindingKodein
    }
}