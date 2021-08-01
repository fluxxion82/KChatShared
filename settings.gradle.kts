pluginManagement {
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id.startsWith("org.jetbrains.kotlin")) {
                useVersion("1.5.0")
            }

            if (requested.id.id.startsWith("kchat-lib.kotlin-multi")) {
                useVersion("ai.sterling.gradle.plugins:kchat-gradle-plugins:0.0.1")
            }
        }
    }
    repositories {
        gradlePluginPortal()
        maven { setUrl("https://dl.bintray.com/kotlin/kotlin-dev") }
        maven { setUrl("https://dl.bintray.com/kotlin/kotlin-eap") }
    }
}

include(":domain")
include(":kinject")
include(":logging:logger")
include(":logging:platformlogger")
include(":multicore")

rootProject.name = "KChatShared"

includeBuild("plugins")
