/*
*  Copyright (c) 2025 Metaform Systems, Inc.
*
*  This program and the accompanying materials are made available under the
*  terms of the Apache License, Version 2.0 which is available at
*  https://www.apache.org/licenses/LICENSE-2.0
*
*  SPDX-License-Identifier: Apache-2.0
*
*  Contributors:
*       Metaform Systems, Inc. - initial API and implementation
*
*/

import com.metaformsystems.fleet.xregistry.oci.publisher.XRegistryOciPublisherExtension
import java.time.Instant

plugins {
    base
    id("com.metaformsystems.xregistry-oci-publisher") version "1.0"
}

repositories {
    mavenCentral()
    mavenLocal()
}

configure<XRegistryOciPublisherExtension> {
    xRegistrySourceDir.set("src/main/xregistry")

    ociArtifactName.set("ghcr.io/metaform/xr-sample")
    ociArtifactTag.set("1.0")

    // Registry authentication
    ociRegistryUsername.set(
        System.getenv("OCI_REGISTRY_USERNAME")
            ?: throw GradleException("OCI_REGISTRY_USERNAME environment variable is required")
    )
    ociRegistryPassword.set(
        System.getenv("OCI_REGISTRY_PASSWORD")
            ?: throw GradleException("OCI_REGISTRY_PASSWORD environment variable is required")
    )

    // Custom manifest annotations
    manifestAnnotations.set(
        mapOf(
            "org.opencontainers.image.title" to "xRegistry Policy Bundle",
            "org.opencontainers.image.description" to "Fleet management policies",
            "org.opencontainers.image.version" to project.version.toString(),
            "org.opencontainers.image.created" to Instant.now().toString(),
            "org.opencontainers.image.authors" to "ACME, Inc."
        )
    )
}


project.defaultTasks("buildXRegistryOci")