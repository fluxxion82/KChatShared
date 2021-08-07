buildscript {
    repositories {
        maven { setUrl("https://plugins.gradle.org/m2/") }
        maven { setUrl("https://kotlin.bintray.com/native-xcode") }
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.20")
        classpath("org.jetbrains.kotlin:kotlin-serialization:1.5.20")
    }
}

plugins {
    id("kchat-lib.kotlin-multi")
    kotlin("native.cocoapods")
}

repositories {
    google()
    mavenCentral()
}

group = "ai.sterling.kchat"
version = "0.0.1"

kotlin {
    // Add a platform switching to have an IDE support.
    val buildForDevice = project.findProperty("kotlin.native.cocoapods.target") == "ios_arm"
    if (buildForDevice) {
        iosArm64("ios64")
        iosArm32("ios32")

        val iosMain by sourceSets.creating
        sourceSets["ios64Main"].dependsOn(iosMain)
        sourceSets["ios32Main"].dependsOn(iosMain)
    } else {
        iosX64("ios")
    }

    jvm()
    sourceSets {
        all {
            languageSettings.apply {
                useExperimentalAnnotation("kotlinx.coroutines.ExperimentalCoroutinesApi")
            }
        }

        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlin:kotlin-stdlib-common")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-common:1.3.8")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime-common:0.20.0")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.0")

                implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.2.1")
                implementation(project(":kinject"))
            }
        }
        val commonTest by getting {
            dependencies {
                implementation("org.jetbrains.kotlin:kotlin-test-common")
                implementation("org.jetbrains.kotlin:kotlin-test-annotations-common")
            }
        }
        val jvmMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlin:kotlin-stdlib:1.5.21")
                implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.5.21")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime:0.20.0")
                implementation(project(":logging:logger"))

                implementation("com.google.dagger:dagger:2.37")
            }
        }
        val jvmTest by getting {
            dependencies {
                implementation("org.jetbrains.kotlin:kotlin-test")
                implementation("org.jetbrains.kotlin:kotlin-test-junit")

                implementation("com.nhaarman.mockitokotlin2:mockito-kotlin:2.2.0")
                implementation("org.mockito:mockito-core:3.9.0")
                implementation("junit:junit:4.13.2")
            }
        }
        val iosMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-native:1.3.8")
            }
        }
        val iosTest by getting {
            dependencies {

            }
        }
    }

    cocoapods {
        // Configure fields required by CocoaPods.
        summary = "Multicore CocoaPods dependencies"
        homepage = "https://github.com/JetBrains/kotlin-native"

        ios.deploymentTarget = "13.5"

        pod("SwiftCoroutine", "~> 2.1.8")
//        pod("SwiftCoroutine") {
//            source = git("https://github.com/belozierov/SwiftCoroutine.git") {
//                tag = "2.1.8"
//            }
//            version = "2.1.8"
//        }

        //useLibraries()
    }
}
