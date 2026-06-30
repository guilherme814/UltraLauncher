plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    namespace = "com.ultra.launcher.core"
    compileSdk = 34

    defaultConfig {
        minSdk = 31
        targetSdk = 34
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
}
