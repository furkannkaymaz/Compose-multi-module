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

}
dependencies {

    implementation(project(Modules.utils))
    implementation(Libs.Hilt.hilt)
    kapt(Libs.Hilt.hiltKapt)
}