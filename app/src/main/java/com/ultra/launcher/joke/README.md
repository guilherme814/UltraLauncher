# Joke Generator Feature

## Overview

The Joke Generator is a feature that fetches random jokes from the JokeAPI external service and displays them in a beautiful UI.

## API Used

**JokeAPI** - https://v2.jokeapi.dev

### Features:
- Random jokes from multiple categories
- Single-part and two-part jokes
- No authentication required
- Free and unlimited

## Architecture

### Components:

1. **JokeApiService** - Retrofit interface for API calls
2. **JokeRepository** - Data layer for API interactions
3. **JokeViewModel** - Business logic and state management
4. **JokeScreen** - UI with Jetpack Compose

## Usage

```kotlin
// In your Composable
JokeGeneratorScreen()

// Or with custom ViewModel
val viewModel = JokeViewModel()
JokeGeneratorScreen(viewModel = viewModel)
```

## Features

- ✅ Fetch random jokes via API
- ✅ Display single and two-part jokes
- ✅ Category display
- ✅ Loading state with spinner
- ✅ Error handling
- ✅ Refresh button
- ✅ Beautiful Material Design UI

## Data Flow

```
JokeScreen (UI)
    ↓
JokeViewModel (State Management)
    ↓
JokeRepository (Data Layer)
    ↓
JokeApiService (Network)
    ↓
JokeAPI (External Service)
```

## Error Handling

- Network errors
- API errors
- Invalid responses
- Timeout handling

## Future Enhancements

- [ ] Joke caching
- [ ] Favorite jokes
- [ ] Share jokes
- [ ] Category filters
- [ ] Offline support
