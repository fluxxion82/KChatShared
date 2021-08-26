pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        google()
    }
}

rootProject.name = "kchat-gradle-plugins"

include(":plugin")
include(":lintchecks")

//project(":lintchecks").projectDir = file("lintchecks")