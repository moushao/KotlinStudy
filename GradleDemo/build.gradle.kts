/*
plugins {
    id 'org.jetbrains.kotlin.jvm' version '1.3.41'
}

group 'com.moushao'
version '1.0-SNAPSHOT'

repositories {
    maven { url 'https://maven.aliyun.com/repository/public/' }
    maven { url 'https://maven.aliyun.com/repository/spring/' }
    mavenLocal()
    mavenCentral()
}

dependencies {
    implementation "org.jetbrains.kotlin:kotlin-stdlib-jdk8"
}

compileKotlin {
    kotlinOptions.jvmTarget = "1.8"
}
compileTestKotlin {
    kotlinOptions.jvmTarget = "1.8"
}*/

plugins {
    application
}

application {
    mainClassName = "Main"
}

task("println", {
    project.properties.forEach { t, any ->
        println("$t : $any")
    }
})

defaultTasks("println")