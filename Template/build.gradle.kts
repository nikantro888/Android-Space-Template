import flavors.CountryFlavor
import buildtypes.BuildTypes

plugins {
    alias(libs.plugins.space.android.library)
}

buildConfig {
    flavors = setOf(CountryFlavor())
    buildTypes = setOf(BuildTypes.DEBUG, BuildTypes.TEST, BuildTypes.PRODUCTION)
}

android {
    namespace = "com.space.template"
}

dependencies {
    implementation(libs.androidx.ktxCore)
}