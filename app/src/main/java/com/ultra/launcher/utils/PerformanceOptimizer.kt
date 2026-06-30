package com.ultra.launcher.utils

import android.app.Application
import android.content.Context
import android.os.Build
import android.os.Process

/**
 * Performance optimization utilities for UltraLauncher
 */
object PerformanceOptimizer {

    fun initialize(app: Application) {
        optimizeMemory(app)
        optimizeThreadPriority()
        optimizeHardware()
    }

    private fun optimizeMemory(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            try {
                val runtime = Runtime.getRuntime()
                runtime.exec("pm trimcaches 0")
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun optimizeThreadPriority() {
        Process.setThreadPriority(Process.THREAD_PRIORITY_DISPLAY)
    }

    private fun optimizeHardware() {
        // Hardware acceleration is enabled in manifest
    }

    fun clearCache(context: Context) {
        Thread {
            try {
                context.cacheDir.deleteRecursively()
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    context.codeCacheDir.deleteRecursively()
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }.start()
    }
}
