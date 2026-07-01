# Quick Build Guide

## 🚀 Quick Start - 3 Steps

### Step 1: Prerequisites
```bash
# Verify you have:
# - Java 17+
java -version

# - Android SDK (in local.properties)
# - 8GB+ RAM
# - 10GB+ disk space
```

### Step 2: Configure
```bash
# Copy and edit local.properties
cp local.properties.example local.properties

# Edit to set your Android SDK path:
# sdk.dir=/path/to/android/sdk
# ndk.dir=/path/to/android/ndk (optional)
```

### Step 3: Build

#### Linux/macOS:
```bash
# Make script executable
chmod +x build.sh

# Run build
./build.sh
```

#### Windows:
```cmd
# Run batch file
build.bat
```

#### Or Manual (All Platforms):
```bash
# Debug APK
./gradlew assembleDebug
# Output: app/build/outputs/apk/debug/app-debug.apk

# Release APK
./gradlew assembleRelease
# Output: app/build/outputs/apk/release/app-release.apk
```

## 📱 Installation

```bash
# Install Debug APK
adb install -r app/build/outputs/apk/debug/app-debug.apk

# Install Release APK
adb install app/build/outputs/apk/release/app-release.apk

# Uninstall
adb uninstall com.ultra.launcher
```

## 🔍 Troubleshooting

### Build fails with "SDK not found"
1. Edit `local.properties`
2. Set correct `sdk.dir` path
3. Run `./gradlew clean`
4. Try building again

### Java version error
```bash
# Check Java version
java -version

# Should show 17 or higher
```

### OutOfMemory during build
```bash
# Increase Gradle heap
export GRADLE_OPTS="-Xmx2048m"
./gradlew assembleRelease
```

### Clean rebuild
```bash
./gradlew clean
./gradlew --stop
./gradlew assembleRelease
```

## ⚡ Performance Tips

### Parallel Build
```bash
./gradlew assembleRelease --parallel -x test
```

### Daemon Build
```bash
./gradlew assembleRelease --daemon
```

### Build Cache
```bash
./gradlew assembleRelease --build-cache
```

### Skip Tests
```bash
./gradlew assembleRelease -x test
```

## 📊 Build Output

```
✅ Success looks like:

BUILD SUCCESSFUL in 2m 45s

DEBUG APK:
  app/build/outputs/apk/debug/app-debug.apk (~45MB)

RELEASE APK:
  app/build/outputs/apk/release/app-release.apk (~18MB)
```

## 🎯 Next Steps

1. ✅ APK built
2. 📲 Install on device
3. 🎮 Test all features
4. 🚀 Ready to distribute!

## 📚 More Info

- Full guide: [BUILD_INSTRUCTIONS.md](BUILD_INSTRUCTIONS.md)
- Architecture: [docs/ARCHITECTURE.md](docs/ARCHITECTURE.md)
- Gesture system: [docs/GESTURE_GUIDE.md](docs/GESTURE_GUIDE.md)
- Theming: [docs/THEME_SYSTEM.md](docs/THEME_SYSTEM.md)

---

**Need help?** Check [CONTRIBUTING.md](CONTRIBUTING.md) or open an issue!
