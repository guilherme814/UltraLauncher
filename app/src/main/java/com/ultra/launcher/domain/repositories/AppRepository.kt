package com.ultra.launcher.domain.repositories

import com.ultra.launcher.domain.models.AppInfo

interface AppRepository {
    suspend fun getInstalledApps(): List<AppInfo>
    suspend fun getPinnedApps(): List<AppInfo>
    suspend fun launchApp(app: AppInfo)
    suspend fun uninstallApp(app: AppInfo)
    suspend fun pinApp(app: AppInfo)
    suspend fun unpinApp(app: AppInfo)
}
