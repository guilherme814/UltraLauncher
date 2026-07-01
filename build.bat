@echo off
REM UltraLauncher Build Script for Windows
REM This script automates the APK build process

echo.
echo 🚀 UltraLauncher Build Script
echo ========================================

REM Check if gradlew.bat exists
if not exist "gradlew.bat" (
    echo ❌ Error: gradlew.bat not found
    exit /b 1
)

echo 📦 Building UltraLauncher...

REM Clean previous builds
echo 🧹 Cleaning previous builds...
call gradlew.bat clean

REM Build debug APK
echo 🔨 Building Debug APK...
call gradlew.bat assembleDebug
echo ✅ Debug APK built successfully!
echo 📍 Location: app\build\outputs\apk\debug\app-debug.apk

REM Build release APK
echo 🔨 Building Release APK...
call gradlew.bat assembleRelease
echo ✅ Release APK built successfully!
echo 📍 Location: app\build\outputs\apk\release\app-release.apk

echo.
echo ========================================
echo 🎉 Build completed successfully!
echo ========================================
echo.
echo 📊 Build Summary:
echo   Debug APK:   app\build\outputs\apk\debug\app-debug.apk
echo   Release APK: app\build\outputs\apk\release\app-release.apk
echo.
echo 📱 Installation:
echo   adb install -r app\build\outputs\apk\debug\app-debug.apk
echo   adb install app\build\outputs\apk\release\app-release.apk
echo.
pause
