object Libs {
    private const val kotlinVersion = "1.3.61"
    private const val lifecycleVersion = "2.2.0-alpha01"
    private const val daggerVersion = "2.25.2"
    private const val retrofitVersion = "2.6.1"
    private const val navVersion = "2.1.0"
    private const val coroutinesVersion = "1.3.2"
    private const val apolloVersion = "1.2.3"
    private const val instabugVersion = "9.0.3"
    private const val lintVersion = "26.5.0"
    private const val espressoVersion = "3.1.1"

    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion"

    const val dagger = "com.google.dagger:dagger:$daggerVersion"
    const val daggerAndroid = "com.google.dagger:dagger-android:$daggerVersion"
    const val daggerAndroidSupport = "com.google.dagger:dagger-android-support:$daggerVersion"
    const val androidAnnotations = "androidx.annotation:annotation:1.1.0"
    const val javaAnnotation = "javax.annotation:javax.annotation-api:1.3.2"
    const val javaxInject = "javax.inject:javax.inject:1"
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion"
    const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion"

    const val appcompat = "androidx.appcompat:appcompat:1.1.0"
    const val cardView = "androidx.cardview:cardview:1.0.0"
    const val preference = "androidx.preference:preference-ktx:1.0.0"
    const val localBroadcastManager = "androidx.localbroadcastmanager:localbroadcastmanager:1.0.0"
    const val material = "com.google.android.material:material:1.2.0-alpha04"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.0.0-alpha3"
    const val transition = "androidx.transition:transition:1.0.1"
    const val archExtensions = "androidx.lifecycle:lifecycle-extensions:$lifecycleVersion"
    const val archViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion"
    const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion"
    const val archNavigationFragment = "androidx.navigation:navigation-fragment-ktx:$navVersion"
    const val archNavigation = "androidx.navigation:navigation-ui-ktx:$navVersion"

    const val pinView = "com.chaos.view:pinview:1.4.3"

    const val glide = "com.github.bumptech.glide:glide:4.9.0"

    const val firebaseAnalytics = "com.google.firebase:firebase-analytics:17.2.0"
    const val firebaseMessaging = "com.google.firebase:firebase-messaging:20.0.0"

    const val apolloRuntime = "com.apollographql.apollo:apollo-runtime:$apolloVersion"
    const val apolloAndroidSupport = "com.apollographql.apollo:apollo-android-support:$apolloVersion"
    const val apolloHttpCache = "com.apollographql.apollo:apollo-http-cache:$apolloVersion"
    const val apolloCoroutine = "com.apollographql.apollo:apollo-coroutines-support:$apolloVersion"

    const val retrofitApi = "com.squareup.retrofit2:retrofit:$retrofitVersion"
    const val retrofitGson = "com.squareup.retrofit2:converter-gson:$retrofitVersion"
    const val gson = "com.google.code.gson:gson:2.8.5"
    const val okHttp = "com.squareup.okhttp3:okhttp:4.2.0"

    const val volley = "com.android.volley:volley:1.1.1"
    const val crashlytics = "com.crashlytics.sdk.android:crashlytics:2.10.1@aar"
    const val instabug = "com.instabug.library:instabug:$instabugVersion"
    const val instabugOkHttp = "com.instabug.library:instabug-with-okhttp-interceptor:$instabugVersion"
    const val calligraphy = "uk.co.chrisjenx:calligraphy:2.3.0"
    const val tape = "com.squareup.tape2:tape:2.0.0-beta1"
    const val wire = "com.squareup.wire:wire-runtime:3.0.1"
    const val segmentAnalytics = "com.segment.analytics.android:analytics:4.3.1"
    const val threeTenABP = "com.jakewharton.threetenabp:threetenabp:1.2.1"
    const val exoPlayer = "com.google.android.exoplayer:exoplayer:2.10.4"

    const val lintApi = "com.android.tools.lint:lint-api:$lintVersion"
    const val lintCheck = "com.android.tools.lint:lint-checks:$lintVersion"
    const val lintTests = "com.android.tools.lint:lint-tests:$lintVersion"

    object Kapt {
        const val daggerCompiler = "com.google.dagger:dagger-compiler:$daggerVersion"
        const val daggerAndroidCompiler = "com.google.dagger:dagger-android-processor:$daggerVersion"
    }

    object Tests {
        const val junit = "junit:junit:4.12"
        const val mockitoKotlin = "com.nhaarman.mockitokotlin2:mockito-kotlin:2.2.0"
        const val mockito = "org.mockito:mockito-core:3.1.0"
        const val assertJ = "org.assertj:assertj-core:3.13.2"
        const val testingCore = "androidx.arch.core:core-testing:2.1.0"
        const val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutinesVersion"
    }

    object AndroidTests {
        const val testCore = "androidx.test:core:1.0.1"

        // AndroidJUnitRunner and JUnit Rules
        const val testRunner = "androidx.test:runner:1.1.1"
        const val testRules =  "androidx.test:rules:1.1.1"

        // Assertions
        const val junit = "androidx.test.ext:junit:1.0.0"

        // Espresso dependencies
        const val espressoCore = "androidx.test.espresso:espresso-core:$espressoVersion"
        const val espressoContrib = "androidx.test.espresso:espresso-contrib:$espressoVersion"
        const val espressoIdle = "androidx.test.espresso:espresso-idling-resource:$espressoVersion"
        const val espressoIdleConcurrent = "androidx.test.espresso.idling:idling-concurrent:$espressoVersion"
        const val espressoIntents = "androidx.test.espresso:espresso-intents:$espressoVersion"

        const val mockito = Tests.mockito
        const val mockitoAndroid = "org.mockito:mockito-android:3.1.0"

        const val uiAutomator = "androidx.test.uiautomator:uiautomator-v18:2.2.0-alpha1"
    }
}
