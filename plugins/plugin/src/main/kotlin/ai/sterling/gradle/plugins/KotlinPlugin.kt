package ai.sterling.gradle.plugins

import ai.sterling.gradle.plugins.base.BasePlugin
import org.gradle.api.Project
import org.gradle.testing.jacoco.tasks.JacocoReport

open class KotlinPlugin : BasePlugin() {
    override fun apply(project: Project) {
        project.pluginManager.apply("kotlin")
        project.pluginManager.apply("com.android.lint")
        project.pluginManager.apply("jacoco")

        super.apply(project)

        project.rootProject.tasks.named("projectLint") {
            dependsOn(project.tasks.named("lint"))
        }
        project.rootProject.tasks.named("projectTest") {
            dependsOn(project.tasks.named("test"))
        }

        project.tasks.named("jacocoTestReport", JacocoReport::class.java) {
            reports.apply {
                xml.isEnabled = true
                html.isEnabled = true
            }
        }

        project.dependencies.add("implementation", "javax.inject:javax.inject:1")
        project.dependencies.add("implementation", "androidx.annotation:annotation:1.1.0")
    }
}
