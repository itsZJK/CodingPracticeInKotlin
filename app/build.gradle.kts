import itsz.setupAppModule

plugins {
  id("com.android.application")
  id("org.jetbrains.kotlin.android")
}

setupAppModule {
  defaultConfig {
    applicationId = "kotlin.practice.sample"
  }
  buildTypes {
    release {
      isMinifyEnabled = true
      isShrinkResources = true
      proguardFiles("proguard-rules.pro")
      signingConfig = signingConfigs["debug"]
    }
  }
}

dependencies {
  implementation(libs.bundles.android.ktx)
  implementation(libs.coroutines.android)
  implementation(libs.appcompat)
  implementation(libs.bundles.mdc.ui)
  testImplementation(libs.junit)
  androidTestImplementation(libs.androidx.test.junit)
}
