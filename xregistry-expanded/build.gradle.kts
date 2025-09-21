plugins {
    base
    id("com.metaformsystems.xregistry-oci-packaging") version "1.0"
}

repositories {
    mavenCentral()
    mavenLocal()
}


// Configure the plugin extension to change the source directory
//configure<com.metaformsystems.fleet.xregistry.oci.XRegistryOciPackagingExtension> {
//    xRegistrySourceDir.set("artifacts")
//}

project.defaultTasks("buildXRegistryOci")