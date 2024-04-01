plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // Selenide dependency for tests
    implementation("com.codeborne:selenide:7.2.3")

    // TestNG dependency for testing framework
    implementation(group = "org.testng", name = "testng", version = "6.14.3")

}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}