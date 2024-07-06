import java.util.Properties

plugins {
    alias(libs.plugins.nytarticles.android.library)
    alias(libs.plugins.nytarticles.android.hilt)
}

android {
    namespace = "com.nyt.articles.core.data"

    defaultConfig {
        buildConfigField("String", "API_URL", "\"https://api.nytimes.com/\"")

        val properties = Properties()
        properties.load(project.rootProject.file("local.properties").inputStream())
        val apiKey: String? = properties.getProperty("API_KEY")
        buildConfigField("String", "API_KEY", "\"$apiKey\"")

    }
    buildFeatures {
        buildConfig = true
    }
}



dependencies {
    implementation(libs.bundles.networking.retrofit)
}