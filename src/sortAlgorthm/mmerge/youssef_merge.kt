package sortAlgorthm.mmerge

class youssef_merge {



    fun mergeSort(arr:Array<Int>){

        sort(arr,0,arr.size-1)
    }
    private fun sort (array: Array<Int>, start:Int, end:Int){// [4,7,2,3,6]
           //start = 0 , end = 1
            if(end<=start) return
            //(0,2), (0,1), (0,0)
        val mid = (start+end)/2  // 0
        sort(array,start,mid)   //(0,2)
        sort(array,mid+1,end) // (3,5)
        merge_data(array,start,mid,end)

    }


    private fun  merge_yousef(array: Array<Int>, start: Int, mid: Int, end: Int){

        val newarray = IntArray(end-start+1)


        var i = start
        var j =mid+1
        var k = 0

        while (i<=mid&& j<=end){

            if (array[i]<array[j]){

                newarray[k] = array[i]
                i++
            }else{
                newarray[k] = array[j]
                j++
            }
            k++
        }



        while (i<=mid){

            newarray[k] = array[i]
            i++
            k++
        }
        while (j<=end){

            newarray[k] = array[j]
            j++
            k++
        }


        for (i in 0 until newarray.size){

            array[start+i] = newarray[i]

        }
    }
    private fun merge_data(array: Array<Int>, start: Int, mid: Int, end: Int) {




           val leftarray = IntArray(mid-start+1)
           val rightarray = IntArray(end-mid)

        for (i in 0 until leftarray.size) leftarray[i]=array[start+i]
        for (j in 0 until rightarray.size) rightarray[j]=array[mid+1+j]

        var i = 0
        var j = 0
        var pointerArray = start

        while (i<leftarray.size && j < rightarray.size){

                if (leftarray[i] <= rightarray[j]){

                    array[pointerArray] = leftarray[i]
                    i++
                }
                else{
                    array[pointerArray] = rightarray[j]
                    j++

                }
                pointerArray++

            }


          while (i<leftarray.size){

              array[pointerArray] = leftarray[i]
              i++
              pointerArray++
          }
        while (j<rightarray.size){

            array[pointerArray] = rightarray[j]
            j++
            pointerArray++
        }
    }
}