plugins {
    id(Plugins.application) version Versions.Plugin.application apply false
    id(Plugins.library) version Versions.Plugin.application apply false
    id(Plugins.kotlin) version Versions.Plugin.kotlin apply false
    id(Plugins.hiltClasspath) version Versions.hilt apply false
    id(Plugins.ksp) version Versions.Plugin.ksp apply false
}

allprojects {
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
}