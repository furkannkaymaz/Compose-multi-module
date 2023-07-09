plugins {
    id(Plugins.library)
    id(Plugins.kotlin)
    id(Plugins.hilt)
    id(Plugins.parcelize)
    kotlin(Plugins.kapt)
}

android {
    namespace = "${Config.applicationId}.domain"
    compileSdk = Config.compileSdkVersion

    defaultConfig {
        minSdk = Config.minSdkVersion

    }
}
dependencies {

    implementation(project(Modules.utils))
    implementation(Libs.Hilt.hilt)
    implementation(Libs.AndroidX.datastore)
    kapt(Libs.Hilt.hiltKapt)
}