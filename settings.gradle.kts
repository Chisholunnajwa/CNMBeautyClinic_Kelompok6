pluginManagement {
    repositories {
<<<<<<< HEAD
        google()
=======
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
>>>>>>> 216e546163397d823304350b9743247f90c3e34e
        mavenCentral()
        gradlePluginPortal()
    }
}
<<<<<<< HEAD

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)

=======
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
>>>>>>> 216e546163397d823304350b9743247f90c3e34e
    repositories {
        google()
        mavenCentral()
    }
}

<<<<<<< HEAD
rootProject.name = "CNMBeautyClinicKelompok_6"
include(":app")
=======
rootProject.name = "CNMBeautyClinic"
include(":app")
>>>>>>> 216e546163397d823304350b9743247f90c3e34e
