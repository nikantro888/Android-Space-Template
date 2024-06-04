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

fun includeProjects(directory: File, path: String, maxDepth: Int = 2) {
    directory.listFiles()?.toList()?.sortedBy { it.name }?.forEach { file ->
        if (file.isDirectory) {
            val newPath = "$path:${file.name}"
            val buildFile = File(file, "build.gradle.kts")
            if (buildFile.exists()) {
                include(newPath)
                logger.lifecycle("Included project: $newPath")
            } else if (maxDepth > 0) {
                includeProjects(file, newPath, maxDepth - 1)
            }
        }
    }
}

listOf("Space-Core", "Space-ToolKits", "Space-Libs").forEach { moduleName ->
    includeProjects(File(rootDir, moduleName), ":$moduleName")
}

include(settings.extra["APP_NAME"] as? String)