buildscript {
    repositories {
        google()
        gradlePluginPortal()
        maven { setUrl("https://plugins.gradle.org/m2/") }
        maven { setUrl("https://kotlin.bintray.com/native-xcode") }
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.21")
        classpath("org.jetbrains.kotlin:kotlin-serialization:1.5.21")
        classpath("com.android.tools.build:gradle:4.2.2")
    }
}

allprojects {
    repositories {
        google()
        gradlePluginPortal()
    }
}

tasks.register("clean", Delete::class.java) {
    delete(rootProject.buildDir)
}

tasks.register("projectLint")
tasks.register("projectCodestyle")
tasks.register("projectTest")
