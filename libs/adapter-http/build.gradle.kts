apply(plugin = "org.jetbrains.kotlin.jvm")
apply(plugin = "org.jetbrains.kotlin.kapt")
apply(plugin = "org.jetbrains.kotlin.plugin.spring")
apply(plugin = "org.springframework.boot")

dependencies {
    implementation(project(":libs:application"))
    implementation(project(":protocols"))

    implementation("com.google.code.gson:gson:2.10.1")
    implementation("org.projectlombok:lombok")
    implementation("org.mapstruct:mapstruct:1.3.1.Final")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.assertj:assertj-core:3.11.1")
    annotationProcessor("org.projectlombok:lombok")
}