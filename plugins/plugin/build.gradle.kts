buildscript {
    repositories {
        gradlePluginPortal()
        google()
        maven { setUrl ("https://plugins.gradle.org/m2/") }
        maven { setUrl ("https://dl.bintray.com/kotlin/kotlin-eap") }
        //maven { setUrl ("https://kotlin.bintray.com/native-xcode") }
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.21")
        classpath("org.jetbrains.kotlin:kotlin-serialization:1.5.21")
        classpath("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:1.17.1")
        classpath("org.jmailen.gradle:kotlinter-gradle:3.2.0")
        // classpath("co.touchlab:kotlinnativecocoapods:0.12")
    }
}

group = "ai.sterling.gradle.plugins"
version = "0.0.1"

plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
}

repositories {
    gradlePluginPortal()
    google()
    mavenCentral()
    maven { setUrl("https://plugins.gradle.org/m2/") }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.21")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.5.21")

    implementation("org.jmailen.gradle:kotlinter-gradle:3.2.0")
    implementation("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:1.18.0")
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

gradlePlugin {
    plugins {
        register("kmpLibPlugin") {
            id = "kchat-lib.kotlin-multi"
            implementationClass = "ai.sterling.gradle.plugins.KotlinMultiplatformPlugin"
        }
        register("detektLibPlugin") {
            id = "kchat-lib.detekt"
            implementationClass = "ai.sterling.gradle.plugins.DetektPlugin"
        }
    }
}

kotlin {
    sourceSets.getByName("main").kotlin.srcDir("src/main/kotlin")
}
