package ai.sterling.gradle.plugins.base

//import com.android.build.gradle.TestedExtension
//import com.android.builder.model.LintOptions
//import com.hiya.plugins.JacocoAndroidUnitTestReportExtension
import org.gradle.api.Project

abstract class BaseAndroidPlugin : BasePlugin() {

    override fun apply(project: Project) {
        project.plugins.apply("kotlin-android")
        // TODO: Replace this with "kotlin-parcelize" when kotlin_version is greater than 1.4.20
        project.plugins.apply("kotlin-android-extensions")
        project.plugins.apply("com.hiya.jacoco-android")
        super.apply(project)

//        project.extensions.configure(JacocoPluginExtension::class.java) { extension ->
//            extension.toolVersion = "0.8.4"
//        }
//
//        project.extensions.getByType(JacocoAndroidUnitTestReportExtension::class.java).apply {
//            html.enabled(true)
//            xml.enabled(true)
//            excludes = excludes + listOf(
//                "**/di/**/*.*",
//                "**/*Directions*.*",
//                "**/*DataBinderMapper*.*",
//                "**/*Args.*",
//                "**/*Binding*.*",
//                "**/*_Factory*.*",
//                "**/IssuesRegistry.*",
//                "**/com/twinsdigital/mpcharts/**"
//            )
//        }
//
//        project.tasks.withType(Test::class.java) {
//            extensions.configure(JacocoTaskExtension::class.java) { extension ->
//                extension.isIncludeNoLocationClasses = false
//            }
//        }
//
//        project.extensions.getByType(TestedExtension::class.java).apply {
//            compileSdkVersion(COMPILE_SDK_VERSION)
//            defaultConfig.apply {
//                minSdkVersion(MIN_SDK_VERSION)
//                targetSdkVersion(COMPILE_SDK_VERSION)
//            }
//
//            useLibrary("android.test.runner")
//            useLibrary("android.test.base")
//            useLibrary("android.test.mock")
//
//            configureSourceSets(project)
//            configureAndroidLint(project)
//
//            compileOptions.sourceCompatibility = JavaVersion.VERSION_1_8
//            compileOptions.targetCompatibility = JavaVersion.VERSION_1_8
//        }

        project.dependencies.apply {
            add("implementation", "javax.annotation:javax.annotation-api:1.3.2")
            add("implementation", "androidx.annotation:annotation:1.2.0")
            add("implementation", "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
            add("implementation", "com.google.dagger:dagger-android:$daggerVersion")
            add("implementation", "com.google.dagger:dagger-android-support:$daggerVersion")
            add("kapt", "com.google.dagger:dagger-android-processor:$daggerVersion")
            add("kaptAndroidTest", "com.google.dagger:dagger-android-processor:$daggerVersion")
            add("lintChecks", project.rootProject.project("lintchecks"))

            add("androidTestImplementation", "org.assertj:assertj-core:3.16.1")
            add("androidTestImplementation", "androidx.arch.core:core-testing:2.1.0")
            add("androidTestImplementation", "androidx.test:runner:1.3.0")
            add("androidTestImplementation", "androidx.test:orchestrator:1.3.0")
            add("androidTestImplementation", "androidx.test.uiautomator:uiautomator:2.2.0")
            add("androidTestImplementation", "androidx.test:core:1.3.0")
            add("androidTestImplementation", "androidx.test:rules:1.3.0")
            add("androidTestImplementation", "androidx.test.ext:junit:1.1.2")
            add("androidTestImplementation", "androidx.test.espresso:espresso-core:$espressoVersion")
            add("androidTestImplementation", "androidx.test.espresso:espresso-intents:$espressoVersion")
            add("androidTestImplementation", "androidx.test.espresso:espresso-web:$espressoVersion")
            add("androidTestImplementation", "org.mockito:mockito-core:3.3.3")
            add("androidTestImplementation", "org.mockito:mockito-android:3.3.3")
        }
    }

//    private fun TestedExtension.configureAndroidLint(project: Project) {
//        val file = File(project.projectDir, "androidlint-baseline.xml")
//        if (file.exists() || project.hasProperty("refreshBaseline")) {
//            // Command for refreshing baselines:
//            // rm **/androidlint-*.xml ; ./gradlew :projectLint -PrefreshBaseline --continue
//            lintOptions.apply {
//                baselineFile = file
//            }
//        }
//        lintOptions.apply {
//            disable("InvalidPackage", "UseSparseArrays")
//            severityOverrides["MissingTranslation"] = LintOptions.SEVERITY_INFORMATIONAL
//        }
//    }
//
//    private fun TestedExtension.configureSourceSets(project: Project) {
//        sourceSets.all { set ->
//            val withKotlin = set.java.srcDirs.map { it.path.replace("java", "kotlin") }
//            set.java.setSrcDirs(set.java.srcDirs + withKotlin)
//        }
//
//        File(project.projectDir, "src/main/res/layouts").list()?.forEach {
//            sourceSets.getByName("main").res.srcDir("src/main/res/layouts/$it")
//        }
//    }

    companion object {
        private const val COMPILE_SDK_VERSION = 30
        private const val MIN_SDK_VERSION = 24

        private const val daggerVersion = "2.38.1"
        private const val coroutinesVersion = "1.5.0"
        private const val espressoVersion = "3.1.1"
    }
}

