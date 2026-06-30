# Gesture System Guide

## Supported Gestures

### 1. Swipe Up
**Action**: Open app drawer
**Detection**: Upward swipe motion
**Sensitivity**: 100+ pixels, 100+ velocity

### 2. Swipe Down
**Action**: Open quick settings / notifications
**Detection**: Downward swipe motion
**Sensitivity**: 100+ pixels, 100+ velocity

### 3. Swipe Left
**Action**: Previous page / screen
**Detection**: Leftward swipe motion
**Sensitivity**: 100+ pixels, 100+ velocity

### 4. Swipe Right
**Action**: Next page / screen
**Detection**: Rightward swipe motion
**Sensitivity**: 100+ pixels, 100+ velocity

### 5. Long Press
**Action**: Edit mode / context menu
**Detection**: Press and hold for 500ms
**Position**: Returns X, Y coordinates

### 6. Double Tap
**Action**: Lock/Unlock screen
**Detection**: Two quick taps
**Time**: Within 300ms

### 7. Pinch
**Action**: Zoom grid in/out
**Detection**: Multi-touch pinch
**Sensitivity**: Scale factor detection

## Customization

### Change Swipe Threshold

Edit `GestureDetector.kt`:

```kotlin
companion object {
    private const val SWIPE_THRESHOLD = 100  // pixels
    private const val SWIPE_VELOCITY_THRESHOLD = 100  // px/s
    private const val DOUBLE_TAP_TIME = 300  // ms
}
```

### Add Custom Gesture

```kotlin
class LauncherGestureDetector(
    private val callbacks: GestureCallbacks
) : GestureDetector.OnGestureListener {
    
    interface GestureCallbacks {
        // Add new callback
        fun onCustomGesture()
    }
    
    // Implement detection logic
}
```

## Xiaomi/MIUI Gesture Integration

### Gesture Bar Support

UltraLauncher supports Xiaomi gesture bar:

- Swipe up from gesture bar → App drawer
- Swipe down from gesture bar → Quick settings
- Left edge swipe → Back action
- Right edge swipe → Custom action
