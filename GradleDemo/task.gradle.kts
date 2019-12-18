task("println", {
    project.properties.forEach { t, any ->
        println("$t : $any")
    }
})