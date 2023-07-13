plugins {
    id(Plugins.library)
    id(Plugins.kotlin)
    kotlin(Plugins.kapt)
    id(Plugins.ksp)
}

android {
    namespace = "${Config.applicationId}.utils"

}

dependencies {

    api(Libs.Network.gsonConverter)
    implementation(Libs.AndroidX.lifecycle)

}