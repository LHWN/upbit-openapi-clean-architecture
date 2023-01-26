plugins {
    id("java")
    id("io.spring.dependency-management") version "1.0.11.RELEASE" apply false
    id("org.springframework.boot") version "2.7.3" apply false

    kotlin("jvm") version "1.6.21" apply false
    kotlin("kapt") version "1.6.21" apply false
    kotlin("plugin.spring") version "1.6.21" apply false
}

// 프로젝트 내 전체 모듈에 적용
allprojects {
    group = "sample.project.lhwn"
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
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "org.jetbrains.kotlin.kapt")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "org.jetbrains.kotlin.plugin.spring")
}

// apps:app-api 에서도 lib:application 을 참조할 수 있다.
//project(":apps:app-api") {
//    dependencies {
//        project(":lib:application")
//    }
//}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}