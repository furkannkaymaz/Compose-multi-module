
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
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        targetCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
        kotlinOptions {
            jvmTarget = "11"
        }
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion =  Versions.Others.kotlinCompilerExtensionVersion
    }

    packagingOptions {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}

dependencies {

    //Project
    implementation(project(Modules.data))
    implementation(project(Modules.presentation))

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