class Lista(val info:Int, val prox:Lista?){
    override fun toString(): String{
        if(prox != null){
            return info.toString() + "->" + prox.toString()
        }
        return info.toString()
    }
}

fun geraQuad(lista: Lista?): Lista?{
    if(lista == null){
        return null
    }
    return Lista(lista.info*lista.info, geraQuad(lista.prox))
}

fun somaQuad(lista: Lista?): Int{
    if(lista == null){
        return 0
    }
    return lista.info + somaQuad(lista.prox)
}

fun somaQuad2(lista: Lista?): Int{
    if(lista == null){
        return 0
    }
    return (lista.info*lista.info) + somaQuad2(lista.prox)
}

fun estaOrdenada(lista: Lista?): Boolean{
    if(lista == null){
        return true
    }
    if(lista.prox != null){
        if(lista.info < lista.prox.info){
            return estaOrdenada(lista.prox)
        }else{
            return false
        }
    }
    return true
}

fun verifica(lista: Lista?, elemento: Int): Boolean{
    if(lista == null){
        return false
    }
    if(lista.info == elemento){
        return true
    }else{
        return verifica(lista.prox, elemento)
    }
}

fun qtdVezes(lista: Lista?, valor:Int): Int{
    if(lista == null){
        return 0
    }
    if(lista.info == valor){
        return 1 + qtdVezes(lista.prox, valor)
    }else{
        return qtdVezes(lista.prox, valor)
    }
}

fun ultimaOcorrencia(lista: Lista?, valor: Int): Lista?{
    if(lista == null){
        return null
    }
    
    if(lista.prox.prox != null){
        if(lista.prox != null){
         	if(lista.info == valor){
            	return Lista(lista.prox, ultimaOcorrencia(lista.prox.prox, valor))
        	}else if(lista.prox.info == valor){
            	return Lista(lista.prox.prox, ultimaOcorrencia(lista.prox.prox, valor))
        	}else{
            	return Lista(lista.info, ultimaOcorrencia(lista.prox, valor))
        	}   
        }
    }
     
    return ultimaOcorrencia(lista.prox, valor)
}

fun main() {
    val lista1 = Lista(1,(Lista(2, Lista(3, Lista(4, Lista(5, null))))))
    val lista2 = Lista(14,(Lista(2, Lista(18, Lista(4, Lista(10, null))))))
    val lista3 = Lista(14,(Lista(4, Lista(4, Lista(4, Lista(10, null))))))
    //val listaQuad = geraQuad(lista1)
    
    println("lista 1 =")
    println(lista1)
    println("lista 2 =")
    println(lista2)
    /*
    println("lista ao quadrado da lista 1 = ")
   	println(listaQuad)
    println("soma do quadrado da lista 2 = ")
    println(somaQuad2(lista2))
    println(somaQuad(listaQuad))
    println(estaOrdenada(lista2))
    println(verifica(lista2, 10))
    */
    println(qtdVezes(lista3, 4))
    println(ultimaOcorrencia(lista3, 4))
}
