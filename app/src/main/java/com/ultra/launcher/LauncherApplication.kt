package com.ultra.launcher

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import com.ultra.launcher.utils.PerformanceOptimizer

/**
 * Main application class for UltraLauncher
 * Handles initialization and global configuration
 */
@HiltAndroidApp
class LauncherApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        
        // Initialize performance optimization
        PerformanceOptimizer.initialize(this)
        
        // Set up crash handler
        setupCrashHandler()
    }

    private fun setupCrashHandler() {
        val defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler()
        Thread.setDefaultUncaughtExceptionHandler { thread, exception ->
            android.util.Log.e("UltraLauncher", "Uncaught exception: ", exception)
            defaultUncaughtExceptionHandler?.uncaughtException(thread, exception)
        }
    }
}
