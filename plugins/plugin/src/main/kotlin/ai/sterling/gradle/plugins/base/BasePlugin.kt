package ai.sterling.gradle.plugins.base

import io.gitlab.arturbosch.detekt.Detekt
import io.gitlab.arturbosch.detekt.DetektPlugin
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.plugin.KaptExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jmailen.gradle.kotlinter.KotlinterExtension
import org.jmailen.gradle.kotlinter.KotlinterPlugin
import java.io.File

open class BasePlugin : Plugin<Project> {
    override fun apply(project: Project) {
        with(project) {
            plugins.apply("kotlin-kapt")

            repositories.google()
            repositories.gradlePluginPortal()

            project.afterEvaluate {
                configureStaticAnalysis()
            }

            extensions.configure(KaptExtension::class.java) {
                correctErrorTypes = true
                useBuildCache = true
                arguments {
                    arg("dagger.formatGeneratedSource", "disabled")
                }
                javacOptions {
                    option("-Xmaxerrs", 1000)
                }
            }

            dependencies.add("implementation", "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")
            dependencies.add("implementation", "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
            dependencies.add("testImplementation", "junit:junit:4.13")
            dependencies.add("testImplementation", "androidx.test:runner:1.3.0")
            dependencies.add("testImplementation", "android.arch.core:core-testing:1.1.1")
            dependencies.add("testImplementation", "androidx.test:rules:1.3.0")
            dependencies.add("testImplementation", "com.nhaarman.mockitokotlin2:mockito-kotlin:2.2.0")
            dependencies.add("testImplementation", "org.mockito:mockito-core:3.3.3")
            dependencies.add("testImplementation", "org.assertj:assertj-core:3.16.1")
            dependencies.add("testImplementation", "org.jetbrains.kotlin:kotlin-test-junit:$kotlinVersion")
            dependencies.add("testImplementation", "org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutinesVersion")
            dependencies.add("implementation", "javax.inject:javax.inject:1")
            dependencies.add("implementation", "com.google.dagger:dagger:$daggerVersion")
            dependencies.add("kapt", "com.google.dagger:dagger-compiler:$daggerVersion")

            tasks.withType(KotlinCompile::class.java).all {
                kotlinOptions.freeCompilerArgs += arrayOf(
                    "-Xuse-experimental=kotlin.time.ExperimentalTime",
                    "-Xuse-experimental=kotlinx.coroutines.ExperimentalCoroutinesApi",
                    "-Xuse-experimental=kotlinx.coroutines.ObsoleteCoroutinesApi"
                )
                kotlinOptions.jvmTarget = JavaVersion.VERSION_11.toString()
            }
        }
    }

    private fun Project.configureStaticAnalysis() {
        configureDetekt()
        configureKtlint()
    }

    private fun Project.configureDetekt() {
        pluginManager.apply(DetektPlugin::class.java)
        tasks.withType(Detekt::class.java).configureEach {
            jvmTarget = "1.8"
            config.from(rootProject.file("quality/detekt-config.yml"))
            reports.apply {
                html.enabled = false
                xml.enabled = false
            }
            val file = File(rootProject.projectDir, "detekt-baseline.xml")
            baseline.set(file)
        }
        project.rootProject.tasks.named("projectCodestyle").configure {
            dependsOn(project.tasks.named("detekt"))
        }
    }

    private fun Project.configureKtlint() {
        pluginManager.apply(KotlinterPlugin::class.java)
        extensions.configure(KotlinterExtension::class.java) {
            indentSize = 4
        }
    }

    companion object {
        private const val kotlinVersion = "1.5.10"
        private const val daggerVersion = "2.35.1"
        private const val coroutinesVersion = "1.5.0"
    }
}
