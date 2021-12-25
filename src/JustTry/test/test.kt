package JustTry.test


 class testing(){


     companion object{

            private var min = 0 ;
            private var max = 0 ;
            private var ii = 1
            private var p = 0


         fun getMinNumberInList(arr:IntArray):Int{

                      min = arr[0]


             for (i in 1 until  arr.size){ if (arr[0]>arr[i]&&min>arr[i])min= arr[i]}

             return min ;
         }
         fun linear (array: Array<Int>,start:Int,target:Int):Int{

             if (array[start]==target)return start
             return linear(array,start+1,target)



         }
         fun getMaxNumberInList(arr:IntArray):Int{

             max = arr[0]//13


             for (i in 1 until  arr.size){ if (arr[0]<arr[i]&& max<arr[i])max= arr[i]}

             return max ;
         }
         fun Sum(int:Int):Int{
             if (int <= 0) return 1
             val getone = Sum(int - 1)

             return getone+int
         }
         fun SortArray(arr:IntArray):IntArray{
              var arr = IntArray(arr.size)

             var datasave =0

                  while (ii<arr.size){

                      if (arr[p]>arr[ii]){

                          datasave = arr[p]
                           arr[p]= arr[ii]
                           arr[ii] =datasave
                      }


                  }


             return arr
         }
     }
 }


 fun main (){

          val arr = intArrayOf(13,65,3,7,9,80,1)

          println("Min Number is :${testing.getMinNumberInList(arr)}")
          println("Max Number is :${testing.getMaxNumberInList(arr)}")


 }