buildscript {
    repositories {
        maven { setUrl("https://plugins.gradle.org/m2/") }
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.10")
        classpath("org.jetbrains.kotlin:kotlin-serialization:1.5.10")
    }
}

plugins {
    id("kchat-lib.kotlin-multi")
}

repositories {
    google()
    mavenCentral()
}

group = "ai.sterling.kchat"
version = "0.0.1"

kotlin {
    jvm()

    sourceSets["commonMain"].dependencies {
        implementation("org.jetbrains.kotlin:kotlin-stdlib-common")
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-common:1.3.8")
        implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime-common:0.20.0")

        implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.2.1")
        implementation(project(":kinject"))
    }
    sourceSets["commonTest"].dependencies {
        implementation("org.jetbrains.kotlin:kotlin-test-common")
        implementation("org.jetbrains.kotlin:kotlin-test-annotations-common")
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.5.0")
    }
    sourceSets["jvmMain"].dependencies {
        implementation("org.jetbrains.kotlin:kotlin-stdlib:1.5.10")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.5.10")
        implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime:0.20.0")
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.0")

        implementation("com.google.dagger:dagger:2.37")
        implementation(project(":logging:logger"))
       // kapt "com.google.dagger:dagger-compiler:2.27"
    }
    sourceSets["jvmTest"].dependencies {
        implementation("org.jetbrains.kotlin:kotlin-test")
        implementation("org.jetbrains.kotlin:kotlin-test-junit")

        implementation("com.nhaarman.mockitokotlin2:mockito-kotlin:2.2.0")
        implementation("org.mockito:mockito-core:3.9.0")
        implementation("junit:junit:4.13.2")
    }
//        androidMain {
//            dependencies {
//                dependsOn(commonMain)
//            }
//        }
//        iosMain {
//            dependencies {
//                implementation "org.jetbrains.kotlinx:kotlinx-serialization-runtime-native:$serialization_version"
//                implementation "org.jetbrains.kotlinx:kotlinx-coroutines-core-native:$coroutine_version"
//            }
//        }
//        iosTest {
//        }
//        sourceSets["jsMain"].dependencies {
//            implementation(kotlin("stdlib-js"))
//        }
//        sourceSets["jsTest"].dependencies {
//            implementation(kotlin("test-js"))
//        }
//        macosMain {
//        }
//        macosTest {
//        }
}
