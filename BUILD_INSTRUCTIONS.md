# UltraLauncher Build Instructions

## Prerequisites

- Android Studio 2023.1 or later
- Java Development Kit (JDK) 17
- Android SDK 34 (API level 34)
- Gradle 8.0+
- At least 8GB RAM
- 10GB free disk space

## Setup

### 1. Clone Repository
```bash
git clone https://github.com/guilherme814/UltraLauncher.git
cd UltraLauncher
```

### 2. Configure Local Properties
```bash
cp local.properties.example local.properties
# Edit local.properties and set your SDK/NDK paths
```

### 3. Build Debug APK
```bash
./gradlew assembleDebug
```
Output: `app/build/outputs/apk/debug/app-debug.apk`

### 4. Build Release APK
```bash
./gradlew assembleRelease
```
Output: `app/build/outputs/apk/release/app-release.apk`

## Build Variants

### Debug Build (Development)
```bash
./gradlew installDebug
```
- Faster compilation
- Better debugging
- Not optimized
- Larger file size

### Release Build (Production)
```bash
./gradlew assembleRelease
```
- Optimized code (ProGuard)
- Smaller file size (~15-20MB)
- Code obfuscation
- Resource shrinking

## Custom Build Tasks

### Build All Modules
```bash
./gradlew buildAllModules
```

### Build Release APK with Task
```bash
./gradlew buildReleaseAPK
```

## Testing

### Run Unit Tests
```bash
./gradlew test
```

### Run Instrumented Tests
```bash
./gradlew connectedAndroidTest
```

## Performance

### Enable Build Cache
```bash
./gradlew build --build-cache
```

### Parallel Gradle Build
```bash
./gradlew build -x test --parallel
```

### Profile Build
```bash
./gradlew assembleRelease --profile
```

## Troubleshooting

### Clean Build
```bash
./gradlew clean build
```

### Clear Cache
```bash
./gradlew cleanBuildCache
```

### Force Download Dependencies
```bash
./gradlew clean build --refresh-dependencies
```

### Check Dependencies
```bash
./gradlew dependencies
```

## Output Locations

- **Debug APK**: `app/build/outputs/apk/debug/app-debug.apk`
- **Release APK**: `app/build/outputs/apk/release/app-release.apk`
- **Build Reports**: `app/build/reports/`
- **Test Results**: `app/build/test-results/`

## Environment Variables

```bash
export GRADLE_OPTS="-Xmx2048m -XX:MaxPermSize=512m"
export ANDROID_HOME="/path/to/android/sdk"
export ANDROID_SDK_ROOT="/path/to/android/sdk"
export PATH="$PATH:$ANDROID_HOME/platform-tools:$ANDROID_HOME/tools"
```

## CI/CD Integration

### GitHub Actions Example
Create `.github/workflows/build.yml`:

```yaml
name: Build APK

on:
  push:
    branches: [ main ]
  pull_request:
    branches: [ main ]

jobs:
  build:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v3
      - uses: actions/setup-java@v3
        with:
          java-version: 17
          distribution: 'temurin'
      - run: ./gradlew assembleRelease
      - uses: actions/upload-artifact@v3
        with:
          name: UltraLauncher-release.apk
          path: app/build/outputs/apk/release/app-release.apk
```

## Support

For issues, check:
1. Android SDK is installed correctly
2. Java version is 17+
3. Gradle wrapper is up to date
4. All dependencies are downloaded

For more help, open an issue on GitHub.
