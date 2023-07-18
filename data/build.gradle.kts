plugins {
    id(Plugins.library)
    id(Plugins.kotlin)
    id(Plugins.hilt)
    kotlin(Plugins.kapt)
    id(Plugins.ksp)
}

android {

    namespace = "${Config.applicationId}.data"

}

dependencies {

    implementation(project(Modules.domain))
    implementation(project(Modules.network))
    implementation(project(Modules.core))
    implementation(project(Modules.utils))
    implementation(project(Modules.local))

    implementation(Libs.AndroidX.core)

    implementation(Libs.Hilt.hilt)
    kapt(Libs.Hilt.hiltKapt)


}