
rootProject.name = "xr-sample"
include("xregistry-compact")
include("xregistry-expanded")

pluginManagement {
    repositories {
        mavenLocal()  // Add this to use locally published plugins
        gradlePluginPortal()
        mavenCentral()
    }
}
