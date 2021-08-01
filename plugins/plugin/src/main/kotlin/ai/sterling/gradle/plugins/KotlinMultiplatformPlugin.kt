package ai.sterling.gradle.plugins

import ai.sterling.gradle.plugins.base.BaseKmmPlugin
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

open class KotlinMultiplatformPlugin : BaseKmmPlugin() {
    override fun apply(project: Project) {
        project.plugins.apply("org.jetbrains.kotlin.multiplatform")
        super.apply(project)

        project.extensions.configure(KotlinMultiplatformExtension::class.java) {
            sourceSets.getByName(COMMON_MAIN) {
                dependencies {
                    implementation("org.jetbrains.kotlin:kotlin-stdlib-common")
                }
            }
            sourceSets.getByName(COMMON_TEST) {
                dependencies {
                    implementation("org.jetbrains.kotlin:kotlin-test-common")
                    implementation("org.jetbrains.kotlin:kotlin-test-annotations-common")
                }
            }
        }

//        if (project.rootProject.tasks.names.contains("projectCodestyle")) {
//            project.rootProject.tasks.named("projectCodestyle").configure {
//                project.subprojects.forEach { project ->
//                    if (project.tasks.names.contains("detekt")) {
//                        dependsOn(project.tasks.named("detektMetadataMain"))
//                    }
//                    if (project.tasks.names.contains("detektJvmMain")) {
//                        dependsOn(project.tasks.named("detektJvmMain"))
//                        dependsOn(project.tasks.named("detektJvmTest"))
//                    }
//                }
//            }
//        }

        project.rootProject.tasks.named("projectLint") {
            dependsOn(project.tasks.named("lintKotlin"))
        }
        project.rootProject.tasks.named("projectTest") {
            if (project.tasks.names.contains("allTests")) {
                dependsOn(project.tasks.named("allTests"))
            } else if (project.tasks.names.contains("test")) {
                dependsOn(project.tasks.named("test"))
            }
        }
    }

    companion object {
        const val COMMON_MAIN = "commonMain"
        const val COMMON_TEST = "commonTest"
    }
}
