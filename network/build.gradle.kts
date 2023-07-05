plugins {
    id(Plugins.library)
    id(Plugins.kotlin)
    id(Plugins.hilt)
    kotlin(Plugins.kapt)
}

android {
    namespace = "${Config.applicationId}.network"
    compileSdk = Config.compileSdkVersion

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
        kotlinOptions {
            jvmTarget = "11"
        }
    }
}

dependencies {

    //Androidx
    api(Libs.AndroidX.workManager)
    api(Libs.AndroidX.workManagerHilt)

    //Network
    api(Libs.Network.retrofit)
    api(Libs.Network.okhttp)
    api(Libs.Network.gsonConverter)
    api(Libs.Network.loggingInterceptor)
    api(Libs.Network.gson)

    //Hilt
    implementation(Libs.Hilt.hilt)
    kapt(Libs.Hilt.hiltKapt)

    //Chucker
    debugImplementation(Libs.Chucker.chucker)
    releaseImplementation(Libs.Chucker.chuckerNoOp)
}