import com.nyt.articles.build_logic.convention.implementation

plugins {
    alias(libs.plugins.nytarticles.android.application)
    alias(libs.plugins.nytarticles.android.application.compose)
    alias(libs.plugins.nytarticles.android.hilt)
}

android {
    namespace = "com.nyt.articles"

    defaultConfig {
        applicationId = "com.nyt.articles"
        versionCode = 1
        versionName = "0.0.1"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
        }
    }

}

dependencies {
    implementation(projects.feature.popularArticles)
    implementation(projects.feature.articleDetails)
    implementation(projects.core.common)
    implementation(projects.core.presentation)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.activity.compose)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation(libs.androidx.navigation.compose)
}
