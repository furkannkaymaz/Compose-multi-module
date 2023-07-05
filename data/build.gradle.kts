plugins {
    id(Plugins.kotlin)
    id(Plugins.library)
    kotlin(Plugins.kapt)
}

android {
    namespace = "com.furkan.multi_module.data"
    compileSdk = Config.compileSdkVersion
}

dependencies {

}