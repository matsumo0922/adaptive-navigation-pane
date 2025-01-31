plugins {
    id("matsumo.primitive.kmp.common")
    id("matsumo.primitive.android.library")
    id("matsumo.primitive.android.common")
    id("matsumo.primitive.kmp.android")
    id("matsumo.primitive.kmp.ios")
    id("matsumo.primitive.kmp.compose")
    id("matsumo.primitive.detekt")
    id("matsumo.primitive.maven.publish")
}

android {
    namespace = "me.matsumo.adaptive"
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(libs.bundles.infra.api)

            implementation(compose.runtime)
            implementation(compose.runtimeSaveable)
            implementation(compose.foundation)
            implementation(compose.animation)
            implementation(compose.animationGraphics)
            implementation(compose.material)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.materialIconsExtended)
        }

        androidMain.dependencies {
            implementation(libs.androidx.startup)
        }
    }
}
