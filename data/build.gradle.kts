plugins {
    id(Plugins.library)
    id(Plugins.kotlin)
    id(Plugins.hilt)
    kotlin(Plugins.kapt)
    id(Plugins.ksp)
}

android {
    namespace = "${Config.applicationId}.data"
    compileSdk = Config.compileSdkVersion

}

dependencies {

    implementation(project(Modules.domain))
    implementation(project(Modules.network))
    implementation(project(Modules.core))

    implementation(Libs.AndroidX.core)
    implementation(Libs.AndroidX.datastore)

    implementation(Libs.Hilt.hilt)
    kapt(Libs.Hilt.hiltKapt)

    implementation(Libs.Room.room)
    implementation(Libs.Room.roomKtx)
    ksp(Libs.Room.roomCompiler)

}