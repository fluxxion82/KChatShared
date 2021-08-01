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
        iosArm64("iOS64")
        iosArm32("iOS32")

        val iOSMain by sourceSets.creating
        sourceSets["iOS64Main"].dependsOn(iOSMain)
        sourceSets["iOS32Main"].dependsOn(iOSMain)
    } else {
        iosX64("iOS")
    }

    jvm()

    sourceSets["commonMain"].dependencies {
        implementation("org.jetbrains.kotlin:kotlin-stdlib-common")
    }
    sourceSets["commonTest"].dependencies {
        implementation("org.jetbrains.kotlin:kotlin-test-common")
        implementation("org.jetbrains.kotlin:kotlin-test-annotations-common")
    }
    sourceSets["iOSMain"].dependencies {

    }
    sourceSets["iOSTest"].dependencies {

    }
    sourceSets["jvmMain"].dependencies {
        implementation("org.jetbrains.kotlin:kotlin-stdlib")
    }
    sourceSets["jvmTest"].dependencies {
        implementation("org.jetbrains.kotlin:kotlin-test")
        implementation("org.jetbrains.kotlin:kotlin-test-junit")
    }

    cocoapods {
        // Configure fields required by CocoaPods.
        summary = "Working with AFNetworking from Kotlin/Native using CocoaPods"
        homepage = "https://github.com/JetBrains/kotlin-native"

        ios.deploymentTarget = "13.5"

        // Configure a dependency on AFNetworking. It will be added in all macOS and iOS targets.
        pod("AFNetworking", "~> 4.0.0")
    }
}
