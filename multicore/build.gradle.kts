//import Deps.cocoapodsext
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    id("org.jetbrains.kotlin.multiplatform")
    id("org.jetbrains.kotlin.native.cocoapods")
    //id("co.touchlab.native.cocoapods")
}

repositories {
    jcenter()
    maven { setUrl("https://dl.bintray.com/kotlin/kotlin-dev") }
    maven { setUrl("https://dl.bintray.com/kotlin/kotlin-eap") }
    maven { setUrl("https://kotlin.bintray.com/native-xcode") }
}

group = "ai.sterling.kchat"
version = "0.0.1"

kotlin {
    // Add a platform switching to have an IDE support.
//    val buildForDevice = project.findProperty("kotlin.native.cocoapods.target") == "ios_arm"
//    if (buildForDevice) {
//        iosArm64("iOS64")
//        iosArm32("iOS32")
//
//        val iOSMain by sourceSets.creating
//        sourceSets["iOS64Main"].dependsOn(iOSMain)
//        sourceSets["iOS32Main"].dependsOn(iOSMain)
//    } else {
//        iosX64("iOS")
//    }

    jvm()

//    targets.withType<org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget> {
//        compilations.all {
//            dependencies {
//                implementation("org.jetbrains.kotlin.native.xcode:kotlin-native-xcode-11-4-workaround:1.3.72.0")
//            }
//        }
//    }

    sourceSets["commonMain"].dependencies {
        implementation("org.jetbrains.kotlin:kotlin-stdlib-common")
        //implementation("org.jetbrains.kotlin.native.xcode:kotlin-native-xcode-11-4-workaround:1.3.72.0")
    }
    sourceSets["commonTest"].dependencies {
        implementation("org.jetbrains.kotlin:kotlin-test-common")
        implementation("org.jetbrains.kotlin:kotlin-test-annotations-common")
    }
//    sourceSets["iOSMain"].dependencies {
//
//    }
//    sourceSets["iOSTest"].dependencies {
//
//    }
    sourceSets["jvmMain"].dependencies {
        implementation("org.jetbrains.kotlin:kotlin-stdlib")
    }
    sourceSets["jvmTest"].dependencies {
        implementation("org.jetbrains.kotlin:kotlin-test")
        implementation("org.jetbrains.kotlin:kotlin-test-junit")
    }

//    cocoapodsext {
//        // Configure fields required by CocoaPods.
//        summary = "Working with AFNetworking from Kotlin/Native using CocoaPods"
//        homepage = "https://github.com/JetBrains/kotlin-native"
//
//        // Configure a dependency on AFNetworking. It will be added in all macOS and iOS targets.
//        pod("AFNetworking", "~> 3.2.0")
//
//        framework {
//            isStatic = false
//            transitiveExport = true
//        }
//    }
}
