class Lista(val info:Int, val prox:Lista?=null){
    override fun toString():String{
        if(prox != null){
            return info.toString() + "->" + prox.toString()
        }
        return info.toString()
    }
}

fun incrementa(lista:Lista?):Lista?{
    if(lista == null){
        return null
    }
    return Lista(lista.info+1, incrementa(lista.prox))
}

fun imprime(lista:Lista?):String{
    if(lista == null){
        return "null"
    }    
    return lista.info.toString() + "->" + imprime(lista.prox)
}

fun encontra(lista:Lista?, posicao:Int):Int{
    if(lista == null){
        return 0
    }
    
    if(posicao == 0){
        return lista.info
    }
    return encontra(lista.prox, posicao-1)
}

fun concatena(lista1: Lista?, lista2:Lista?):Lista?{
	if(lista1 == null){
        return lista2
    }
    if(lista2 == null){
        return lista1
    }    
    if(lista1.prox == null){
        return Lista(lista1.info, lista2)
    }
    
    return Lista(lista1.info, concatena(lista1.prox, lista2))
}

fun verificaRep(lista:Lista?):Boolean{
    if(lista == null){
        return false
    }
    
    if(lista.prox == null){
        return checagem(lista.info, lista)
    }else{
        return checagem(lista.info, Lista(lista.prox.info, lista.prox.prox))
    }
}

fun checagem(valor:Int, lista:Lista):Boolean{
    if(lista.prox != null){
        if(valor == lista.info){
            return true
        }else{
            return checagem(valor, lista.prox)
        }
    }else{
        if(valor == lista.info){
            return true
        }else{
            return false
        }
    }
}

fun inserir(valor:Int, lista:Lista?):Lista?{
    if(lista == null){
        return Lista(valor, null)
    }
    
    if(lista.prox != null){
        return Lista(lista.info, inserir(valor, lista.prox))
    }
    return Lista(lista.info, Lista(valor, lista.prox))
}

fun remover(valor:Int, lista:Lista?):Lista?{
    if(lista ==  null){
        return null
    }
    
    if(lista.prox != null){
        if(valor == lista.info){
            return Lista(lista.prox.info, lista.prox.prox)
        }else{
            return Lista(lista.info, remover(valor, lista.prox))
        }
    }else{
        return Lista(lista.info, remover(valor, lista.prox))
    }
}

fun removerFim(lista:Lista?):Lista?{
    if(lista == null){
        return null
    }
    
    if(lista.prox != null){
        return Lista(lista.info, removerFim(lista.prox))
    }
    return removerFim(lista.prox)
}

fun main() {
    val l1 = Lista(1, Lista(2, Lista(3, Lista(4, Lista(5, null)))))
    val l2 = Lista(6, Lista(7, Lista(8, Lista(9, Lista(10, null)))))
    val l3 = Lista(10, Lista(8, Lista(15, Lista(7, Lista(10, null)))))
    val l4 = Lista(16, Lista(1, Lista(18, Lista(20, Lista(20, null)))))
    val l5 = Lista(16, Lista(16, Lista(18, Lista(2, Lista(20, null)))))
    
    println(incrementa(l1))
    println(imprime(l1))
    println(encontra(l1, 1))
   	println(concatena(l1, l2))
    println(verificaRep(l3))
    println(verificaRep(l4))
    println(verificaRep(l1))
    println(verificaRep(l5))
    println(inserir(14, l1))
    println(remover(7, l2))
    println(removerFim(l1))
    
}
