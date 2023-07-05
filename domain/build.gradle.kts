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

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
        kotlinOptions {
            jvmTarget = "11"
        }
    }
}
dependencies {

    implementation(Libs.Hilt.hilt)
    kapt(Libs.Hilt.hiltKapt)
}