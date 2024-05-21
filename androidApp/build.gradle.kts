plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
}

android {
    namespace = "dev.vengateshm.kmpudemycourseapp.android"
    compileSdk = 34
    defaultConfig {
        applicationId = "dev.vengateshm.kmpudemycourseapp.android"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
            excludes += "/META-INF/**/*"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(projects.shared)
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.compose.material3)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.coil.compose)
    debugImplementation(libs.compose.ui.tooling)

    //Datastore preferences
    implementation(libs.androidx.datastore.preferences.core)

    implementation(libs.accompanist.swiperefresh)

    implementation(libs.koin.androidx.compose)
    implementation(libs.koin.android)

    //Room
    implementation(libs.room.runtime)
    implementation(libs.room.runtime.android)
}