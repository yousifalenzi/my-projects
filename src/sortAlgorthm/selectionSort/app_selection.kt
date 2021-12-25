package sortAndsearch_Algorthm.selectionSort


fun selectionSort(array:IntArray):IntArray{

                var outer =0
                var insider =0


    for (i in 0 until array.size-1){ // n-1
        var min = i //1
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
       print("total steps = ${outer+insider}")


    return array
}
fun main() {
    val arr = IntArray(5)
    arr.set(0,22)
    arr.set(1,4)
    arr.set(2,13)
    arr.set(3,16)
    arr.set(4,12)

    val sorting = selectionSort(arr)





}