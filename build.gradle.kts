// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://maven-other.tuya.com/repository/maven-releases/") }
        maven {
            url = uri("https://maven-other.tuya.com/repository/maven-commercial-releases/")
            mavenContent {
                releasesOnly()
            }
        }
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.5.0")
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
}