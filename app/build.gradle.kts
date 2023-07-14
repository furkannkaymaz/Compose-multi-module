plugins {
    id(Plugins.application)
    id(Plugins.kotlin)
    id(Plugins.hilt)
    id(Plugins.parcelize)
    kotlin(Plugins.kapt)
}

android {
    namespace = Config.applicationId
    compileSdk = Config.compileSdkVersion

    defaultConfig {
        applicationId = Config.applicationId
        minSdk = Config.minSdkVersion
        targetSdk = Config.targetSdkVersion
        versionCode = Config.versionCode
        versionName = Config.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables.useSupportLibrary = true
    }

    buildTypes {
        debug {
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            isMinifyEnabled = Config.minifyEnabledDebug
            isDebuggable = true
        }
        release {
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            isMinifyEnabled = Config.minifyEnabledRelease
            isShrinkResources = true
            isDebuggable = false
        }
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion =  Versions.Others.kotlinCompilerExtensionVersion
    }

    packaging {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}

dependencies {

    //Project
    implementation(project(Modules.data))
    implementation(project(Modules.presentation))
    implementation(project(Modules.core))
    implementation(project(Modules.domain))
    implementation(project(Modules.network))
    implementation(project(Modules.local))
    implementation(project(Modules.utils))

    //Androidx
    implementation(Libs.AndroidX.activityCompose)
    implementation(Libs.AndroidX.lifecycle)
    implementation(Libs.AndroidX.core)
    implementation(Libs.AndroidX.splashScreen)

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

    //Dagger
    implementation(Libs.Hilt.hilt)
    kapt(Libs.Hilt.hiltKapt)
}