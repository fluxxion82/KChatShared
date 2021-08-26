plugins {
    `kotlin-dsl`
}

repositories {
    google()
    gradlePluginPortal()
}

dependencies {
    compileOnly("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.5.21")
    compileOnly("com.android.tools.lint:lint-api:30.0.1")
    compileOnly("com.android.tools.lint:lint-checks:30.0.1")
    testImplementation("com.android.tools.lint:lint-api:30.0.1")
    testImplementation("com.android.tools.lint:lint-tests:30.0.1")
}
