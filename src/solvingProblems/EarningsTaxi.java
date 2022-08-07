package solvingProblems;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class EarningsTaxi {



        public static long maxTaxiEarnings(int n, int[][] rides) {
            List<Pair<Integer, Integer>>[] startToEndAndEarns = new List[n];
            // dp[i] := max dollars you can earn starting at i
            long[] dp = new long[n + 1];

            for (int i = 1; i < n; ++i)
                startToEndAndEarns[i] = new ArrayList<>();

            for (int[] ride : rides) {
                final int start = ride[0];
                final int end = ride[1];
                final int tip = ride[2];
                final int earn = end - start + tip;
                startToEndAndEarns[start].add(new Pair<>(end, earn));
            }

            for (int i = n - 1; i >= 1; --i) {//10
                dp[i] = dp[i + 1]; //dp[10] = dp[11]
                for (Pair pair : startToEndAndEarns[i]) {
                    final int end = (int) pair.getKey();
                    final int earn = (int) pair.getValue();
                    dp[i] = Math.max(dp[i], dp[end] + earn);
                }
            }

            return dp[1];
        }




    public static void main(String args[]){



              int[][] rides = new int[9][3] ;


        rides[0][0]=1 ;//start
        rides[0][1]=3 ;//end
        rides[0][2]=3 ;//tip


        rides[1][0]=2;
        rides[1][1]=4;
        rides[1][2]=6;


        rides[2][0]=2;
        rides[2][1]=5;
        rides[2][2]=3;

        rides[3][0]=3;
        rides[3][1]=5;
        rides[3][2]=9;

        rides[4][0]=4;
        rides[4][1]=6;
        rides[4][2]=3;

        rides[5][0]=5;
        rides[5][1]=6;
        rides[5][2]=11;

        rides[6][0]=6;
        rides[6][1]=7;
        rides[6][2]=2;

        rides[7][0]=7;
        rides[7][1]=8;
        rides[7][2]=5;

        rides[8][0]=9;
        rides[8][1]=10;
        rides[8][2]=13;


        maxTaxiEarnings(10,rides);


    }}
