plugins {
    base
    id("com.metaformsystems.xregistry-oci-packaging") version "1.0"
}

repositories {
    mavenCentral()
    mavenLocal()
}


project.defaultTasks("buildXRegistryOci")