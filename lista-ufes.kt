class Lista(val info:Int, val prox:Lista?){
    override fun toString(): String{
        if(prox != null){
            return info.toString() + "->" + prox.toString()
        }
        return info.toString()
    }
}

fun del_posicao_n(lista: Lista?, posicao: Int, cont: Int = 1): Lista?{
    if(lista == null){
        return null
    }
    
    if(lista.prox != null){
        if(posicao == 1){
            return Lista(lista.prox.info, del_posicao_n(lista.prox, posicao, cont))
        }else if(cont == posicao){
            return Lista(lista.prox.info, del_posicao_n(lista.prox.prox, posicao, cont))
        }else{
            return Lista(lista.info, del_posicao_n(lista.prox, posicao, cont + 1))
        }
    }else{
        return Lista(lista.info, del_posicao_n(lista.prox, posicao, cont + 1))
    }
}

fun impar(lista: Lista?): Lista?{
    if(lista == null){
        return null
    }
    
    if(lista.info % 2 == 0){
        return impar(lista.prox)
    }else{
        return Lista(lista.info, impar(lista.prox))
    }
}

fun ordena(lista: Lista?): Lista?{
    if(lista == null){
        return null
    }
    
    if(lista.prox != null){
        if(lista.info > lista.prox.info){
            return ordena(Lista(lista.prox.info, Lista(lista.info, lista.prox.prox)))
        }else{
            return Lista(lista.info, ordena(lista.prox))
        }
    }else{
        return Lista(lista.info,null)
    }
}

fun fibo(elemento: Int): Int{
    if(elemento == 1){
        return 0
    }
    
    if(elemento == 2){
        return 1
    }
    
    return fibo(elemento-1) + fibo(elemento-2)
}

fun interseccao(lista1: Lista?, lista2: Lista?): Lista?{
    if(lista1 == null && lista2 == null){
        return null
    }
    
    if(lista1 != null && lista2 != null){
        if(lista1.info == lista2.info){
            return Lista(lista1.info, interseccao(lista1.prox, lista2.prox))
        }else{
            return interseccao(lista1.prox, lista2.prox)
        } 
    }else{
        return Lista(lista1.info, interseccao(lista1.prox, lista2.prox))
    }    
    
}

fun main() {
    val lista1 = Lista(1,(Lista(2, Lista(3, Lista(4, Lista(5, null))))))
    val lista2 = Lista(1,(Lista(3, Lista(4, Lista(1, Lista(3, Lista(2, null)))))))
    val lista3 = Lista(3,(Lista(6, Lista(4, Lista(8, Lista(1, Lista(9, Lista(7, null))))))))
    val lista4 = Lista(3,(Lista(6, Lista(5, Lista(7, null)))))
    val lista5 = Lista(9,(Lista(7, Lista(5, Lista(1, Lista(3, null))))))
    val impares = impar(lista3)
    println(interseccao(lista4, lista5))
    //println(del_posicao_n(lista2, 1, 1))
    //println(impares)
    //println(ordena(impares))
    //println(fibo(10))
}
