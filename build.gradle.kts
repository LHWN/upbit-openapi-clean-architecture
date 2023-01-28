plugins {
    id("java")
    id("io.spring.dependency-management") version "1.0.11.RELEASE" apply false
    id("org.springframework.boot") version "2.7.3" apply false
    id("io.freefair.lombok") version "6.4.1" apply false

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

project(":libs:adapter-http") { // ... (3)
    apply(plugin = "org.gradle.java")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "io.freefair.lombok")
    apply(plugin = "org.jetbrains.kotlin.jvm")

    the<io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension>().apply {
        imports {
            mavenBom("org.springframework.boot:spring-boot-dependencies:2.7.3")
            mavenBom("org.jetbrains.kotlin:kotlin-bom:1.6.21")
            mavenBom("org.jetbrains.kotlinx:kotlinx-serialization-bom:1.4.1")
        }

        dependencies {
            dependency("org.apache.commons:commons-lang3:3.12.0")
            dependency("org.apache.commons:commons-collections4:4.4")
            dependency("commons-io:commons-io:2.11.0")
        }
    }

    dependencies {
        val implementation by configurations

        implementation("org.springframework.boot:spring-boot-starter-web")
        annotationProcessor ("org.projectlombok:lombok")

        /*annotationProcessor 는 자바 컴파일러의 플러그인 중 하나입니다. 우리가 설치한 Dependency 를 통해 Annotation 을 사용하는 경우 해당 Annotation 에 대한 코드베이스를 검사하고, 수정, 생성하죠.
        즉, 자바 컴파일러가 Lombok 의 annotation 을 인식하고 동작을 수행할 수 있도록 정의해 주어야 하는 것이죠.*/
    }
}