# UltraLauncher Architecture

## Overview

UltraLauncher follows Clean Architecture principles with MVVM pattern.

```
┌─────────────────────────────────────┐
│           UI Layer                  │
│  (Compose, Activities, Fragments)   │
└────────────────────┬────────────────┘
                     │
┌────────────────────▼────────────────┐
│      ViewModel Layer                │
│  (State Management, Logic)          │
└────────────────────┬────────────────┘
                     │
┌────────────────────▼────────────────┐
│      Domain Layer                   │
│  (Use Cases, Entities, Interfaces)  │
└────────────────────┬────────────────┘
                     │
┌────────────────────▼────────────────┐
│      Data Layer                     │
│  (Repository, DataSources, APIs)    │
└─────────────────────────────────────┘
```

## Modules

### app
Main application module containing UI and Activities.

### core
Shared utilities, extensions, and constants.

### data
Data layer with repositories, DAOs, and data sources.

### domain
Business logic, use cases, and domain models.

## Key Components

### 1. MainActivity
Main entry point with Compose UI.

### 2. HomeViewModel
Manages home screen state and app list.

### 3. AppRepository
Handles app installation, launch, and management.

### 4. ThemeManager
Dynamic theming system.

### 5. GestureDetector
Custom gesture recognition.

## Dependency Injection

Using Hilt for DI:

```kotlin
@Singleton
class MyRepository @Inject constructor(
    private val dao: MyDao
) { ... }

@HiltViewModel
class MyViewModel @Inject constructor(
    private val repo: MyRepository
) : ViewModel() { ... }
```

## Data Flow

1. **UI Layer** emits user actions
2. **ViewModel** processes and updates state
3. **Domain Layer** executes business logic
4. **Data Layer** fetches/stores data
5. **Result flows back** to UI

## Performance Optimization

- Hardware acceleration enabled
- Efficient rendering with Compose
- Lazy loading of app list
- Memory-efficient image loading
- Background thread processing
