import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
    //id("co.touchlab.native.cocoapods")
    id("kotlinx-serialization")
}

repositories {
    jcenter()
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

//    targets.withType<org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget>("ios") {
//        compilations.main {
//            kotlinOptions.freeCompilerArgs += listOf("-Xobjc-generics", "-Xg0")
//        }
//    }

//    targets.getByName<KotlinNativeTarget>("ios").compilations["main"].kotlinOptions.freeCompilerArgs +=
//            listOf("-Xobjc-generics", "-Xg0")


    sourceSets["commonMain"].dependencies {
        implementation("org.jetbrains.kotlin:kotlin-stdlib-common")
        //implementation("org.jetbrains.kotlin.native.xcode:kotlin-native-xcode-11-4-workaround:1.3.72.0")
    }
    sourceSets["commonTest"].dependencies {
        implementation("org.jetbrains.kotlin:kotlin-test-common")
        implementation("org.jetbrains.kotlin:kotlin-test-annotations-common")
    }
//    sourceSets["iOSMain"].dependencies {
//        //api 'org.jetbrains.kotlin.native.xcode:kotlin-native-xcode-11-4-workaround:1.3.72.0'
//    }
//    sourceSets["iOSTest"].dependencies {
//
//    }
    sourceSets["jvmMain"].dependencies {
        api("org.jetbrains.kotlin:kotlin-stdlib:1.4.10")
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

//    cocoapodsext {
//        // The CocoaPods version notation is supported.
//        // The dependency will be added to all macOS and iOS targets.
//        summary = "Shared Kotlin/Native module"
//        homepage = "Link to a Kotlin/Native module homepage"
//        pod("Cleanse", "~> 4.2.5")
//        //pod("AFNetworking", "~> 3.2.0")
//    }
}

//task packForXcode(type: Sync) {
//    final File frameworkDir = new File(buildDir, "xcode-frameworks")
//    final String mode = project.findProperty("XCODE_CONFIGURATION")?.toUpperCase() ?: 'DEBUG'
//    final def framework = kotlin.targets.ios.binaries.getFramework("kinject", mode)
//
//    inputs.property "mode", mode
//    dependsOn framework.linkTask
//
//    from { framework.outputFile.parentFile }
//    into frameworkDir
//
//    doLast {
//        new File(frameworkDir, 'gradlew').with {
//            text = "#!/bin/bash\nexport 'JAVA_HOME=${System.getProperty("java.home")}'\ncd '${rootProject.rootDir}'\n./gradlew \$@\n"
//            setExecutable(true)
//        }
//    }
//}
//
//tasks.build.dependsOn packForXcode

//task copyFramework {
//    def buildType = project.findProperty('kotlin.build.type') ?: 'DEBUG'
//    def target = project.findProperty('kotlin.target') ?: 'ios'
//    dependsOn kotlin.targets."$target".binaries.getFramework(buildType).linkTask
//
//    doLast {
//        def srcFile = kotlin.targets."$target".binaries.getFramework(buildType).outputFile
//        def targetDir = getProperty('configuration.build.dir')
//        copy {
//            from srcFile.parent
//            into targetDir
//            include 'common.framework/**'
//            include 'common.framework.dSYM'
//        }
//    }
//}
