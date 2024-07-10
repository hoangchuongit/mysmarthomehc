@file:Suppress("DEPRECATION")

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

apply(from = "thingMapping.gradle")

android {
    namespace = "com.example.mysmarthomehc"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.mysmarthomehc"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    signingConfigs {
        create("release") {
            storeFile = file("./smarthomehcrelease.keystore")
            storePassword = "Success1102"
            keyAlias = "smarthomehc"
            keyPassword = "Success1102"
            isV1SigningEnabled = true
            isV2SigningEnabled = true
        }
    }

    buildTypes {
        debug {
            signingConfig = signingConfigs.getByName("debug")
        }
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("release")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            pickFirst("lib/*/libc++_shared.so")
            pickFirst("lib/*/libyuv.so")
            pickFirst("lib/*/libopenh264.so")
            pickFirst("lib/*/liblog.so")
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

configurations.all {
    exclude(group = "com.thingclips.smart", module = "thingsmart-modularCampAnno")
}

dependencies {

    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.aar"))))
    implementation("com.alibaba:fastjson:1.1.67.android")
    implementation("com.squareup.okhttp3:okhttp-urlconnection:3.14.9")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation ("com.google.android.material:material:1.3.0-alpha04")

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // The latest stable App SDK for Android.
    implementation("com.facebook.soloader:soloader:0.10.4+")
    implementation("com.thingclips.smart:thingsmart:5.14.0")
    implementation("com.thingclips.smart:thingsmart-commonbiz-family:4.8.0-rc.3")
    implementation("com.thingclips.smart:thingsmart-login-plug-api:5.0.0")
}