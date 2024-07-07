# Android Task Application

This repository contains an Android application developed to display the NYT popular articles and the article details. The application follows the principles of Clean Architecture and MVI (Model-View-Intent) pattern, utilizes Jetpack Compose for the UI, and is modularized by feature combined with layer. The attached files include the source code and an APK for installation.

## Table of Contents

- [Architecture](#architecture)
- [Attached Files](#attached-files)
- [Unit Testing](#unit-testing)
- [Video And APK](#video-and-APK)
 

## Architecture

### Clean Architecture

The application follows Clean Architecture principles, which promote separation of concerns and make the codebase easier to maintain and test. The project is divided into multiple layers:

- **Presentation Layer:** Contains the UI components (Jetpack Compose components) and ViewModels.
- **Domain Layer:** Contains use cases and business logic.
- **Data Layer:** Contains repositories, remote data source, and models.

### MVI Pattern

The application uses the MVI (Model-View-Intent) pattern, which ensures a unidirectional data flow and improves the predictability of the state management. The components of MVI are:

- **Model:** Represents the state of the UI.
- **View:** Displays the state and sends user intents to the ViewModel.
- **Intent:** Represents the user's actions and events.

### Modularization by Feature Combined with Layer

The project is organized into modules based on features and layers, which helps in managing dependencies, improving build times, and enabling reusability. The modules are:

- **app:** The main application module.
- **build-logic** Which manages the app dependencies and plugins.
- **feature-popular-articles:** Display list of popular articles based on the selected period.
- **feature-article-details:** Which display the details for the selected article.
- **core-domain:** Contains the core domain layer.
- **core-data:** Contains the core data layer.
- **core-common:** Contains utility classes and extensions.
- **core-presentation:** contains the common compose components.


### Libraries and Tools

- **Kotlin:** The programming language used for development.
- **Jetpack Compose:** Modern UI toolkit for building native Android UI.
- **Kotlin Coroutines:** For asynchronous programming and handling background tasks.
- **Hilt:** Dependency Injection library.
- **Retrofit:** For network operations and API calls.
- **Moshi** to convert the remote resposne.
- **Coil:** For image loading and disck cashing.
- **Navigation Component:** For handling in-app navigation.
- **version catalog:** To manage the app gradle dependencies.

## Attached Files

- **Source Code:** The complete source code of the application.
- **APK:** The compiled APK file for installation.
- **Video** To show the app while running.

## Unit Testing

Unit tests are included to ensure the correctness of the business logic The tests are written using JUnit and the mockito.

## Video and APK
https://drive.google.com/drive/folders/1B2HqxlwQ3RWe809s18TsYQkDfgxy9eXp?usp=sharing

 
