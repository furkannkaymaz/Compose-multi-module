import com.android.build.gradle.AppExtension
import com.android.build.gradle.AppPlugin
import com.android.build.gradle.BaseExtension
import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.LibraryPlugin

plugins {
    id(Plugins.application) version Versions.Plugin.application apply false
    id(Plugins.library) version Versions.Plugin.application apply false
    id(Plugins.kotlin) version Versions.Plugin.kotlin apply false
    id(Plugins.hiltClasspath) version Versions.hilt apply false
    id(Plugins.ksp) version Versions.Plugin.ksp apply false
}

allprojects{
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
}

subprojects {
    project.plugins.applyBaseConfig(project)
}

fun BaseExtension.baseConfig() {
    setCompileSdkVersion(Config.compileSdkVersion)

    defaultConfig.apply {
        minSdk = Config.minSdkVersion
        targetSdk = Config.targetSdkVersion

    }

    composeOptions {
        kotlinCompilerExtensionVersion =  Versions.Others.kotlinCompilerExtensionVersion
    }

}

fun PluginContainer.applyBaseConfig(project: Project) {
    whenPluginAdded {
        when (this) {
            is AppPlugin -> {
                project.extensions
                    .getByType<AppExtension>()
                    .apply {
                        baseConfig()
                    }
            }

            is LibraryPlugin -> {
                project.extensions
                    .getByType<LibraryExtension>()
                    .apply {
                        baseConfig()
                    }
            }
        }
    }
}

