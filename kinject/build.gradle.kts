plugins {
    kotlin("multiplatform")
    //kotlin("native.cocoapods")
}

repositories {
    gradlePluginPortal()
    maven { setUrl("https://dl.bintray.com/kotlin/kotlin-dev") }
    maven { setUrl("https://dl.bintray.com/kotlin/kotlin-eap") }
    maven { setUrl("https://kotlin.bintray.com/native-xcode") }
}

group = "ai.sterling.kchat"
version = "0.0.1"

kotlin {
    jvm()
    js()
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


//    iosX64('ios')
//    iosArm32('iosArm32')
//    iosArm64('iosArm64')

//    val onPhone = System.getenv("SDK_NAME")?.startsWith("iphoneos") ?: false
//    if (onPhone) {
//        iosArm64("ios")
//    } else {
//        iosX64("ios")
//    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlin:kotlin-stdlib-common")

                implementation("io.insert-koin:koin-core:3.1.1")
            }
        }

        val commonTest by getting {
            dependencies {
                implementation("org.jetbrains.kotlin:kotlin-test-common")
                implementation("org.jetbrains.kotlin:kotlin-test-annotations-common")
            }
        }
        val iOSMain by getting {
            dependencies {
                // kotlin.srcDir("${buildDir.absolutePath}/generated/source/kaptKotlin/")
            }
        }
        val iOSTest by getting {
            dependencies {

            }
        }
        val jvmMain by getting {
            dependencies {
                api("org.jetbrains.kotlin:kotlin-stdlib:1.5.21")
                implementation("javax.inject:javax.inject:1")
            }
        }
        val jvmTest by getting {
            dependencies {
                implementation("org.jetbrains.kotlin:kotlin-test")
                implementation("org.jetbrains.kotlin:kotlin-test-junit")
            }
        }
        val jsMain by getting {
            dependencies {
                // implementation("stdlib-js")
            }
        }
        val jsTest by getting {
            dependencies {
                // implementation("test-js")
            }
        }

    }

//    cocoapods {
//        // Configure fields required by CocoaPods.
//        summary = "KIjnect CocoaPods dependencies"
//        homepage = "https://github.com/JetBrains/kotlin-native"
//
//        ios.deploymentTarget = "13.5"
//
//        pod("Cleanse", "~> 4.2.6")
//    }
}
