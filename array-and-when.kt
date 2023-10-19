fun main() {
    println("Hello, world!!!")
    val number = arrayOf(1,2,3)
    
    for (i in number.indices) {
        println(number[i])
    }
    
    
    
    val arrayInt2 = IntArray(5, {i:Int->i})
    arrayInt2.forEach{
        println(it)
    }
    
    
    
	val x: Any = 1
    
    when (x) {
        is Boolean -> println("$x is Boolean")
        !is String -> println("$x no is String")
        else -> println("$x is other thing")
    }
    
    val status = 0
    
    val valorStatusString = when (status) {
        0 -> "Logged out"
        1 -> "Logged In"
        -1 -> "Down"
        else -> "Not found"
    }
    
    println(valorStatusString)
}
