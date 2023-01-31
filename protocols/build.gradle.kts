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

    implementation("org.junit.platform:junit-platform-commons:1.8.1")
    implementation("com.google.code.gson:gson:2.10.1")
    implementation("org.projectlombok:lombok")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.assertj:assertj-core:3.11.1")
}