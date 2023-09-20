class Pessoa (val nome:String, val idade:Int, val cidade:String)

fun maior18(listaPessoas: List<Pessoa>):List<String>{
    val maiores18 = listaPessoas.filter{pessoa -> pessoa.idade > 18}
    val pessoasMaiores18 = maiores18.map{pessoa -> pessoa.nome}
    return pessoasMaiores18
}

fun main() {
    val listaP = listOf(Pessoa("Fran", 22, "Olinda"), 
    					Pessoa("Dagon", 27, "Lovecraft"),
    					Pessoa("Bob", 15, "September")                   
    )
        
    println(maior18(listaP))
}
