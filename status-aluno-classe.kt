class Aluno (val nome:String, val nota:Float)

fun resultado (alunos: List<Aluno>): String{
    val aprovados = alunos.filter{aluno -> aluno.nota >= 7}.map{aluno -> aluno.nome}
    val reprovados = alunos.filter{aluno -> aluno.nota <= 5}.map{aluno -> aluno.nome}
    
    return "Alunos aprovados com nota maior que 7 = " + aprovados + "\n" + "Alunos reprovados com nota menor que 5 = " + reprovados
}

fun main() {
    val listaDeAlunos = listOf(
        Aluno("Alberto", 7.2f),
        Aluno("Berenice", 4.1f),
        Aluno("Clovis", 2.9f),
        Aluno("Dora Aventureira", 6.3f),
        Aluno("Dexter", 7.0f),
    	Aluno("Franciele", 10.0f),
        Aluno("Lucas", 10.0f),
        Aluno("Sing", 10.0f),
        Aluno("Zuleia", 1.1f)
        
    )
    
    println(resultado(listaDeAlunos))
}
