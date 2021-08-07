package ai.sterling.kchat.domain

actual class Foo {
    actual fun checkMe() = 23
}

actual object Bar {
    actual fun name(): String = "JVM domain"
}
