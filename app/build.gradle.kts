plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
}

android {
    namespace = "com.android.app.sentifiapp"
    compileSdk {
        version = release(37)
    }

    defaultConfig {
        applicationId = "com.android.app.sentifiapp"
        minSdk = 25
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            optimization {
                enable = false
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
    val room_version = "2.8.4"

    implementation("androidx.room:room-runtime:$room_version")
    ksp("androidx.room:room-compiler:$room_version")

// Optional - Coroutines support
    implementation("androidx.room:room-ktx:$room_version")

// Optional - Testing
    testImplementation("androidx.room:room-testing:$room_version")

    val work_version = "2.11.0"

// Java only
    implementation ("androidx.work:work-runtime:$work_version")

// Kotlin + coroutines
    implementation ("androidx.work:work-runtime-ktx:$work_version")

// Optional - GCMNetworkManager support
    implementation ("androidx.work:work-gcm:$work_version")

// Optional - Test helpers
    androidTestImplementation ("androidx.work:work-testing:$work_version")

// Optional - Multiprocess support
    implementation ("androidx.work:work-multiprocess:$work_version")

    // Retrofit core library
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
// Converter for JSON (Gson)
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
// Optional: For RxJava support
    implementation("com.squareup.retrofit2:adapter-rxjava2:2.9.0")
// Optional: For Moshi JSON parsing
    implementation("com.squareup.retrofit2:converter-moshi:2.9.0")

    testImplementation(libs.junit)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
    debugImplementation(libs.androidx.compose.ui.tooling)
}