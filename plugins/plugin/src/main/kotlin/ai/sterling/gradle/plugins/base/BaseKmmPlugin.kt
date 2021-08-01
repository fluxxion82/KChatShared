package ai.sterling.gradle.plugins.base

import io.gitlab.arturbosch.detekt.Detekt
import io.gitlab.arturbosch.detekt.DetektPlugin
import java.io.File
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.plugin.KaptExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jmailen.gradle.kotlinter.KotlinterExtension
import org.jmailen.gradle.kotlinter.KotlinterPlugin

@Suppress("MagicNumber")
open class BaseKmmPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        with(project) {
            plugins.apply("kotlin-kapt")

            repositories.google()
            repositories.gradlePluginPortal()
            repositories.mavenCentral()

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

//            dependencies.add("implementation", "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")
//            dependencies.add("implementation", "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
//            dependencies.add("testImplementation", "org.jetbrains.kotlin:kotlin-test-junit:$kotlinVersion")
//            dependencies.add("testImplementation", "org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutinesVersion")
//            dependencies.add("implementation", "com.google.dagger:dagger:$daggerVersion")
//            dependencies.add("kapt", "com.google.dagger:dagger-compiler:$daggerVersion")

            tasks.withType(KotlinCompile::class.java).all {
                kotlinOptions.freeCompilerArgs += arrayOf(
                    "-Xuse-experimental=kotlin.time.ExperimentalTime",
                    "-Xuse-experimental=kotlinx.coroutines.ExperimentalCoroutinesApi",
                    "-Xuse-experimental=kotlinx.coroutines.ObsoleteCoroutinesApi",
                    "-P",
                    "plugin:androidx.compose.compiler.plugins.kotlin:suppressKotlinVersionCompatibilityCheck=true"
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
        project.subprojects.forEach { project ->
            project.tasks.withType(Detekt::class.java).configureEach {
                jvmTarget = "1.8"
                config.setFrom(rootProject.file("quality/detekt-config.yml"))
                reports.apply {
                    html.enabled = false
                    xml.enabled = false
                }
                disableDefaultRuleSets = true

                baseline.set(File(rootProject.projectDir, "detekt-baseline.xml"))
            }
        }

        if (project.rootProject.tasks.names.contains("projectCodestyle")) {
            project.rootProject.tasks.named("projectCodestyle").configure {
                project.subprojects.forEach { project ->
                    if (project.tasks.names.contains("detektMetadataMain")) {
                        dependsOn(project.tasks.named("detekt"))
                        dependsOn(project.tasks.named("detektMetadataMain"))
                    }
                    if (project.tasks.names.contains("detektJvmMain")) {
                        dependsOn(project.tasks.named("detektJvmMain"))
                        dependsOn(project.tasks.named("detektJvmTest"))
                    }
                }
            }
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
