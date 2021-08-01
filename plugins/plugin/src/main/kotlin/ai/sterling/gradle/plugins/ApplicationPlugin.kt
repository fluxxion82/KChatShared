package ai.sterling.gradle.plugins

import ai.sterling.gradle.plugins.base.BaseAndroidPlugin
import org.gradle.api.Project

open class ApplicationPlugin : BaseAndroidPlugin() {

    override fun apply(project: Project) {
        project.plugins.apply("com.android.application")
        super.apply(project)

//        project.extensions.configure(AppExtension::class.java) { extension ->
//            File(project.projectDir, "proguard").list()?.forEach { fileName ->
//                extension.buildTypes.all { type ->
//                    type.proguardFile(fileName)
//                }
//            } ?: project.logger.warn("Empty `/proguard` folder, no .pro files applied")
//        }

        project.rootProject.tasks.let { rootTasks ->
            rootTasks.named("projectLint") {
                dependsOn(project.tasks.named("lintDevDebug"))
            }

            rootTasks.named("projectTest") {
                dependsOn(project.tasks.named("testDevDebugUnitTest"))
            }
        }
    }
}
