 package sortAndsearch_Algorthm.binarySearch

class Binary_khanway {



    fun apply_BinarySearch(number:Int,arr:IntArray):Int{


         var min = 0
         var max =arr.size-1//24
         var guess = (min+max)/2//12
        while (guess<max){

           if(number.equals(arr[guess]))return guess

            if(number>arr[guess]) {

                 min=guess+1
                guess=(min+max)/2//12

            }else if (number<arr[guess]){

                max=guess-1
                guess=(min+max)/2//12
            }
            else return guess

        }
        return -1
    }
}