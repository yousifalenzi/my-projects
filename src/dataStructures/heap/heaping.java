package dataStructures.heap;

public class heaping {

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


        int [] ar = {3,2,5,7,9,10,1,4,0,6,8};
        heaping h = new heaping();
        int[] ints = h.Heapfiy_Max(ar, (ar.length) / 2, (ar.length - 2) / 2);
        int [] heapsort = heapSort(ints);

        for (int i=0;i<heapsort.length-1;i++){
            System.out.print(heapsort[i]+",");
        }
    }
}
