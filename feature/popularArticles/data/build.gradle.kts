plugins {
    alias(libs.plugins.nytarticles.android.feature)
}

android {
    namespace = "com.nyt.articles.popular.data"
}

dependencies {
    implementation(projects.core.data)
    implementation(projects.feature.popularArticles.domain)
    implementation(libs.bundles.networking.retrofit)
    testImplementation(libs.bundles.testing)

}