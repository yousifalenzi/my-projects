package dataStructures.heap;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Random;

public class heaping {


    int[] kLargest(int[] arr, int n, int k) {
        //PriorityQueue to build min heap
        PriorityQueue<Integer> numbers = new PriorityQueue<Integer>();

        //add data in heap
        for (int i =0 ; i<n;i++) {
            numbers.add((-1)*arr[i]);
        }

        int[] array = new int[k] ;
        int i = 0 ;

        if (k<=numbers.size()){

            while (!numbers.isEmpty()&&k>i){
                array[i]=numbers.poll()*(-1);
                i++;
            }
        }


      return array ;

    }




        int[] Heapfiy_Max(int[] arr, int n, int k) {

        int large =  k;
        int left = 2*k+1;
        int right = left+1;


        for (int i =k ; i>=0;i--){
            large = i;
            while (large<=n){
                left = 2*large+1;
                right =left+1;
                int pointer = large;

                if (left<=arr.length-1&&arr[left]>=arr[pointer]){
                   if (right>arr.length-1||arr[left]>=arr[right]){

                        large= left;
                    } else{
                        large=  right;
                    }

                }

                else if (right<=arr.length-1&&arr[right]>=arr[pointer]){
                   if (left>arr.length-1||arr[right]>=arr[left]){

                       large= right;
                    } else{
                       large= right;
                    }
                }
                else break;

                //swap

                int data = arr[pointer];
                arr[pointer] = arr[large];
                arr[large] = data;


            }
        }
        return arr ;
    }

    public static int [] heapSort(int [] arr){

        return sorting(arr) ;
    }
    private static int[] sorting(int[] arr) {

        for (int i =1;i<arr.length;i++){

            int remaining = (arr.length-1)-i;//3
            int currentPosition = 0;
            int lastItem =arr[remaining+1];

            //swap first element
            int item = arr[currentPosition];
            arr[remaining+1] = item;
            arr[currentPosition]=lastItem;

            //set child
            int leftchild =  1;
            int rightchild = 2;

            while (leftchild<=remaining||rightchild<=remaining){


                if (leftchild<=remaining&&rightchild<=remaining){
                    if (arr[leftchild]>arr[currentPosition]&&arr[leftchild]>arr[rightchild]){
                        currentPosition =   swap(arr,currentPosition,leftchild);
                    } else if(arr[rightchild]>arr[currentPosition]){
                        currentPosition = swap(arr,currentPosition,rightchild);
                    } else break;
                }



                // ----------------------------------//

                else {
                    if (leftchild<=remaining&&arr[leftchild]>arr[currentPosition]){
                        currentPosition =   swap(arr,currentPosition,leftchild);
                    } else if (rightchild<=remaining&&arr[rightchild]>arr[currentPosition]){
                        currentPosition =   swap(arr,currentPosition,rightchild);
                    } else break;
                }


                //set pair
                int [] pair = setChild(leftchild, currentPosition, rightchild);
                leftchild =  pair[0];
                rightchild = pair[1];
            }

        }

        return arr ;

    }
    private static int[] setChild(int left, int position, int right) {
        //set child
        int left1 = left;
        int right1 = right;
        left1 = 2 * position + 1;
        right1 = left1 + 1;
        return new int[] {left1,right1};
    }
    public static int swap(int [] arr ,int position,int newindex){

        int pos = position ;// 0
        int value = arr[pos];//7
        arr[pos] = arr[newindex];//[9,7,8,4,5,6,10]
        pos = newindex;
        arr[pos]=value;
        return pos;
    }


    public static void main (String [] args ){
          int [] arr1 = {1, 23, 12, 9, 30, 2, 50};

        heaping h = new heaping();
        int[] ints = h.kLargest(arr1, arr1.length, 3);

        for(int data : ints){
            System.out.print(data+", ");
        }

//        int [] ar = new int[10];
//
//        for (int i =0 ;i<ar.length;i++){
//            ar[i] =new Random().nextInt(100);
//        }
//
//
//        heaping h = new heaping();
//        int[] ints = h.Heapfiy_Max(ar, (ar.length) / 2, (ar.length - 2) / 2);
//        int [] heapsort = heapSort(ints);
//
//        for (int i=0;i<heapsort.length;i++){
//            System.out.print(heapsort[i]+",");
//        }
    }
}
