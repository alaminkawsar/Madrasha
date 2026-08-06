# AI Agent Guidelines for Madrasha Android App

## Architecture Overview
This is a Jetpack Compose Android app for an Islamic School Management System, following Clean Architecture principles:
- **presentation/**: UI screens and ViewModels (e.g., `presentation/sign_in/LoginScreen.kt`)
- **domain/**: Business models (e.g., `domain/model/LoginPayload.kt`)
- **data/**: Repositories and data sources (e.g., `data/LoginRepository.kt`)
- **core/**: Shared utilities, components, and constants (e.g., `core/util/UserRole.kt`)

## Key Patterns
- **Role-Based Navigation**: App starts at authentication route, navigates to role-specific screens (ADMIN, TEACHER, STUDENT, GUARDIAN) based on login success. See `Navigation.kt` and `MainActivity.kt`.
- **Admin Drawer Navigation**: Admin screens use `ModalNavigationDrawer` with `AdminDrawerScreen` enum for sections like DASHBOARD, STUDENT, TEACHER. Example in `presentation/admin/AdminHomeScreen.kt`.
- **Hilt Dependency Injection**: Use `@AndroidEntryPoint` for activities/fragments, `@HiltViewModel` for ViewModels. Modules in `di/AppModule.kt` (currently minimal, only SharedPreferences).
- **Compose Theming**: Custom colors in `ui/theme/Color.kt` (note: Color.kt package is still `com.khidmah.al_hisan.ui.theme` - should be updated to `com.khidmah.madrasha`). Primary colors: `PrimaryGreen`, `LightBlue`.
- **Version Catalog**: Dependencies managed in `gradle/libs.versions.toml`. Use `libs.` prefix in build files (e.g., `libs.androidx.material3`).

## Conventions
- **Package Structure**: Follow layered architecture; avoid deep nesting beyond layers.
- **Screen Routes**: Defined in `core/util/Screen.kt` as sealed classes with `route` property. Use `withArgs()` for parameterized routes.
- **User Roles**: Enum in `core/util/UserRole.kt` - always handle all four roles in navigation/switch statements.
- **Logging**: Use `val TAG = "[ClassName]"` for consistent log tags, e.g., `Log.d(TAG, "message")`.
- **Compose Previews**: Add `@Preview` to composables for UI testing, e.g., `TopSection()` in login screen.
- **State Management**: Use `remember` and `mutableStateOf` for local state; ViewModels for business logic with `hiltViewModel()`.

## Build & Run
- **Gradle Wrapper**: Use `./gradlew` commands (Windows: `gradlew.bat`).
- **Min SDK**: 24, Target SDK: 36, Java 17.
- **Debug Builds**: Compose tooling enabled in debug via `libs.androidx.ui.tooling`.
- **Proguard**: Disabled in release; rules in `proguard-rules.pro`.

## Common Tasks
- **Add New Screen**: Create in appropriate `presentation/` subfolder, add route to `Screen.kt`, update `Navigation.kt`.
- **Add Dependency**: Add to `libs.versions.toml` under [libraries], reference as `libs.libraryName` in build files.
- **Network Calls**: Uncomment and adapt OkHttp/Retrofit setup in `di/AppModule.kt` when implementing API integration.</content>
<parameter name="filePath">C:\Users\Khalid_HP\Desktop\Work\Project\Android\Madrasha\AGENTS.md
