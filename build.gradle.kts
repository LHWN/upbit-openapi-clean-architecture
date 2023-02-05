plugins {
    id("io.spring.dependency-management") version "1.0.11.RELEASE" apply false // ... (1)
    id("org.springframework.boot") version "2.7.3" apply false
    id("io.freefair.lombok") version "6.4.1" apply false // ... (2)
    id("org.jetbrains.kotlin.kapt") version "1.8.10"  apply false

    kotlin("jvm") version "1.6.21" apply false
    kotlin("plugin.spring") version "1.6.21" apply false
}

// 프로젝트 내 전체 모듈에 적용
allprojects {
    group = "upbit.project.openapi"
    version = "1.0-SNAPSHOT"

    repositories {
        mavenCentral()
        maven {
            url = uri("https://maven.restlet.com")
        }
        maven {
            url = uri("https://jitpack.io")
        }
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = "17"
        kotlinOptions.freeCompilerArgs = listOf(
            "-Xjsr305=strict",
            "-Xjvm-default=all",
        )
    }
}

subprojects {
    apply(plugin = "idea")
}
