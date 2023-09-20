fun range(inicio:Int, fim:Int):List <Int>{
    return List(fim-inicio + 1){n->n+inicio}
}

fun somaPares(lista:List<Int>):Int{
    return lista.filter{x -> x%2 == 0}.sum()
}

fun main() {
    val listaInt = range(1,10)
    println(listaInt)
    val resultado = somaPares(listaInt)
    println(resultado)
}
