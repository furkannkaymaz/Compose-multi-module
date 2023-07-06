plugins {
    id(Plugins.library)
    id(Plugins.kotlin)
    id(Plugins.hilt)
    kotlin(Plugins.kapt)
    id(Plugins.ksp)
}

android {
    namespace = "${Config.applicationId}.core"
    compileSdk = Config.compileSdkVersion

}

dependencies {

    implementation(Libs.Hilt.hilt)
    kapt(Libs.Hilt.hiltKapt)

}