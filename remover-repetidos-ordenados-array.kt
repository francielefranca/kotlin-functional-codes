fun main() {
    var arrayNum = arrayOf(1,1,2,2,2,3,4,4,5,5,5)
    var arrayBox = emptyArray<Int>()
    
    for (i in arrayNum.indices){
        var isDuplicate = false
        for (j in 0 until i){
            if(arrayNum[i] == arrayNum[j]){
                isDuplicate = true
                break
            }
        }
        if(!isDuplicate){
            arrayBox += arrayNum[i]
        }
    }
    
    for (j in arrayBox.indices){
        println(arrayBox[j])
    }
}
