//group "com.moushao"
//version '1.0-SNAPSHOT'


plugins {
    application
    kotlin("jvm") version "1.3.50"
}

application {
    mainClassName = "MainKt"
}

dependencies {
    compile(kotlin("stdlib"))
    compile("commons-httpclient", "commons-httpclient", "3.1")
}

repositories {
    mavenCentral()
    jcenter()
}


task("myDelete", Delete::class, {
    setDelete("src/main/temp")
})

task("myCopy", Copy::class, {
    from("src/main/java/Hello.java")
    into("src/main/temp")
})

/**
 *
 */
task("myjar", Jar::class, {
    from("src/main/java")
    into("src/main/java/a.jar")
})

/**
 *执行外部java字节码文件
 * 1:不需要带后缀名
 * 2:"."代表当前目录
 */
task("haha", {
    javaexec {
        main = "Hello"
        classpath(".")
    }
})