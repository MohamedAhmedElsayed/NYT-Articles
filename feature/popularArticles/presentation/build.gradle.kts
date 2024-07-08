plugins {
    alias(libs.plugins.nytarticles.android.feature)
    alias(libs.plugins.nytarticles.android.library.compose)
}

android {
    namespace = "com.nyt.popular.articles.presentation"
}


dependencies {
    implementation(projects.core.common)
    implementation(projects.core.domain)
    implementation(projects.core.presentation)
    implementation(projects.feature.popularArticles.domain)
    testImplementation(libs.bundles.testing)
    testImplementation(libs.coroutines.test)
    androidTestImplementation(libs.bundles.android.test)


}