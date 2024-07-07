plugins {
    alias(libs.plugins.nytarticles.android.feature)
    alias(libs.plugins.nytarticles.android.library.compose)
}


android {
    namespace = "com.nyt.articles.popular"
}

dependencies {
    implementation(projects.core.common)
    implementation(projects.feature.popularArticles.presentation)
    implementation(projects.feature.popularArticles.domain)
    implementation(projects.feature.popularArticles.data)
}