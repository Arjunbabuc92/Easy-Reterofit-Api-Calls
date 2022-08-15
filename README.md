# Reterofit-Api-Call-Library
Welcome developers for now we only have support for POST method with raw string. Will be updated with all methods asap

to attach this module with your project first add jitpack.io dependency in your settings.gradle

add it like this

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}

then just add module dependency in your app.gradle

dependencies {
    implementation 'com.github.Arjunbabuc92:Easy-Reterofit-Api-Calls:Tag'
}

done
