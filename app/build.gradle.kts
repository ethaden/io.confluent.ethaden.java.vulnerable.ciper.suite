/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Java application project to get you started.
 * For more details on building Java & JVM projects, please refer to https://docs.gradle.org/8.5/userguide/building_java_projects.html in the Gradle documentation.
 */

plugins {
    // Apply the application plugin to add support for building a CLI application in Java.
    application
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    // Use JUnit Jupiter for testing.
    testImplementation(libs.junit.jupiter)

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    // This dependency is used by the application.
    implementation(libs.guava)
    //implementation("org.apache.httpcomponents:httpclient:4.5")
    implementation("org.apache.httpcomponents.client5:httpclient5:5.3")
    implementation("com.googlecode.json-simple:json-simple:1.1.1")
}

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(8))
    }
}

application {
    // Define the main class for the application.
    mainClass.set("io.confluent.ethaden.java.vulnerable.ciper.suite.App")
    //applicationDefaultJvmArgs = listOf("-Djdk.tls.ephemeralDHKeySize=1024", "-Djsse.enableFFDHE=true", "-Djdk.tls.namedGroups=ffdhe4096")
    //applicationDefaultJvmArgs = listOf("-Djdk.tls.ephemeralDHKeySize=4096", "-Djsse.enableFFDHE=false")
    applicationDefaultJvmArgs = listOf("-Djdk.tls.ephemeralDHKeySize=1024", "-Djsse.enableFFDHE=true")
}

tasks.jar {
    manifest.attributes["Main-Class"] = "io.confluent.ethaden.java.vulnerable.ciper.suite.App"
    val dependencies = configurations
        .runtimeClasspath
        .get()
        .map(::zipTree) // OR .map { zipTree(it) }
    from(dependencies)
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}
