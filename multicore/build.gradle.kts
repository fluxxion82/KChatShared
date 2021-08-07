plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
}

repositories {
    gradlePluginPortal()
    google()
    mavenCentral()
    maven { setUrl("https://dl.bintray.com/kotlin/kotlin-dev") }
    maven { setUrl("https://dl.bintray.com/kotlin/kotlin-eap") }
    maven { setUrl("https://kotlin.bintray.com/native-xcode") }
}

group = "ai.sterling.kchat"
version = "0.0.1"

kotlin {
    // Add a platform switching to have an IDE support.
    val buildForDevice = project.findProperty("kotlin.native.cocoapods.target") == "ios_arm"
    if (buildForDevice) {
        iosArm64("ios64")
        iosArm32("ios32")

        val iOSMain by sourceSets.creating
        sourceSets["ios64Main"].dependsOn(iOSMain)
        sourceSets["ios32Main"].dependsOn(iOSMain)
    } else {
        iosX64("ios")
    }

    jvm()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlin:kotlin-stdlib-common")
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
            }
        }
        val jvmTest by getting {
            dependencies {
                implementation("org.jetbrains.kotlin:kotlin-test")
                implementation("org.jetbrains.kotlin:kotlin-test-junit")
            }
        }
        val iosMain by getting {
            dependencies {

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

        // Configure a dependency on AFNetworking. It will be added in all macOS and iOS targets.
        pod("AFNetworking", "~> 4.0.0")
    }
}
