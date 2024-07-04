plugins {
    alias(libs.plugins.nytarticles.android.feature)
    alias(libs.plugins.nytarticles.android.library.compose)
}


android {
    namespace = "com.nyt.articles.popular"


}

dependencies {
    api(projects.feature.popularArticles.presentation)
}