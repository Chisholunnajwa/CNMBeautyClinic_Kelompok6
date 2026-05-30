plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose)
<<<<<<< HEAD

    id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
}

android {

    namespace = "com.example.cnmbeautyclinickelompok_6"

=======
}

android {
    namespace = "com.example.cnmbeautyclinic"
>>>>>>> 216e546163397d823304350b9743247f90c3e34e
    compileSdk {
        version = release(36) {
            minorApiLevel = 1
        }
    }

    defaultConfig {
<<<<<<< HEAD

        applicationId =
            "com.example.cnmbeautyclinickelompok_6"

        minSdk = 24
        targetSdk = 36

        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner =
            "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {

        release {

            isMinifyEnabled = false

            proguardFiles(
                getDefaultProguardFile(
                    "proguard-android-optimize.txt"
                ),
=======
        applicationId = "com.example.cnmbeautyclinic"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
>>>>>>> 216e546163397d823304350b9743247f90c3e34e
                "proguard-rules.pro"
            )
        }
    }
<<<<<<< HEAD

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }


=======
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
>>>>>>> 216e546163397d823304350b9743247f90c3e34e
    buildFeatures {
        compose = true
    }
}

<<<<<<< HEAD
//kotlin {
//    jvmToolchain(17)
//}



=======
>>>>>>> 216e546163397d823304350b9743247f90c3e34e
dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.7")
<<<<<<< HEAD
    implementation("com.google.dagger:hilt-android:2.59.2")
    ksp("com.google.dagger:hilt-compiler:2.59.2")

=======
>>>>>>> 216e546163397d823304350b9743247f90c3e34e
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
}