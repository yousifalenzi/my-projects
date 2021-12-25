package JustTry;

public class test {
     public static int fibonacciRecursion(int n){
         if (n<=1) return 1 ;
         else return fibonacciRecursion(n-1)+fibonacciRecursion(n-2) ;
     }
    public static int fact(int n){


         if(n<=1)return 1  ;
         else return n*fact(n-1) ;

    };

    public static String recursionName(String name){

        System.out.println(name);

        if(name.length()<=0)return null ;
        else return name+recursionName(String.valueOf(name.subSequence(0,name.length()-1))) ;

    };
    public static int power(int x,int n){


        if (n==0)return 1 ; // n=0 , x^0 = 1
        else if(n==1)return x ;//n=1 , x^1 = x
        else if(n%2==0)return power(x,n/2)*power(x,n/2) ;//we have even number
        else return x* power(x,n/2)*power(x,n/2) ;//we have odd number


    };

    public static int returnNumber(int n ){

        // base case
          if (n==1)return n;
        //recurrenece case
        else return returnNumber(n-1);

    }
    public static int SumRandom(int n){

        if (n==1) return 1+1 ;
        else return SumRandom(n-1)+n;
    }

    public static void main(String[] args){
        int y =fibonacciRecursion(5);
        System.out.println(y);




    }
    public static int  fact2(int i ){

        if (i==0||i==1) return 1 ;
        else return i*fact2(i-1) ;

    }
    private static void halfYou() {
        int c = 0 ;

        for(int i = 20 ; i>=1;i=i/2){
            for (int j = 1 ;j<=i;j++){

                c++ ;
            }
        }
    }
}
