plugins {
    id("matsumo.primitive.android.application")
    id("matsumo.primitive.android.common")
    id("matsumo.primitive.android.compose")
    id("matsumo.primitive.detekt")
}

android {
    namespace = "me.matsumo.adaptive.sample"

    // https://youtrack.jetbrains.com/issue/CMP-6707/Compose-Multiplatform-Resources-and-Kotlin-2.1.0-Beta1-SyncComposeResourcesForIosTask-configuration-failure
    tasks.findByName("checkSandboxAndWriteProtection")?.dependsOn("syncComposeResourcesForIos")
}

dependencies {
    implementation(project(":adaptive"))

    implementation(libs.bundles.ui.common.api)
    implementation(libs.bundles.ui.android.api)
    implementation(libs.bundles.infra.api)

    implementation(libs.androidx.core.splashscreen)
}
