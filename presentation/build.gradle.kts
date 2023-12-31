plugins {
    id(Plugins.kotlin)
    id(Plugins.hilt)
    id(Plugins.library)
    kotlin(Plugins.kapt)
}

android {
    namespace = "${Config.applicationId}.presentation"


    buildFeatures {
        compose = true
    }


    composeOptions {
        kotlinCompilerExtensionVersion = Versions.Others.kotlinCompilerExtensionVersion
    }

}

dependencies {

    implementation(project(Modules.domain))
    implementation(project(Modules.utils))
    implementation(project(Modules.core))

    //Androidx
    implementation(Libs.AndroidX.activityCompose)
    implementation(Libs.AndroidX.lifecycle)
    implementation(Libs.AndroidX.composeLifecycle)
    implementation(Libs.AndroidX.core)
    implementation(Libs.AndroidX.pagination)
    implementation(Libs.AndroidX.composeMateriel)

    //Compose
    implementation(platform(Libs.Compose.composeBom))
    implementation(Libs.Compose.composeUI)
    implementation(Libs.Compose.composeUIGraphics)
    implementation(Libs.Compose.composeUIPreview)
    implementation(Libs.Compose.composeMaterial)
    implementation(Libs.Compose.composeNavigation)
    implementation(Libs.Compose.composeViewModel)
    implementation(Libs.Compose.composeLottie)
    implementation(Libs.Compose.composeHilt)
    implementation(Libs.Compose.composePagination)

    //Test
    testImplementation(Libs.Test.mockK)
    testImplementation(Libs.Test.mockitoKotlin)
    testImplementation(Libs.Test.JUnit)
    testImplementation(Libs.Test.mockitoCore)
    testImplementation(Libs.Test.coroutine)
    testImplementation(Libs.Test.mockitoInline)

    implementation(Libs.AndroidX.datastore)

    //Glide
    implementation(Libs.Glide.glideLandscapist)

    //Dagger
    implementation(Libs.Hilt.hilt)
    kapt(Libs.Hilt.hiltKapt)
}