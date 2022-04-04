package SortAlgorthm.bubbles

fun bubbleSort(array: Array<Int>): Array<Int> {


    var step = array.size-1

    while (step>0){

        for (i in 0 until  step){

            if (array[i]>array[i+1]){
                //store data
                val data =  array[i+1]

                //swap
                array[i+1] = array[i]
                array[i]   = data

            }


            }
        step--


    }
    return array

}

fun main (){

    val arr = arrayOf(100,12,102,22,1)
    val bubbleSort = bubbleSort(arr)
    print("Sorted Array: ")
    bubbleSort.forEach { print("($it)") }


}
