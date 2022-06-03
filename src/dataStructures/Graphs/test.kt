package dataStructures.Graphs



fun main (){

    val hash = HashSet<Int>()
    hash.add(3)
    hash.add(6)
    hash.add(2)
    hash.add(9)
    hash.add(1)
    val visit = HashMap<Int, Boolean>()//to cheek vertexes

    for (data in hash.iterator()){


        println(data)
        visit[data] = true
     }

}