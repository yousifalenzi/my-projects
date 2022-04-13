package SortAlgorthm.selectionSort;

public class selectionsort {


    public static int[]selectionSort(int[]array){

          for (int i =0 ; i<array.length;i++){
              int min = i ;
              for (int j = i+1;j<array.length;j++){

                  if (array[j]<array[min]){

                      min=j ;
                  }
              }
              int tem = array[i];
              array[i]=array[min];
              array[min]= tem ;
          }

       return array ;
    }
    public static void main(String args[])
    {

        int []arr = {4,7,1,5,3,2,6} ;
        int[] ints = selectionSort(arr);
        for (int i : ints){

            System.out.println(i);
        }


    }
}
