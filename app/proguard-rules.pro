# UltraLauncher ProGuard rules

# Keep main classes
-keep class com.ultra.launcher.** { *; }
-keep class com.ultra.launcher.ui.** { *; }
-keep class com.ultra.launcher.domain.** { *; }

# Keep Android classes
-keep class android.** { *; }
-keep class androidx.** { *; }

# Keep model classes
-keep class com.ultra.launcher.domain.models.** { *; }

# Keep Hilt classes
-keep class dagger.hilt.** { *; }
-keep class javax.inject.** { *; }

# Keep Room classes
-keep class androidx.room.** { *; }

# Keep serialization
-keep class kotlinx.serialization.** { *; }

# Remove logging
-assumenosideeffects class android.util.Log {
    public static *** d(...);
    public static *** v(...);
    public static *** i(...);
}

# Optimization
-optimizationpasses 5
-dontobfuscate
