package sortAndsearch_Algorthm.selectionSort

class selectionSorting {



    fun selectionSorting(array:IntArray):IntArray{

          for (x in 0 until array.size-1){
              var min = x

              for (j in x+1 until array.size){

                  if (array[j]<array[min])min=j

              }
              val tem = array[x]
              array[x]=array[min]
              array[min]= tem
          }
        return array
    }
}