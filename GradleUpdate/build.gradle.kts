plugins {
    java
}

//把所有源代码的文件名称记录下来
task("getSrcName", {
    inputs.dir("src")
    outputs.file("info.txt")
    doFirst {
        var srcdir = fileTree("src")
        var infotxt = file("info.txt")
        srcdir.forEach {
            if (it.isFile) {
                Thread.sleep(1000)
                infotxt.appendText(it.absolutePath)
                infotxt.appendText("\r\n")

            }
        }
    }
})