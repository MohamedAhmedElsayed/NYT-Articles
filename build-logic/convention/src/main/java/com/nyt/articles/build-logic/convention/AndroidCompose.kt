package com.nyt.articles.build_logic.convention

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureAndroidCompose(
    commonExtension: CommonExtension<*, *, *, *, *, *>,
) {
    commonExtension.apply {
        buildFeatures {
            compose = true
        }

        composeOptions {
            kotlinCompilerExtensionVersion =
                libs.findVersion("androidxComposeCompiler").get().toString()
        }

        dependencies {
            val bom = libs.findLibrary("androidx-compose-bom").get()
            implementation(platform(bom))
            androidTestImplementation(platform(bom))
            implementation(libs.findLibrary("androidx.compose.material3").get())
            implementation(libs.findLibrary("androidx-compose-foundation").get())
            implementation(libs.findLibrary("androidx-lifecycle-viewModelCompose").get())
            implementation(libs.findLibrary("androidx-compose-ui-util").get())
            implementation(libs.findLibrary("androidx-compose-ui-tooling-preview").get())
            implementation(libs.findLibrary("compose-coil").get())
            implementation(libs.findLibrary("compose-icons").get())
            implementation(libs.findLibrary("androidx-navigation-compose").get())
            implementation(libs.findLibrary("kotlinx-serialization-json").get())
            debugImplementation(libs.findLibrary("androidx-compose-ui-tooling").get())

        }
    }
}
