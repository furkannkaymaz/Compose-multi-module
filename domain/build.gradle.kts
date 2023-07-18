plugins {
    id(Plugins.library)
    id(Plugins.kotlin)
    id(Plugins.hilt)
    id(Plugins.parcelize)
    kotlin(Plugins.kapt)
}

android {

    namespace = "${Config.applicationId}.domain"

}
dependencies {

    implementation(project(Modules.utils))
    implementation(project(Modules.core))
    implementation(Libs.Hilt.hilt)
    implementation(Libs.AndroidX.datastore)
    kapt(Libs.Hilt.hiltKapt)
}