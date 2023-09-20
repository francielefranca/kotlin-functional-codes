class Lista(val info:Int, val prox:Lista?){
    override fun toString():String{
        if(prox != null){
            return info.toString() + "->" + prox.toString()
        }
        return info.toString()
    }
}

//filter para numeros inteiros
fun filter(l:Lista?, t:(Int)-> Boolean):Int{
    if(l == null){
        return 0
    }else if(t(l.info)){
        return l.info
    }else{
        return filter(l.prox,t)
    }
}

//funcao que retorna o menor numero de uma lista com filter
fun menorNumero(lista:Lista?):Int{
   	if(lista == null){
       return 0
    }
    
    if(lista.prox != null){
        return filter(lista, {x:Int -> x < lista.info})
    }
    
    return menorNumero(lista.prox)
}

//funcao que retorna o menor numero de uma lista
fun menor(lista:Lista):Int{
    if(lista.prox == null){
        return lista.info
    }
    
    val pivot = menor(lista.prox)
        
    if(lista.info < pivot){
        return lista.info
    }
    
    return pivot
}

//retorna o nElemento na posicao passada
fun nElemento(posicao:Int, lista:Lista?):Int{
    if(lista == null){
        return 0
    }
    
    if(posicao == 1){
        return lista.info
    }
    
    return nElemento(posicao-1, lista.prox)
}

//retorna se um elemento pertence a uma lista
fun pertence(elem:Int, lista:Lista?):Boolean{
    if(lista == null){
        return false
    }
    
    if(elem == lista.info){
        return true
    }
    return pertence(elem, lista.prox)
}

//quantidade de elementos em uma lista
fun qtdElementos(lista:Lista?):Int{
    if(lista == null){
        return 0
    }
    return 1 + qtdElementos(lista.prox)
}

//retorna o maior elemento de uma lista
fun maior(lista:Lista):Int{
    if(lista.prox==null){
        return lista.info
    }
    
    val pivot = maior(lista.prox)
    
    if(lista.info > pivot){
        return lista.info
    }
    return pivot
}

//conta quantas vezes um elemento aparece
fun conta_ocorr(elem:Int, lista:Lista?):Int{
    if(lista == null){
        return 0
    }
    
    if(lista.info == elem){
        return 1 + conta_ocorr(elem, lista.prox)
    }
    return conta_ocorr(elem, lista.prox)
}

//unica ocorrencia
fun unica_ocorr(elem:Int, lista:Lista?):Boolean{
    if(lista == null){
        return false
    }
    
    val ocorr = conta_ocorr(elem, lista)
    
    if(ocorr == 1){
        return true
    }
    
    return false
}

//maiores que
fun maiores_que(elem:Int, lista:Lista?):Lista?{
    if(lista == null){
        return null
    }
    
    if(lista.info > elem){
        return Lista(lista.info, maiores_que(elem, lista.prox))
    }
    return maiores_que(elem, lista.prox)
}

//concatena
fun concatena(l1:Lista?, l2:Lista?):Lista?{
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

//remove o primeiro elemento da lista
fun remove(lista:Lista?):Lista?{
    if(lista == null){
        return null
    }
    
    if(lista.prox != null){
        return Lista(lista.prox.info, remove(lista.prox))
    }
    return remove(lista.prox)
}

//remove o ultimo elemento da lista
fun remove_ultimo(lista:Lista?):Lista?{
    if(lista == null){
        return null
    }
    
    if(lista.prox != null){
        return Lista(lista.info, remove_ultimo(lista.prox))
    }
    return remove_ultimo(lista.prox)
}

//remove elemento
fun remove_elem(lista:Lista?, elem:Int):Lista?{
    if(lista == null){
        return null
    }
    
    if(lista.prox != null){
        if(lista.info == elem){
            return Lista(lista.prox.info, remove_elem(lista.prox.prox, elem))
        }
        return Lista(lista.info, remove_elem(lista.prox, elem))
    }
    return Lista(lista.info, remove_elem(lista.prox, elem))
}

//verifica se tem repetidos 
fun tem_rep(lista:Lista?, elem:Int):Boolean{
    if(lista == null){
        return false
    }
    
    if(lista.prox != null){
        if(lista.info == elem){
            return true
        }
        return tem_rep(lista.prox, elem)
    }
    
    return tem_rep(lista.prox, elem)
}

//remove repetidos
fun remove_rep(lista:Lista?):Lista?{
    if(lista == null){
        return null
    }
    
    if(lista.prox != null){
        if(tem_rep(lista, lista.info) == true){
            return concatena(Lista(lista.info, null), remove_elem(lista, lista.info))
        }
        return Lista(lista.info, remove_rep(lista.prox))
    }
    return Lista(lista.info, remove_rep(lista.prox))
}

fun gera_seq(n:Int):Lista?{
    if(n == 0){
        return null
    }
    
   
    if(n == 1){
        return Lista(n, Lista(-n, gera_seq(0)))
    }
    return Lista(n, Lista(-n, gera_seq(n-1)))
}

fun main() {
    val listaMenor = Lista(10, Lista(2, Lista(53, Lista(24, Lista(5, null)))))
    val listaMenor2 = Lista(10, Lista(28, Lista(53, Lista(1, Lista(5, null)))))
    val l2 = Lista(3, Lista(7, Lista(4, Lista(2,null))))
    val l3 = Lista(3, Lista(28, Lista(3, Lista(1, Lista(5, Lista(3, Lista(5, Lista(5, Lista(3, null)))))))))
    val l4 = Lista(1, Lista(4, Lista(3, Lista(4, Lista(5, null)))))
    val l5 = Lista(3, Lista(28, Lista(53, Lista(1, Lista(5, null)))))
    val l6 = Lista(10, Lista(4, Lista(53, Lista(1, Lista(5, null)))))
    val l7 = Lista(4, Lista(6, Lista(30, Lista(3, Lista(15, Lista(3, Lista(10, Lista(7, null))))))))
    val lista1 = Lista(1, Lista(2, null))
    val lista2 = Lista(3, Lista(4, null))
    //val listaMenor2 = Lista(10, Lista(28, Lista(53, Lista(1, Lista(5, null)))))

    //println(listaMenor2)
    //println(menorNumero(listaMenor2))
    //println(menor(listaMenor2))
    println(nElemento(1,l2))
    println(pertence(1, l2))
    println(qtdElementos(listaMenor2))
    println(maior(listaMenor2))
    println(conta_ocorr(3, l3))
    println(unica_ocorr(4, l4))
    println(unica_ocorr(4, l5))
    println(unica_ocorr(4, l6))
    println(maiores_que(10,l7))
    println(concatena(lista1, lista2))
    println(l2)
    println(remove(l2))
    println(l2)
    println(remove_ultimo(l2))
    println(l7)
    println(remove_rep(l7))
    println(gera_seq(3))
    
}
