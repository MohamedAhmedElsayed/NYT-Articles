plugins {
    alias(libs.plugins.nytarticles.android.feature)
}

android {
    namespace = "com.nyt.articles.popular.domain"

}

dependencies {
    implementation(projects.core.domain)
    testImplementation(libs.bundles.testing)
}