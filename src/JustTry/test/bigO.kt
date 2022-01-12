package JustTry.test


     // اسوء سيناريو راح تكون القيمه في الاخير او قد لاتكون موجوده
    // افضل سيناريو راح تكون القيمه في الاول
   // السيناريو المتوسط راح تكون القيمه في المنتصف او قبل المنتصف


   fun search(array:IntArray,number:Int):Int{
       for(i in 0 until  array.size){ // (1+n)


           if (array[i]==number) return i   // o(n)

       }
       return -1 //1


        // (2+n)
       //O(N)
   }

   fun looping (array1:IntArray,array2:IntArray){  // O(N+M) = (2N) = O(n)

       for(i in 0 until  array1.size){   // n

           println(array1[i])
       }

       for(i in 0 until  array2.size){  /// m

           println(array2[i])

       }

        // O(N+M)


   }

 fun main(){


       val arr = intArrayOf(2,4,5,6,1)
       println( search(arr , 11))



 }