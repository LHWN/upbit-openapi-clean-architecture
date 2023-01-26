apply(plugin = "org.jetbrains.kotlin.jvm")
apply(plugin = "org.jetbrains.kotlin.kapt")
apply(plugin = "org.jetbrains.kotlin.plugin.spring")
apply(plugin = "org.springframework.boot")

dependencies {
    implementation("org.junit.platform:junit-platform-commons:1.8.1")
    implementation("com.google.code.gson:gson:2.10.1")
    implementation("org.projectlombok:lombok")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.assertj:assertj-core:3.11.1")
}