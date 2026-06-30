package com.ultra.launcher.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ultra.launcher.viewmodels.HomeViewModel
import com.ultra.launcher.ui.components.AppGrid
import com.ultra.launcher.ui.components.AppDrawer
import com.ultra.launcher.ui.components.TopBar

/**
 * Home Screen - Main launcher screen with apps and widgets
 */
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state by viewModel.homeScreenState.collectAsState()
    val showAppDrawer = remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {
            // Top status bar area
            TopBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                onSettingsClick = { showAppDrawer.value = true }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Main app grid
            AppGrid(
                apps = state.apps,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                columns = state.gridColumns,
                onAppClick = { app ->
                    viewModel.launchApp(app)
                },
                onAppLongPress = { app ->
                    viewModel.onAppLongPress(app)
                }
            )

            Spacer(modifier = Modifier.height(32.dp))
        }

        // App Drawer Bottom Sheet
        if (showAppDrawer.value) {
            AppDrawer(
                apps = state.allApps,
                onDismiss = { showAppDrawer.value = false },
                onAppClick = { app ->
                    viewModel.launchApp(app)
                    showAppDrawer.value = false
                }
            )
        }
    }
}
