buildscript {
    repositories {
        google()
        gradlePluginPortal()
        maven { setUrl("https://plugins.gradle.org/m2/") }
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.10")
    }
}

repositories {
    google()
    gradlePluginPortal()
}

plugins {
    id("kchat-lib.kotlin-multi")
}

group = "ai.sterling.kchat"
version = "0.0.1"

kotlin {
    jvm()

    sourceSets["commonMain"].dependencies {

    }

    sourceSets["jvmMain"].dependencies {
        implementation("org.jetbrains.kotlin:kotlin-stdlib:1.5.10")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.5.10")
    }

    sourceSets["jvmTest"].dependencies {
        implementation("junit:junit:4.13.2")
        implementation("com.nhaarman.mockitokotlin2:mockito-kotlin:2.2.0")
        implementation("org.mockito:mockito-core:3.9.0")
        implementation("org.assertj:assertj-core:3.16.1")
        implementation("org.jetbrains.kotlin:kotlin-test-junit:1.5.10")
    }
}
