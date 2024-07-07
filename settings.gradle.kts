pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "NYTArticles"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
include(":app")
include(":feature:home")
include(":feature:login")
include(":core:data")
include(":core:common")
include(":feature:popularArticles")
include(":feature:popularArticles:presentation")
include(":core:presentation")
include(":core:domain")
include(":feature:popularArticles:domain")
include(":feature:popularArticles:data")
include(":feature:articleDetails")
include(":feature:articleDetails:presentation")
