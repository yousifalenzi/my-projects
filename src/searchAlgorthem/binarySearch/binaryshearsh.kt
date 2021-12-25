package searchAlgorthem.binarySearch

class binaryshearsh {
      companion object{
           fun binarysearch_Recursive( array: IntArray,target:Int,min:Int,max:Int):Int{




                  if (min >max) return -1
                  val guess =(min+max)/2

                    val j = array.get(guess)

                  if(array.get(guess)==target)return guess
                 else if (array[guess]<target)return binarysearch_Recursive(array,target,guess+1,max)
                 else return binarysearch_Recursive(array,target,min,guess-1)


           }
          fun binarysearch(array:IntArray,Value:Int):Int{

              var front = 0
              var last = array.size-1

              while (front<=last){
                  val Mid = (front+last)/2
                  if (Value<array[Mid]) last = Mid-1
                  else if (Value>array[Mid]) front = Mid+1
                  else return Mid
              }
              return -1
          }

      }


     fun Recursive_LinearSearch(array:IntArray,index:Int,value:Int):Int{

         if (index>array.size-1) return-1
         else if (array[index]==value)return index
         else return Recursive_LinearSearch(array,index+1,value)

     }

    fun Recursive_BinarySearch(array:IntArray,front:Int,last:Int,value:Int):Int{

           println("$front ... $last")
        if (front>last)return-1
        var Mid = (front+last)/2 // 3
        println("THE MID Value IS : $Mid")

        if (array[Mid]==value) return Mid
        else if(array[Mid]>value) return Recursive_BinarySearch(array,front,Mid-1,value)
        else return Recursive_BinarySearch(array,Mid+1,last,value)

    }






}