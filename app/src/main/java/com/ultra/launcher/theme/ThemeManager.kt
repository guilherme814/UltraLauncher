package com.ultra.launcher.theme

import android.content.Context
import android.content.SharedPreferences
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.ui.graphics.Color
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Theme Manager - Handles dynamic theming and theme customization
 */
@Singleton
class ThemeManager @Inject constructor(
    @ApplicationContext private val context: Context
) {

    private val prefs: SharedPreferences = context.getSharedPreferences(
        "launcher_themes",
        Context.MODE_PRIVATE
    )

    companion object {
        private const val PREF_PRIMARY_COLOR = "primary_color"
        private const val PREF_SECONDARY_COLOR = "secondary_color"
        private const val PREF_TERTIARY_COLOR = "tertiary_color"
        private const val PREF_DARK_MODE = "dark_mode"
    }

    fun getCurrentColorScheme(isDark: Boolean): ColorScheme {
        val primaryColor = getPrimaryColor()
        val secondaryColor = getSecondaryColor()
        val tertiaryColor = getTertiaryColor()

        return if (isDark) {
            darkColorScheme(
                primary = primaryColor,
                secondary = secondaryColor,
                tertiary = tertiaryColor
            )
        } else {
            lightColorScheme(
                primary = primaryColor,
                secondary = secondaryColor,
                tertiary = tertiaryColor
            )
        }
    }

    fun setPrimaryColor(color: Color) {
        prefs.edit().putInt(PREF_PRIMARY_COLOR, color.hashCode()).apply()
    }

    fun getPrimaryColor(): Color {
        val colorCode = prefs.getInt(PREF_PRIMARY_COLOR, 0xFF6650a4.toInt())
        return Color(colorCode.toLong())
    }

    fun setSecondaryColor(color: Color) {
        prefs.edit().putInt(PREF_SECONDARY_COLOR, color.hashCode()).apply()
    }

    fun getSecondaryColor(): Color {
        val colorCode = prefs.getInt(PREF_SECONDARY_COLOR, 0xFF625b71.toInt())
        return Color(colorCode.toLong())
    }

    fun setTertiaryColor(color: Color) {
        prefs.edit().putInt(PREF_TERTIARY_COLOR, color.hashCode()).apply()
    }

    fun getTertiaryColor(): Color {
        val colorCode = prefs.getInt(PREF_TERTIARY_COLOR, 0xFF7D5260.toInt())
        return Color(colorCode.toLong())
    }

    fun setDarkMode(enabled: Boolean) {
        prefs.edit().putBoolean(PREF_DARK_MODE, enabled).apply()
    }

    fun isDarkMode(): Boolean {
        return prefs.getBoolean(PREF_DARK_MODE, false)
    }
}
