import platform.posix.exit

fun main(args: Array<String>) {

    if (args.isEmpty()) {
        println(
            """
                 throttle - Throttle console log
                 Example:
                     ping www.google.com | throttle -n 5
        """.trimIndent()
        )
        exit(0)
        return
    }

    assert(args.size == 2)
    assert("-n" == args[0])
    val rate = args[1].toInt()
    var count = 0
    while (true) {
        val l = readLine()
        count++
        if (count % rate == 0) println(l)
    }
}