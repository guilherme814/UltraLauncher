# Dynamic Theme System

## Features

### 1. Material You Integration
- Automatic color extraction from wallpaper
- Adaptive color schemes
- Dynamic dark/light mode

### 2. Custom Themes
- Create unlimited themes
- Export/Import theme files
- Theme scheduling

### 3. Per-App Theming
- Different themes for different apps
- App-specific icon packs
- Adaptive UI

## API

```kotlin
themeManager.setPrimaryColor(Color.Blue)
themeManager.setSecondaryColor(Color.Green)
themeManager.getTertiaryColor()
themeManager.isDarkMode()
```

## Theme File Format

```json
{
  "name": "Night Mode",
  "dark": true,
  "colors": {
    "primary": "#6650a4",
    "secondary": "#625b71",
    "tertiary": "#7D5260",
    "background": "#1C1B1F",
    "surface": "#2D2C2F"
  },
  "schedule": {
    "enable": true,
    "startTime": "20:00",
    "endTime": "08:00"
  }
}
```

## Creating a Theme

1. Open Settings → Themes
2. Tap "Create Theme"
3. Choose base template
4. Customize colors
5. Set icon pack
6. Configure fonts
7. Save and apply

## Material You Support

```kotlin
if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
    // Use dynamic colors from wallpaper
    val colorScheme = dynamicColorScheme(context)
}
```
