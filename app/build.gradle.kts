
plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        applicationId = "com.imnstudios.koo"
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
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
        kotlinCompilerExtensionVersion = Versions.compose
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(Dependencies.Accompanist.navigationAnimation)
    implementation(Dependencies.Accompanist.systemUIController)
    implementation(Dependencies.Accompanist.pager)
    implementation(Dependencies.Accompanist.pagerIndicator)
    implementation(platform(Dependencies.Networking.okHttpBOM))
    implementation(Dependencies.Networking.okHttp)
    implementation(Dependencies.Networking.okHttpLoggingInterceptor)
    implementation(Dependencies.Networking.retrofit)
    implementation(Dependencies.kotlin)
    implementation(Dependencies.compose)
    implementation(Dependencies.composeFoundation)
    implementation(Dependencies.material)
    implementation(Dependencies.composePreview)
    implementation(Dependencies.androidXLifecycle)
    implementation(Dependencies.activityCompose)
    testImplementation(Dependencies.jUnit)
    testImplementation(Dependencies.jUnitTest)
    androidTestImplementation(Dependencies.espressoAndroidTest)
    androidTestImplementation(Dependencies.composeJUnitAndroidTest)
    debugImplementation(Dependencies.composeTooling)
    debugImplementation(Dependencies.Accompanist.flowRow)

    implementation(Dependencies.DaggerHilt.daggerHilt)
    kapt(Dependencies.DaggerHilt.daggerHiltKapt)
//    implementation(Dependencies.DaggerHilt.daggerHilViewModel)
//    implementation(Dependencies.DaggerHilt.daggerHiltNavigationCompose)


    implementation("androidx.hilt:hilt-navigation-compose:1.0.0-alpha02")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    implementation("io.coil-kt:coil-compose:2.0.0-rc03")

}

kapt {
    correctErrorTypes = true
}