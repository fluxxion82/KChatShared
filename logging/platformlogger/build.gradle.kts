//apply(from = "agp_compat.gradle.kts")

buildscript {
    repositories {
        google()
        gradlePluginPortal()
        maven { setUrl("https://plugins.gradle.org/m2/") }
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.21")
    }
}

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}

plugins {
    id("kchat-lib.kotlin-multi")
    id("com.android.library")
}

group = "ai.sterling.kchat"
version = "0.0.1"

kotlin {
    jvm()
    android()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":logging:logger"))
            }
        }
        val jvmMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlin:kotlin-stdlib:1.5.21")
                implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.5.21")
                implementation("com.google.dagger:hilt-core:2.38.1")
                configurations["kapt"].dependencies.add(
                    org.gradle.api.internal.artifacts.dependencies.DefaultExternalModuleDependency(
                        "com.google.dagger",
                        "hilt-android-compiler",
                        "2.38.1"
                    )
                )
            }
        }
        val jvmTest by getting {
            dependencies {
                implementation("junit:junit:4.13.2")
                implementation("com.nhaarman.mockitokotlin2:mockito-kotlin:2.2.0")
                implementation("org.mockito:mockito-core:3.9.0")
                implementation("org.assertj:assertj-core:3.16.1")
                implementation("org.jetbrains.kotlin:kotlin-test-junit:1.5.21")
            }
        }
        val androidMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlin:kotlin-stdlib:1.5.21")
                implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.5.21")
                implementation("com.google.dagger:hilt-android:2.38.1")
                configurations["kapt"].dependencies.add(
                    org.gradle.api.internal.artifacts.dependencies.DefaultExternalModuleDependency(
                        "com.google.dagger",
                        "hilt-android-compiler",
                        "2.38.1"
                    )
                )
            }
        }
        val androidTest by getting {
            dependencies {

            }
        }
    }
}

android {
    compileSdkVersion(31)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdkVersion(24)
        targetSdkVersion(31)
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}
