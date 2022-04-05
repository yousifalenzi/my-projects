package sortAndsearch_Algorthm.selectionSort


fun selectionSort(array:Array<Int>):Array<Int>{

                var outer =0
                var insider =0


    for (i in 0 until array.size-1){ // n-1
        var min = i
        for (j in i+1 until array.size){//4    //[1,12,22,4,16]
            outer++

            if (array[j]<array[min]){ //

                  min= j // 3

            }

            insider++
        }

        val iVal = array[i] // 12
        array[i] =  array[min] //[1,4,22,4,16]
        array[min] = iVal////[1,4,22,12,16]
        outer++
    }
       println("total steps = ${outer+insider}")


    return array
}
fun selectionSort2(array:Array<Int>):Array<Int>{
       var outer =0
       var insider =0
       val step = array.size-1 //5
       var i = array.size-2//4
       var min =0

    while (i>-1){


           for (i in step-i .. step){//[0,1,3,4,]  min = 1//(113,1,6,3,2,9,0,22)
               insider++

               if (array[i]<array[min]){

                   val data = array[i] // 0
                   array[i]=array[min] // [1,3,1,4]
                   array[min] = data


               }

           }
           min++//2
           i-- //1
        outer++
       }
    println("total steps = ${outer+insider}")

   return array
}
fun selectionSort3(array:Array<Int>):Array<Int>{


    for(i in 0 until array.size){

        var min = i //1

        for (j in i+1 until array.size){//[1.4.6.2]

            if (array[j]<array[min]){

                min = j //3
            }
        }

        val data =array[i]//4
        array[i] =array[min]//[1.2.6.2]
        array[min]=data//[1.2.6.4]

    }
    return array
}
fun main() {
    val arr = arrayOf(4,2,5,6,1,8,10,3,7,9)//[] min

        println()
    selectionSort2(arr).forEach { print("| $it |") }





}