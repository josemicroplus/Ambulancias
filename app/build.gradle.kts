plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

// Definir as versões das dependências como propriedades extras
extra["compose_version"] = "1.6.7"
extra["kotlin_version"] = "1.8.22"
extra["material3_version"] = "1.2.1"
extra["lifecycle_version"] = "2.4.0"
extra["activity_compose_version"] = "1.3.1"
extra["navigation_compose_version"] = "2.4.0-alpha10"
extra["retrofit_version"] = "2.9.0"
extra["okhttp_version"] = "4.9.1"
extra["moshi_version"] = "1.15.1"
extra["core_ktx_version"] = "1.7.0"
extra["junit_version"] = "4.13.2"
extra["androidx_test_ext_junit_version"] = "1.1.3"
extra["espresso_core_version"] = "3.4.0"

android {
    namespace = "com.example.ambulancias"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.ambulancias"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.8"
    }
}

dependencies {
// Definir as versões das dependências como propriedades extras
    extra["compose_version"] = "1.6.7"
    extra["kotlin_version"] = "1.8.22"
    extra["material3_version"] = "1.2.1"
    extra["lifecycle_version"] = "2.4.0"
    extra["activity_compose_version"] = "1.3.1"
    extra["navigation_compose_version"] = "2.4.0-alpha10"
    extra["retrofit_version"] = "2.9.0"
    extra["okhttp_version"] = "4.9.1"
    extra["moshi_version"] = "1.15.1"
    extra["core_ktx_version"] = "1.7.0"
    extra["junit_version"] = "4.13.2"
    extra["androidx_test_ext_junit_version"] = "1.1.3"
    extra["espresso_core_version"] = "3.4.0"

    implementation(libs.androidx.foundation.android)
    val composeVersion = extra["compose_version"] as String
    val kotlinVersion = extra["kotlin_version"] as String
    val material3Version = extra["material3_version"] as String
    val lifecycleVersion = extra["lifecycle_version"] as String
    val activityComposeVersion = extra["activity_compose_version"] as String
    val navigationComposeVersion = extra["navigation_compose_version"] as String
    val retrofitVersion = extra["retrofit_version"] as String
    val okhttpVersion = extra["okhttp_version"] as String
    val moshiVersion = extra["moshi_version"] as String
    val coreKtxVersion = extra["core_ktx_version"] as String
    val junitVersion = extra["junit_version"] as String
    val androidxTestExtJunitVersion = extra["androidx_test_ext_junit_version"] as String
    val espressoCoreVersion = extra["espresso_core_version"] as String

    implementation("androidx.core:core-ktx:$coreKtxVersion")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleVersion")
    implementation("androidx.activity:activity-compose:1.9.0")
    implementation("androidx.compose.ui:ui:$composeVersion")
    implementation("androidx.compose.material:material:$composeVersion")
    implementation("androidx.compose.ui:ui-tooling-preview:$composeVersion")
    implementation("androidx.navigation:navigation-compose:$navigationComposeVersion")
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation("com.squareup.retrofit2:converter-gson:$retrofitVersion")
    implementation("com.squareup.okhttp3:okhttp:$okhttpVersion")
    implementation("com.squareup.okhttp3:logging-interceptor:$okhttpVersion")
    implementation("androidx.compose.runtime:runtime-livedata:$composeVersion")

    implementation("androidx.compose.material3:material3:$material3Version")
    implementation("com.squareup.moshi:moshi:$moshiVersion")
    implementation("com.squareup.moshi:moshi-kotlin:$moshiVersion")
    implementation("com.squareup.moshi:moshi-adapters:$moshiVersion")

    debugImplementation("androidx.compose.ui:ui-tooling:$composeVersion")
    debugImplementation("androidx.compose.ui:ui-test-manifest:$composeVersion")

    testImplementation("junit:junit:$junitVersion")
    androidTestImplementation("androidx.test.ext:junit:$androidxTestExtJunitVersion")
    androidTestImplementation("androidx.test.espresso:espresso-core:$espressoCoreVersion")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:$composeVersion")
    implementation("androidx.core:core-ktx:$coreKtxVersion")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleVersion")
    implementation("androidx.activity:activity-compose:$activityComposeVersion")
    implementation("androidx.compose.ui:ui:$composeVersion")
    implementation("androidx.compose.material:material:$composeVersion")
    implementation("androidx.compose.ui:ui-tooling-preview:$composeVersion")
    implementation("androidx.navigation:navigation-compose:$navigationComposeVersion")
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation("com.squareup.retrofit2:converter-gson:$retrofitVersion")
    implementation("com.squareup.okhttp3:okhttp:$okhttpVersion")
    implementation("com.squareup.okhttp3:logging-interceptor:$okhttpVersion")
    implementation("androidx.compose.runtime:runtime-livedata:$composeVersion")
    implementation("androidx.compose.material3:material3:$material3Version")
    implementation("com.squareup.moshi:moshi:$moshiVersion")
    implementation("com.squareup.moshi:moshi-kotlin:$moshiVersion")
    implementation("com.squareup.moshi:moshi-adapters:$moshiVersion")
    debugImplementation("androidx.compose.ui:ui-tooling:$composeVersion")
    debugImplementation("androidx.compose.ui:ui-test-manifest:$composeVersion")
    testImplementation("junit:junit:$junitVersion")
    androidTestImplementation("androidx.test.ext:junit:$androidxTestExtJunitVersion")
    androidTestImplementation("androidx.test.espresso:espresso-core:$espressoCoreVersion")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:$composeVersion")


}
