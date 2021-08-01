allprojects {
    group = "kchat-gradle-plugins"
    version = "0.0.1"

    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class.java) {
    delete(rootProject.buildDir)
}
