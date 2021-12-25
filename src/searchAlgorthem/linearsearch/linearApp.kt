package searchAlgorthem.linearsearch

fun main() {
    val arr = IntArray(5)
    arr[0]=2
    arr[1]=34
    arr[2]=13
    arr[3]=94
    arr[4]=9

    var searchAlgorithme = LinearSearchAlgorithme(arr, 9)
    if (searchAlgorithme[0]==-1){
        print("NOT FOUND  ")


    }else{

        print("VALUE FOUND IT AFTER ${searchAlgorithme[1]} MOVEMENT ")

    }
    println(".. VALUE IS ("+searchAlgorithme[0]+")")
}



fun LinearSearchAlgorithme(array:IntArray,value:Int):IntArray{

     var answer = -1
    var movment=-0
    var arr:IntArray=IntArray(2)

      for (i in 0 until array.size){
          movment++

          if (array[i]==value){

              answer = value
              arr?.set(0,answer)
              break

          }
      }

    arr?.set(1,movment)

    return arr!!
}