import flavors.CountryFlavor
import buildtypes.BuildTypes
import flavors.MarketFlavor

plugins {
    alias(libs.plugins.space.android.library)
}

buildConfig {
    flavors = setOf(MarketFlavor(), CountryFlavor())
    buildTypes = setOf(BuildTypes.DEBUG, BuildTypes.TEST, BuildTypes.PRODUCTION)
}

android {
    namespace = project.findProperty("Name_Space").toString()
}

dependencies {
    implementation(libs.androidx.ktxCore)
}