package sortAndsearch_Algorthm.selectionSort

class selectionSorting {



    fun selectionSorting_(array:IntArray):IntArray{

        var arr = array


          for (x in 0 until arr.size-1){
              var mim = x//0

              for (j in x+1 until arr.size){

                  if (arr[j]<arr[mim]){//[1]<[0]

                      mim=j//
                  }
              }
            var tem = arr[x]//2
              arr[x]=arr[mim]//1
              arr[mim]= tem//2
          }


        return arr



    }
}