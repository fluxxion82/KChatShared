package ai.sterling.kchat.plugins.base

import Libs
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.plugin.KaptExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

open class BasePlugin : Plugin<Project> {
    override fun apply(project: Project) {
        with(project) {
            plugins.apply("kotlin-kapt")

            repositories.google()
            repositories.jcenter()

            extensions.configure(KaptExtension::class.java) {
                it.correctErrorTypes = true
                it.useBuildCache = true
                it.javacOptions {
                    option("-Xmaxerrs", 1000)
                }
            }

            dependencies.add("implementation", Libs.kotlinStdLib)
            dependencies.add("implementation", "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.5")

            dependencies.add("testImplementation", Libs.Tests.junit)
            dependencies.add("testImplementation", Libs.Tests.mockitoKotlin)
            dependencies.add("testImplementation", Libs.Tests.mockito)
            dependencies.add("testImplementation", Libs.Tests.assertJ)
            dependencies.add("testImplementation", Libs.Tests.coroutinesTest)

            tasks.withType(KotlinCompile::class.java).all {
                it.kotlinOptions.freeCompilerArgs += arrayOf(
                    "-Xuse-experimental=kotlinx.coroutines.ExperimentalCoroutinesApi",
                    "-Xuse-experimental=kotlinx.coroutines.ObsoleteCoroutinesApi"
                )
                it.kotlinOptions.jvmTarget = JavaVersion.VERSION_1_8.toString()
            }
        }
    }
}
