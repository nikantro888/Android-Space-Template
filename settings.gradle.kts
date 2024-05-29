apply(from = file("$rootDir/git-utils.gradle.kts"))

pluginManagement {

    includeBuild("build-logic")

    repositories {
        mavenCentral()
        google()
        gradlePluginPortal()
        maven { url = uri("https://plugins.gradle.org/m2/") }
    }
}


dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)

    repositories {
        mavenCentral()
        google()
    }

    versionCatalogs {
        create("libs") {
            from(files("build-logic/gradle/libs.versions.toml"))
        }
    }
}

include(":Template")
