fun main() {
    println("Collections em Kotlin")
    val l1 = listOf(1,2,3,4,5)
    val l2 = listOf(1,2,3,4,5)
    val l3 = listOf(2,4,6,8,10)
    val l4 = listOf(15,16,20,53,30)
    println(l1)
    println(l1.size)
    println(l1.containsAll(l2))
    println(l1.containsAll(l3))
    println(l4.asReversed())
    println(l4.drop(1))
    
    val linha = 4
    val altura = 4
    val matriz:List<List<Int>> = List(altura){List(linha){0}}
    matriz.forEach{it-> it.forEach{println(it)}}
    //matriz.forEach{linha-> linha.forEach{coluna, linha -> coluna + linha}}
    
}
