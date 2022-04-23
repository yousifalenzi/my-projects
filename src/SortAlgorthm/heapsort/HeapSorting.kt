package SortAlgorthm.heapsort


val MAX_HEAP = "MAX"
val MIN_HEAP = "MIN"
fun swap(array: Array<Int>,old:Int,new:Int){// 12
                                            //8   7


    val oldVaule = array[old]//12
    array[old] = array[new]
    array[new] = oldVaule


}

fun Min_Heapfiy(Array:Array<Int>,n:Int,i:Int){ //  6 - 2

      val left = 2*i+1 // 5
      val right = left+1//6
      var largest = i//0

    //checking for the smallest element

    if (left<=n&&Array[left]>Array[i]){//  10
                                     //  8  9
        //                             5,1 , 2,7
        largest = left //5
    }
    else{
        largest = i
    }

    if (right<=n&&Array[right]>Array[largest])
    {
        largest = right//2
    }

    //updating the min -heap tree
    if (largest!=i){
        val data =  Array[i]

        Array[i] = Array [largest]
        Array [largest] = data

        Min_Heapfiy(Array,n,largest)


    }





}

fun print_like_tree (Array:Array<Int>){

    var Vblanks = 32
    var itemPerRow = 1
    var column = 0
    var j = 0
    val currentsize = Array.size
    println("current size is :${Array.size}")

    val dots = "..............................."
    println(dots+dots)

    while (currentsize>0){


        if (column==0){

            for (k in 0 until Vblanks){
                print(" ")
            }
        }

        print(Array[j])
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


fun main(){


//   val arr = arrayOf(6,3,9,15,41,23,18)
//    val startIdx: Int = arr.size / 2 - 1
//
//  for (i in startIdx downTo 0){
//
//      Min_Heapfiy(arr,arr.size-1,i)
//  }
//    print_like_tree(arr)

    val m = 1000
    var log = 0
     var i = 0 //7521


        while (i<= m) {
            log=log+9
            i++


        }
    println("$log")


}