plugins {
    alias(libs.plugins.nytarticles.android.feature)
    alias(libs.plugins.nytarticles.android.library.compose)
}


android {
    namespace = "com.nyt.article.details.presentation"

}

dependencies {
    implementation(projects.core.common)
    implementation(projects.core.presentation)
}