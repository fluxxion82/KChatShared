package ai.sterling.kchat.plugins

import com.android.build.gradle.LibraryExtension
import ai.sterling.kchat.plugins.base.BaseAndroidPlugin
import org.gradle.api.Project

open class LibraryPlugin : BaseAndroidPlugin() {

    override fun apply(project: Project) {
        project.plugins.apply("com.android.library")
        super.apply(project)
        project.extensions.getByType(LibraryExtension::class.java).apply {
            libraryVariants.all {
                it.generateBuildConfigProvider.configure { it.enabled = false }
            }
//            variantFilter {
//                it.setIgnore(it.buildType.name != "debug" || it.flavors.isNotEmpty())
//            }
        }

        project.rootProject.tasks.let { rootTasks ->
            rootTasks.named("projectLint") {
                it.dependsOn(project.tasks.named("lintDebug"))
            }

            rootTasks.named("projectTest") {
                it.dependsOn(project.tasks.named("testDebugUnitTest"))
            }
        }
    }
}
