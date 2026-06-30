package com.ultra.launcher.domain.models

data class AppInfo(
    val packageName: String,
    val label: String,
    val icon: Any,
    val versionName: String,
    val versionCode: Int,
    val isPinned: Boolean = false,
    val launchCount: Int = 0,
    val lastLaunchTime: Long = 0
)
