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
    namespace = getPropertyValue("NAME_SPACE")
}

dependencies {
    implementation(libs.androidx.ktxCore)
}