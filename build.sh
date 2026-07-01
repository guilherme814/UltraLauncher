#!/bin/bash

# UltraLauncher Build Script
# This script automates the APK build process

set -e

echo "🚀 UltraLauncher Build Script"
echo "========================================"

# Colors for output
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
NC='\033[0m' # No Color

# Check if Gradle wrapper exists
if [ ! -f "./gradlew" ]; then
    echo -e "${RED}❌ Error: gradlew not found${NC}"
    exit 1
fi

# Make gradlew executable
chmod +x ./gradlew

echo -e "${BLUE}📦 Building UltraLauncher...${NC}"

# Clean previous builds
echo -e "${YELLOW}🧹 Cleaning previous builds...${NC}"
./gradlew clean

# Build debug APK
echo -e "${YELLOW}🔨 Building Debug APK...${NC}"
./gradlew assembleDebug
echo -e "${GREEN}✅ Debug APK built successfully!${NC}"
echo -e "${GREEN}📍 Location: app/build/outputs/apk/debug/app-debug.apk${NC}"

# Build release APK
echo -e "${YELLOW}🔨 Building Release APK...${NC}"
./gradlew assembleRelease
echo -e "${GREEN}✅ Release APK built successfully!${NC}"
echo -e "${GREEN}📍 Location: app/build/outputs/apk/release/app-release.apk${NC}"

echo ""
echo -e "${GREEN}========================================${NC}"
echo -e "${GREEN}🎉 Build completed successfully!${NC}"
echo -e "${GREEN}========================================${NC}"
echo ""
echo -e "${BLUE}📊 Build Summary:${NC}"
echo "  Debug APK:   app/build/outputs/apk/debug/app-debug.apk"
echo "  Release APK: app/build/outputs/apk/release/app-release.apk"
echo ""
echo -e "${BLUE}📱 Installation:${NC}"
echo "  adb install -r app/build/outputs/apk/debug/app-debug.apk"
echo "  adb install app/build/outputs/apk/release/app-release.apk"
echo ""
