package dataStructures.heap

class heap_min(val sizeOfArray:Int){

     var heapMin_Array:IntArray=IntArray(sizeOfArray)
     val MaxSzie = sizeOfArray
     var currentsize = 0
     private var LARGENUMBER = 0


    //public fun

        fun getsize () = currentsize
        fun IsEmpty():Boolean = currentsize == 0
        fun IsFull ():Boolean= currentsize==MaxSzie
        fun insert_MinWay(value:Int):Boolean{

            if (IsFull()) return false
            Insert_Elment(value)
            currentsize++
            return true
        }
        fun GetBigger() = LARGENUMBER
        fun GetSmallest() = heapMin_Array[0]
        fun remove():Int{
        val numberWasRemoveIt = heapMin_Array[0]

        if (currentsize==0)return 0
        currentsize--
        heapMin_Array[0] = heapMin_Array[currentsize]
        0.remove_data()
        return numberWasRemoveIt

    }
        fun print_like_tree (){

        var Vblanks = 32
        var itemPerRow = 1
        var column = 0
        var j = 0
        println("current size is :$currentsize")

        val dots = "..............................."
        println(dots+dots)

        while (currentsize>0){


            if (column==0){

                for (k in 0 until Vblanks){
                    print(" ")
                }
            }

            print(heapMin_Array[j])
            j++
            if (j==currentsize)break

            column++
            //end of row

            if (column==itemPerRow){

                Vblanks=Vblanks/2
                itemPerRow=itemPerRow*2
                column=0
                println()
            }
            else{

                for (k in 0 until Vblanks*2){

                    print(" ")
                }
            }
        }
        println("\n${dots+dots}")
    }



    //private fun
    private fun SetBigger(value: Int) {
        if (IsEmpty()) LARGENUMBER = value
        else if (LARGENUMBER < value) LARGENUMBER = value
    }
    private fun Int.remove_data() {
        var currentIndex = this
        val currentLevel = currentsize / 2
        var currentchild: Int
        val currentRoot = heapMin_Array[currentIndex]
        while (currentIndex < currentLevel) {

            val currentLeftChild = (2*currentIndex)+1
            val currentRightChild = currentLeftChild+1

            if (currentRightChild>0&& heapMin_Array[currentLeftChild]< heapMin_Array[currentRightChild]){

                currentchild = currentLeftChild
            }
            else{
                currentchild = currentRightChild
            }

            if (currentRoot<heapMin_Array[currentchild])break

            heapMin_Array[currentIndex] =  heapMin_Array[currentchild]
            currentIndex=currentchild


        }

        heapMin_Array[currentIndex] = currentRoot


    }
    private fun Insert_Elment(value: Int) {

        SetBigger(value)
        var current_index = currentsize
        val current_value = value
        heapMin_Array[current_index] = current_value


        var current_parent = (current_index - 1) / 2 //1


        while (current_index > 0 && heapMin_Array[current_parent] > current_value) {


            heapMin_Array[current_index] = heapMin_Array[current_parent]
            current_index = current_parent //1
            current_parent = (current_index - 1) / 2 //0

        }
        heapMin_Array[current_index] = current_value

    }



}

fun main(){



      val h = dataStructures.heap.heap_min(7)
        h.insert_MinWay(17)
        h.insert_MinWay(13)
        h.insert_MinWay(26)
        h.insert_MinWay(12)
        h.insert_MinWay(25)
        h.insert_MinWay(22)
        h.insert_MinWay(78)


    println("BIGEEST VAULE = ${h.GetBigger()}")
      println("SMALLEST VAULE = ${h.GetSmallest()}")

    for (i in 0 until 3){
        println("${h.remove() }, ")
    }


    h.print_like_tree()

}