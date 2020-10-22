import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "com.company"
version = "1.0-SNAPSHOT"
buildscript {
    repositories {
        maven {  setUrl ("https://maven.aliyun.com/repository/central") }
        maven {  setUrl ( "https://maven.aliyun.com/repository/gradle-plugin") }
    }

}
plugins {
    java
    kotlin("jvm") version "1.4.10"
}
repositories {
    maven { setUrl ( "https://maven.aliyun.com/repository/central") }
}
dependencies {
    testImplementation("junit:junit:4.12")
    implementation(kotlin("stdlib-jdk8","1.4.10"))
    implementation(kotlin("test"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.9")
}

tasks.test {
    useJUnit()
    maxHeapSize = "1G"
}
val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
}