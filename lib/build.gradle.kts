plugins {
    alias(libs.plugins.jvm)
    `java-library`
    id("maven-publish")
    id("org.jetbrains.dokka") version "1.9.20"
}

repositories {
    mavenLocal()
    mavenCentral()
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "de.quartettmobile"
            artifactId = "xtea-kt"
            version = "1.0"

            from(components["java"])

            pom.withXml {
                val root = asNode()
                root.appendNode("name", project.name)
                root.appendNode("description", "XTEA Kotlin implementation")
                root.appendNode("url", "https://github.com/Quartettmobile/xtea-kt")
                root.appendNode("licenses").apply {
                    appendNode("license").apply {
                        appendNode("name", "MIT License")
                        appendNode("url", "https://opensource.org/license/mit")
                    }
                }
                root.appendNode("developers").apply {
                    appendNode("developer").apply {
                        appendNode("id", "Quartett mobile GmbH")
                        appendNode("name", "Quartett mobile")
                        appendNode("organization", "Quartett mobile")
                        appendNode("organizationUrl", "https://quartett-mobile.de")
                    }
                }
                root.appendNode("scm").apply {
                    appendNode("url", "https://github.com/Quartettmobile/xtea-kt.git")
                }
            }
        }
    }
}

dependencies {
    // Use the Kotlin JUnit 5 integration.
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
}

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(11))
    }
    withSourcesJar()
    withJavadocJar()
}

tasks.register<Jar>("dokkaHtmlJar") {
    dependsOn(tasks.dokkaHtml)
    from(tasks.dokkaHtml.flatMap { it.outputDirectory })
    archiveClassifier.set("html-docs")
}

tasks.register<Jar>("dokkaJavadocJar") {
    dependsOn(tasks.dokkaJavadoc)
    from(tasks.dokkaJavadoc.flatMap { it.outputDirectory })
    archiveClassifier.set("javadoc")
}

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}
