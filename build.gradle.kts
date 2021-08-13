import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    id("org.sonarqube").version("3.3")
    kotlin("jvm")
    kotlin("plugin.spring")
    kotlin("kapt")
    jacoco
}

group = "io.hndrs"
version = "0.0.1"
java.sourceCompatibility = JavaVersion.VERSION_15

repositories {
    mavenCentral()
}

dependencyManagement {
    imports {
        mavenBom("com.squareup.okhttp3:okhttp-bom:4.9.0")
    }
}


dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    implementation("com.auth0:auth0:1.33.0")
    implementation("io.springfox:springfox-boot-starter:3.0.0")
    //hndrs
    implementation("io.hndrs:jsonapi-spring-boot-starter:1.0.0")
    implementation("io.hndrs:jwt-auth-spring-boot-starter:1.0.0")

    kapt(group = "org.springframework.boot", name = "spring-boot-configuration-processor")

    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(module = "mockito-core")
    }
    testImplementation("com.ninja-squad:springmockk:3.0.1")
}

sonarqube {
    properties {
        property("sonar.projectKey", "hndrs_artifacts")
        property("sonar.organization", "hndrs")
        property("sonar.host.url", "https://sonarcloud.io")
    }
}

jacoco {
    toolVersion = "0.8.7"
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
    System.getProperty("spring.profiles.active")?.let {
        systemProperties.put("spring.profiles.active", it)
    }
}
