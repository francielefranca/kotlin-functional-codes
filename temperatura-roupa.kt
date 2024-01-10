fun main() {
    val tempEnt = 27
    
    println("Digite a temperatura atual em graus Celsius:")
    println("$tempEnt °C")    
    
    if(tempEnt <= 20){
        println("usa un abrigo hace frio")
    }else if(tempEnt >= 21 && tempEnt <=30){
        println("te irá bien si usar chaqueta, el clima es templado")
    }else{
        println("es mejor que lleves algo ligero, hace calor")
    }
}
