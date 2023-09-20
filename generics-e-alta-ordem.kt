class Lista<C> (val info:C, val prox:Lista<C>?){
    override fun toString():String{
        if(prox != null){
            return info.toString() + "->" + prox.toString()
        }
        return info.toString()
    }
}

fun <C> inverte(lista:Lista<C>?):Lista<C>?{
    if(lista == null){
        return null
    }
    
    return concatena(inverte(lista.prox), Lista(lista.info, null))
}

fun <C> concatena(l1:Lista<C>?, l2:Lista<C>?):Lista<C>?{
    if(l1 == null){
        return l2
    }
    
    if(l2 == null){
        return l1
    }
    
    if(l1.prox != null){
        return Lista(l1.info, concatena(l1.prox, l2))
    }
    
    return Lista(l1.info, l2)
}

fun <C> divide(n:Int, lista:Lista<C>?):Lista<C>?{
    if(lista == null){
        return null
    }
    
    if(n == 0){
       return concatena(Lista(lista.info, divide(0, lista.prox)), null)
    }
    return Lista(lista.info, divide(n-1, lista.prox)) 
}

fun <C> intercala(l1:Lista<C>?, l2:Lista<C>?):Lista<C>?{
    if(l1 == null){
        return l2
    }
    
    if(l2 == null){
        return l1
    }
    
    if(l1.prox != null){
        return Lista(l1.info, Lista(l2.info, intercala(l1.prox, l2.prox)))
    }
    return Lista(l1.info, Lista(l2.info, intercala(l1.prox, l2.prox)))
}

//nao funciona corretamente
fun <C> uniao(l1:Lista<C>?, l2:Lista<C>?):Lista<C>?{
    if(l1 == null){
        return l2
    }
    
    if(l2 == null){
        return l1
    }
    
    if(l1.prox != null){
        if(l1.info != l2.info){
            return Lista(l1.info, uniao(l1.prox, l2.prox))
        }else{
            if(l2.prox != null){
                return Lista(l1.info, uniao(l1.prox, l2.prox.prox))
            }
           return uniao(l1.prox, l2.prox)
        }
    }
    return Lista(l1.info, Lista(l2.info, uniao(l1.prox, l2.prox)))
}

fun <C> sequencia(rep:Int, elem:C):Lista<C>?{
    if(rep == 0){
        return null
    }
    
    if(rep == 1){
        return Lista(elem, sequencia(0, elem))
    }
    return Lista(elem, sequencia(rep-1, elem))
}

fun <C> map(l:Lista<C>?, f:(C)->C):Lista<C>?{
    if(l == null){
        return null
    }
    
    if(l.prox!= null){
        return Lista(f(l.info), map(l.prox, f))
    }
    return Lista(f(l.info), map(l.prox, f))
}

fun somatorio(lista:Lista<Int>?)=map(lista, {x:Int-> 3+x})

fun <C> map2(l1:Lista<C>?, l2:Lista<C>?, f:(C,C)->C):Lista<C>?{
    if(l1 == null){
        return l2
    }
    
    if(l2 == null){
        return l1
    }
    
    if(l1.prox != null && l2.prox != null){
        return Lista(f(l1.info, l2.info), map2(l1.prox, l2.prox, f))
    }
    return Lista(f(l1.info, l2.info), map2(l1.prox, l2.prox, f))
}

fun somaLista(lista1:Lista<Int>?, lista2:Lista<Int>?)=map2(lista1, lista2, {x, y:Int -> x + y})

//compacta a lista, retirando os repetidos seguidos
fun <C> compacta(lista:Lista<C>?):Lista<C>?{
    if(lista == null){
        return null
    }
    
    if(lista.prox == null){
        return lista
    }
    
    if(lista.info != lista.prox.info){
        return Lista(lista.info, compacta(lista.prox))
    }
    
    return compacta(lista.prox)
}

fun <C> rotate (lista:Lista<C>?):Lista<C>?{
    if(lista == null){
        return null
    }
    
    if(lista.prox == null){
        return Lista(lista.info, rotate(lista.prox))
    }
    
    return Lista(lista.prox.info, rotate(Lista(lista.info, lista.prox.prox)))
}

fun main() {
    val l5 = Lista(3, Lista(28, Lista(53, Lista(1, Lista(5, null)))))
    val l6 = Lista(1, Lista(2, Lista(3, Lista(4, Lista(5, null)))))
    val l7 = Lista(1, Lista(2, Lista(3, Lista(4, Lista(5, null)))))
    val l8 = Lista(1, Lista(1, Lista(1, Lista(2, Lista(2, Lista(3, Lista(3, Lista(3, Lista(3, Lista(1, Lista(1, null)))))))))))
    
    println(inverte(l5))
    println(divide(2,l6))
    println("lista 5: $l5")
    println("lista 6: $l6")
    println(intercala(l5,l6))
    println("uniao: ${uniao(l5,l6)}")
    println("sequencia: ${sequencia(5,2)}")
    println("somatorio por 3: ${somatorio(l6)}")
    println("soma listas: ${somaLista(l6,l7)}")
    println("lista 8: $l8")
    println("compacta lista: ${compacta(l8)}")
    println(rotate(l7))
}
