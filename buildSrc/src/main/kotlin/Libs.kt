object Libs {
    const val kotlinVersion = "1.5.10"
    const val coroutinesVersion = "1.5.0"
    const val detektVersion = "1.17.1"

    val kotlin = Kotlin
    val kotlinx = Kotlinx
    val android = Android
    val detekt = Detekt

    object Kotlin {
        val stdlib = Stdlib()
        val test = Test
        val plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"

        class Stdlib(
            private val name: String = "org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion"
        ) : CharSequence by name {
            val jdk8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion"
            val js = "org.jetbrains.kotlin:kotlin-stdlib-js:$kotlinVersion"
            val common = "org.jetbrains.kotlin:kotlin-stdlib-common:$kotlinVersion"

            override fun toString(): String = name
        }

        object Test {
            const val common = "org.jetbrains.kotlin:kotlin-test-common:$kotlinVersion"
            const val js = "org.jetbrains.kotlin:kotlin-test-js:$kotlinVersion"
            const val junit = "org.jetbrains.kotlin:kotlin-test-junit:$kotlinVersion"
            const val annotationsCommon = "org.jetbrains.kotlin:kotlin-test-annotations-common:$kotlinVersion"
        }
    }

    object Kotlinx {
        val coroutines = Coroutines
        val metadata = Metadata

        object Coroutines {
            val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion"
            val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutinesVersion"
            val core = Core()

            class Core(
                private val name: String = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion"
            ) : CharSequence by name {
                val common = "org.jetbrains.kotlinx:kotlinx-coroutines-core-common:$coroutinesVersion"
                val native = "org.jetbrains.kotlinx:kotlinx-coroutines-core-native:$coroutinesVersion"
                val js = "org.jetbrains.kotlinx:kotlinx-coroutines-core-js:$coroutinesVersion"

                override fun toString() = name
            }
        }

        object Metadata {
            const val jvm = "org.jetbrains.kotlinx:kotlinx-metadata-jvm:0.1.0"
        }
    }

    object Android {
        const val plugin = "com.android.tools.build:gradle:3.4.1"
        val androidx = Androidx

        object Androidx {
            const val appcompat = "androidx.appcompat:appcompat:1.1.0"
            const val constraintLayout = "androidx.constraintlayout:constraintlayout:1.1.3"
        }
    }

    object Detekt {
        const val plugin = "io.gitlab.arturbosch.detekt:detekt-gradle-plugin:$detektVersion"
        const val ktlint = "io.gitlab.arturbosch.detekt:detekt-formatting:$detektVersion"
    }
}
