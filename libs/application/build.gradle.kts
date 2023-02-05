apply(plugin = "org.gradle.java")
apply(plugin = "io.spring.dependency-management")
apply(plugin = "io.freefair.lombok")
apply(plugin = "org.jetbrains.kotlin.jvm")
apply(plugin = "org.jetbrains.kotlin.kapt")

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
        dependency("org.jetbrains:kotlin.kapt:1.8.10")
    }
}

dependencies {
    val implementation by configurations
    val kapt by configurations

    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    implementation("org.projectlombok:lombok")
    implementation("org.mapstruct:mapstruct:1.5.2.Final")
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")

    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("com.querydsl:querydsl-jpa:5.0.0")
    implementation("com.querydsl:querydsl-apt:5.0.0")

    kapt("javax.persistence:javax.persistence-api")
    kapt("javax.annotation:javax.annotation-api")
    kapt("com.querydsl:querydsl-apt:5.0.0:jpa")
}