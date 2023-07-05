// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(Plugins.application) version Versions.Plugin.application apply false
    id(Plugins.library) version Versions.Plugin.application apply false
    id(Plugins.kotlin) version Versions.Plugin.kotlin apply false
    id(Plugins.hiltClasspath) version Versions.hilt apply false
    id(Plugins.ksp) version Versions.Plugin.ksp apply false

}