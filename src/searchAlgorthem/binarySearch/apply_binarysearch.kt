package searchAlgorthem.binarySearch


fun apply_BinarySearch(number:Int,arr:IntArray):Int{


    var min = 0
    var max =arr.size-1
    var guess:Int?=null
    while (min<=max){
         guess = (min+max)/2
        if(number>arr[guess]) min=guess+1
        else if (number<arr[guess]) max=guess-1
        else return guess

    }
    return -1
}

fun anyting(targetValue:Int,array:IntArray): Int? {
    var min = 0
    var max =array.size-1
    var guess:Int?=null
    while(min<=max){

        guess = (min+max)/2  
        if(targetValue==array[guess]){return guess}
        else if(targetValue<array[guess]){max = guess-1;}
        else{min = guess+1}

    }
  return null
}
fun main() {

   val arr = IntArray(10)
    arr.set(0,8)
    arr.set(1,12)
    arr.set(2,15)
    arr.set(3,19)
    arr.set(4,26)
    arr.set(5,30)
    arr.set(6,35)
    arr.set(7,43)
    arr.set(8,48)
    arr.set(9,52)




}