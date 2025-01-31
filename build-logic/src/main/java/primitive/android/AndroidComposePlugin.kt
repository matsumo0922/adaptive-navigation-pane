package primitive.android

import me.matsumo.adaptive.androidTestImplementation
import me.matsumo.adaptive.commonExt
import me.matsumo.adaptive.debugImplementation
import me.matsumo.adaptive.implementation
import me.matsumo.adaptive.library
import me.matsumo.adaptive.libs
import me.matsumo.adaptive.plugin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidComposePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(libs.plugin("kotlin-compose-compiler").pluginId)
            }

            commonExt {
                buildFeatures.compose = true
            }

            dependencies {
                val bom = libs.library("androidx-compose-bom")

                implementation(project.dependencies.platform(bom))
                implementation(libs.library("androidx-compose-ui-tooling-preview"))
                debugImplementation(libs.library("androidx-compose-ui-tooling"))
                androidTestImplementation(project.dependencies.platform(bom))
            }
        }
    }
}
