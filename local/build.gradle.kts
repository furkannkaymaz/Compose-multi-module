plugins {
    id(Plugins.library)
    id(Plugins.kotlin)
    id(Plugins.hilt)
    kotlin(Plugins.kapt)
    id(Plugins.ksp)
}

android {
    namespace = "${Config.applicationId}.local"
    compileSdk = Config.compileSdkVersion

}

dependencies {

    implementation(project(Modules.domain))

    implementation(Libs.AndroidX.core)
    implementation(Libs.AndroidX.datastore)

    implementation(Libs.Hilt.hilt)
    kapt(Libs.Hilt.hiltKapt)

    implementation(Libs.Room.room)
    implementation(Libs.Room.roomKtx)
    ksp(Libs.Room.roomCompiler)

    implementation(Libs.Hilt.hilt)
    kapt(Libs.Hilt.hiltKapt)

}