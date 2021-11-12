val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project

plugins {
    // application
    kotlin("jvm") version "1.5.31"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.5.31"
    war
    id("org.gretty") version "3.0.6"
}

group = "com.joko"
version = "0.0.1"
//application {
//    mainClass.set("com.joko.ApplicationKt")
//}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core:$ktor_version")
    implementation("io.ktor:ktor-serialization:$ktor_version")
    implementation("io.ktor:ktor-server-tomcat:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    testImplementation("io.ktor:ktor-server-tests:$ktor_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")

    implementation("io.ktor:ktor-server-servlet:$ktor_version")
}

gretty {
    servletContainer = "tomcat9"
    contextPath = '/'
    logbackConfigFile = "src/main/resources/logback.xml"
}

tasks {
    withType<JavaCompile>().configureEach {
        options.encoding = "UTF-8"
    }

    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }

    register("run") {
        dependsOn("appengineRun")
    }
}