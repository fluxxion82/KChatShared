package ai.sterling.kinject

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
expect annotation class Named(val value: String)
