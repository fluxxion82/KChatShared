package ai.sterling.kinject

actual interface Provider<T> {

    actual fun get(): T
}