plugins {
    alias(libs.plugins.nytarticles.android.library)
    alias(libs.plugins.nytarticles.android.library.compose)

}


android {
    namespace = "com.nyt.articles.presentation"
}
dependencies {
    implementation(projects.core.common)
}
