package ai.sterling.gradle.plugins

//import com.android.build.gradle.LibraryExtension
import ai.sterling.gradle.plugins.base.BaseAndroidPlugin
import org.gradle.api.Project

open class LibraryPlugin : BaseAndroidPlugin() {

    override fun apply(project: Project) {
        project.plugins.apply("com.android.library")
        super.apply(project)
//        project.extensions.getByType(LibraryExtension::class.java).apply {
//            libraryVariants.all {
//                it.generateBuildConfigProvider.configure { it.enabled = false }
//            }
//        }

        project.rootProject.tasks.let { rootTasks ->
            rootTasks.named("projectLint") {
                dependsOn(project.tasks.named("lintDebug"))
            }

            rootTasks.named("projectTest") {
                dependsOn(project.tasks.named("testDebugUnitTest"))
            }
        }
    }
}
