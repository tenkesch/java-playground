plugins {
    id("java")
}

group = "com.student.app"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform("org.junit:junit-bom:6.0.0"))
    implementation("org.junit.jupiter:junit-jupiter")
    implementation("org.jspecify:jspecify:1.0.1")
    runtimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}