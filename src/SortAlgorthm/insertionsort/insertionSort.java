package SortAlgorthm.insertionsort;

public class insertionSort {


    public static int[]insertionSort(int[]array){

           for (int i = 1 ; i<array.length;i++){
               int  data = array[i] ;
               int j = i ;


               while (j > 0 && data< array[j-1]) {
                   int value = array[j];

                   //swap

                   array[j] = array[j-1];
                   array[j-1]=value ;
                   j--;

               }

           }
       return array  ;
    }


    public static void main(String args[])
    {

        int []arr = {4,7,1,5,3,2,6} ;
        int[] ints = insertionSort(arr);
        for (int i : ints){

            System.out.println(i);
        }


    }
}
