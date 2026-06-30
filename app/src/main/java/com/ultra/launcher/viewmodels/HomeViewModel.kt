package com.ultra.launcher.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ultra.launcher.domain.models.AppInfo
import com.ultra.launcher.domain.repositories.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class HomeScreenState(
    val apps: List<AppInfo> = emptyList(),
    val allApps: List<AppInfo> = emptyList(),
    val gridColumns: Int = 5,
    val isLoading: Boolean = false
)

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val appRepository: AppRepository
) : ViewModel() {

    private val _homeScreenState = MutableStateFlow(HomeScreenState())
    val homeScreenState: StateFlow<HomeScreenState> = _homeScreenState.asStateFlow()

    init {
        loadApps()
    }

    private fun loadApps() {
        viewModelScope.launch {
            try {
                _homeScreenState.value = _homeScreenState.value.copy(isLoading = true)
                
                val apps = appRepository.getInstalledApps()
                val pinnedApps = appRepository.getPinnedApps()
                
                _homeScreenState.value = _homeScreenState.value.copy(
                    apps = pinnedApps,
                    allApps = apps,
                    isLoading = false
                )
            } catch (e: Exception) {
                e.printStackTrace()
                _homeScreenState.value = _homeScreenState.value.copy(isLoading = false)
            }
        }
    }

    fun launchApp(app: AppInfo) {
        viewModelScope.launch {
            appRepository.launchApp(app)
        }
    }

    fun onAppLongPress(app: AppInfo) {
        // Handle long press
    }
}
