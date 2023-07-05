plugins {
    id(Plugins.kotlin)
    id(Plugins.hilt)
    id(Plugins.library)
    kotlin(Plugins.kapt)
}

android {
    namespace = "com.furkan.multi_module.presentation"
    compileSdk = Config.compileSdkVersion


    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion =  Versions.Others.kotlinCompilerExtensionVersion
    }

}

dependencies {

    //Androidx
    implementation(Libs.AndroidX.activityCompose)
    implementation(Libs.AndroidX.lifecycle)
    implementation(Libs.AndroidX.core)
    implementation(Libs.AndroidX.pagination)

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

    //Glide
    implementation(Libs.Glide.glideLandscapist)

    //Dagger
    implementation(Libs.Hilt.hilt)
    kapt(Libs.Hilt.hiltKapt)
}