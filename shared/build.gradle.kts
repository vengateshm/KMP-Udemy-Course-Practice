plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.touchlabSkie)
    kotlin("plugin.serialization") version "1.9.23"
    alias(libs.plugins.sqlDelight)
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            //put your multiplatform dependencies here
            implementation(libs.kotlinx.coroutines.core)

            //Ktor
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.serialization.kotlinx.json)

            implementation(libs.kotlinx.datetime)

            //Koin
            implementation(libs.koin.core)

            //SqlDelight
//            implementation(libs.sql.coroutine.extensions)

            //Datastore preferences
            //implementation(libs.androidx.datastore.preferences)
            implementation(libs.androidx.datastore.preferences.core)
        }

        androidMain.dependencies {
            implementation(libs.androidx.lifecycle.viewmodel.ktx) // used in same module
            // api() - used by other modules
            //Ktor
            implementation(libs.ktor.client.android)

            //SqlDelight
            implementation(libs.sql.android.driver)

            //Datastore preferences
            implementation(libs.androidx.datastore.preferences.core)
        }

        iosMain.dependencies {
            //Ktor
            implementation(libs.ktor.client.darwin)

            implementation("co.touchlab:stately-common:2.0.6")
            //SqlDelight
            implementation(libs.sql.native.driver)
        }

        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

android {
    namespace = "dev.vengateshm.kmpudemycourseapp"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

sqldelight {
    databases {
        create("NewsAppDatabase") {
            packageName.set("dev.vengateshm.newsapp.db")
        }
    }
}