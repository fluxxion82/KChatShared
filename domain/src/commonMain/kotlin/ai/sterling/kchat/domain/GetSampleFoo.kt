package ai.sterling.kchat.domain

expect class Foo() {
    fun checkMe(): Int
}

expect object Bar {
    fun name(): String
}

fun goodbye(): String = "Hello from ${Bar.name()}"