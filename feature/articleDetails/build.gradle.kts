plugins {
    alias(libs.plugins.nytarticles.android.feature)
    alias(libs.plugins.nytarticles.android.library.compose)
}

android {
    namespace = "com.nyt.popular.article.details"

}

dependencies {
    implementation(projects.core.common)
    implementation(projects.core.presentation)
    implementation(projects.feature.articleDetails.presentation)
}