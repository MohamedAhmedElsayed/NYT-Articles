import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("nytarticles.android.library")
                apply("nytarticles.android.hilt")
                apply("org.jetbrains.kotlin.plugin.serialization")
                apply("kotlin-parcelize")
            }

            dependencies {

            }
        }
    }
}
