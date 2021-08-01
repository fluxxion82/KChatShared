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

kotlin {
    jvm()
    js()
//    iosX64('ios')
//    iosArm32('iosArm32')
//    iosArm64('iosArm64')

//    val onPhone = System.getenv("SDK_NAME")?.startsWith("iphoneos") ?: false
//    if (onPhone) {
//        iosArm64("ios")
//    } else {
//        iosX64("ios")
//    }

    sourceSets["commonMain"].dependencies {
        implementation("org.jetbrains.kotlin:kotlin-stdlib-common")
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
        api("org.jetbrains.kotlin:kotlin-stdlib:1.5.10")
        implementation("javax.inject:javax.inject:1")
    }
    sourceSets["jvmTest"].dependencies {
        implementation("org.jetbrains.kotlin:kotlin-test")
        implementation("org.jetbrains.kotlin:kotlin-test-junit")
    }
    sourceSets["jsMain"].dependencies {
//        implementation("stdlib-js")
    }
    sourceSets["jsTest"].dependencies {
//        implementation("test-js")
    }
}
