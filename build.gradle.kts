plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("com.codeborne:selenide:7.2.3")
    implementation("org.testng:testng:7.1.0")
    implementation("org.seleniumhq.selenium:selenium-java:3.141.59")

}

tasks.getByName<Test>("test") {
    useTestNG()
}