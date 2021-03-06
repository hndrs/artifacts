import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.4.3"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id("org.sonarqube").version("3.1.1")
    kotlin("jvm") version "1.4.30"
    kotlin("plugin.spring") version "1.4.30"
    jacoco
}

group = "io.hndrs"
version = "0.0.1"
java.sourceCompatibility = JavaVersion.VERSION_15

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    //hndrs
    implementation("io.hndrs:jsonapi-spring-boot-starter:1.0.0")


    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

sonarqube {
    properties {
        property("sonar.projectKey", "hndrs_artifacts")
        property("sonar.organization", "hndrs")
        property("sonar.host.url", "https://sonarcloud.io")
    }
}

jacoco {
    toolVersion = "0.8.6"
}

tasks.withType<JacocoReport> {
    reports {
        xml.apply {
            isEnabled = true
        }
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "15"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
