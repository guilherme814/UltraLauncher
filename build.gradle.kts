// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.0" apply false
    id("com.android.library") version "8.1.0" apply false
    kotlin("android") version "1.9.10" apply false
    kotlin("jvm") version "1.9.10" apply false
    kotlin("kapt") version "1.9.10" apply false
    id("com.google.dagger.hilt.android") version "2.47" apply false
    id("com.google.devtools.ksp") version "1.9.10-1.0.13" apply false
}

task<Delete>("clean") {
    delete(rootProject.buildDir)
}

subprojects {
    // Common configuration for all subprojects
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "17"
            freeCompilerArgs += "-opt-in=kotlin.RequiresOptIn"
        }
    }
}
