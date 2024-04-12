// 1
buildscript {
    // 2
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    // 3
    dependencies {
        classpath(libs.kotlin.gradle.plugin)
        classpath(libs.gradle)
    }
}
plugins {
    //trick: for the same plugin versions in all sub-modules
    alias(libs.plugins.androidApplication).apply(false)
    alias(libs.plugins.androidLibrary).apply(false)
    alias(libs.plugins.kotlinAndroid).apply(false)
    alias(libs.plugins.kotlinMultiplatform).apply(false)
    alias(libs.plugins.kotlinCocoapods).apply(false)
}
tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

