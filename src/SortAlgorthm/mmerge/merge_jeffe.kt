package SortAlgorthm.mmerge




fun MergeSort(array: Array<Int>,LOW:Int,HIGH:Int){ //[3,1,5,2]

      if(HIGH<=LOW)return

            val MID = (LOW+HIGH)/2 //0+3 3/2=1
    MergeSort(array,LOW,MID) // 0--1
    MergeSort(array,MID+1,HIGH) //2---3
            Merge(array,LOW,MID,HIGH)
}

private fun Merge(array: Array<Int>, start: Int, mid: Int, end: Int) {


               val tempArray = Array<Int?>((end-start)+1,{null})

              var i = start // 0
              var j = mid+1 //1
              var k = 0


      while (i<=mid&&j<=end){//n
            if (array[i]<array[j]){
                  tempArray[k] = array[i] // [3]
                  i++//1
            }
            else{
                  tempArray[k] = array[j]
                  j++
            }
            k++ }


      while (i<=mid){

            tempArray[k] = array[i]
            i++
            k++ }

      while (j<=end){

            tempArray[k] = array[j]
            j++
            k++ }


      //copy data to new array
            for (g in tempArray.indices){ array[start+g] = tempArray[g]!! } }




fun main (){


     val array = arrayOf(13,3,5,1,7,2)
      MergeSort(array,0,array.size-1)

      for (value in array){

            print("$value , ")
      }




}

