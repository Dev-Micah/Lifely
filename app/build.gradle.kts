plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)

    id("com.google.devtools.ksp")
    id("org.jetbrains.kotlin.plugin.serialization") version "2.1.20"
}

android {
    namespace = "com.micahnyabuto.lifely"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.micahnyabuto.lifely"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

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

    implementation("androidx.compose.material:material-icons-extended:1.7.8")

    //App compat
    implementation ("androidx.appcompat:appcompat:1.7.1")

    //Navigation
    implementation("androidx.navigation:navigation-compose:2.9.0")

    //coil
    implementation("io.coil-kt:coil-compose:2.4.0")


    //Serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.3")

    //Room
    implementation("androidx.room:room-runtime:2.7.1")
    implementation("androidx.room:room-ktx:2.5.7")
    ksp("androidx.room:room-compiler:2.7.1")

    //Koin
    implementation(libs.koin.core)
    implementation(libs.koin.android)
    implementation(libs.koin.androidx.compose)
    testImplementation(libs.koin.test)
}