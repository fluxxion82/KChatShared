package ai.sterling.gradle.plugins

import io.gitlab.arturbosch.detekt.CONFIGURATION_DETEKT_PLUGINS
import io.gitlab.arturbosch.detekt.extensions.DetektExtension
import java.io.File
import org.gradle.api.Plugin
import org.gradle.api.Project

class DetektPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        target.plugins.apply("io.gitlab.arturbosch.detekt")
        target.extensions.configure(DetektExtension::class.java) {
            input = target.files(
                target
                    .file("src")
                    .listFiles()
                    ?.filter { it.isDirectory && it.name.endsWith("main", ignoreCase = true) }
            )
            config.from(target.rootProject.file("quality/detekt-config.yml"))
            reports.apply {
                html.enabled = false
                xml.enabled = false
            }
            val file = File(target.rootProject.projectDir, "detekt-baseline.xml")
            baseline = file
        }
        target.dependencies.add(
            CONFIGURATION_DETEKT_PLUGINS,
            "io.gitlab.arturbosch.detekt:detekt-formatting:1.17.1"
        )
    }
}
