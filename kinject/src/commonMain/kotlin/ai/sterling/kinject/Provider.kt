package ai.sterling.kinject

expect interface Provider<T> {
    fun get(): T
}