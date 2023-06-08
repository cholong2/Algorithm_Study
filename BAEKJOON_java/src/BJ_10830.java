///*
//백준 : 행렬제곱
//start : 2023-06-02 2:30
//end :
// */
//import java.io.*;
//import java.util.*;
//class mat {
//    int exp;
//    int[][] matrix;
//}
//public class BJ_10830 {
//    private static int n, b, s;
//    private static int[][] a;
//
//    public static void main (String[] args) throws IOException {
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(bf.readLine());
//        n = Integer.parseInt(st.nextToken());
//        b = Integer.parseInt(st.nextToken());
//
//        a = new int [n][n];
//
//        for (int i = 0 ; i < n ; i++)
//        {
//            for (int j = 0 ; j < n ; j++)
//                a[i][j] = Integer.parseInt(st.nextToken(bf.readLine()));
//        }
//        s = 2;
//
//        while (b>0){
//            if (b %2 == 0)
//                matrix_pow(a, b);
//            else
//                matrix_mult(a);
//        }
//
//        for (int i = 0 ; i < n ; i++)
//            System.out.println(a[i]);
//    }
////    public static int[][] matrix_pow (int[][] mat, int exp){
////        int[][] result = new int[n][n];
////        if (exp == 2)
////            for (int i = 0 ; i < n; i ++){
////                for (int j = 0 ; j < n ; j++)
////                {
////
////                }
////            }
////            return result;
////        else
////            mat
////            return
////    }
//
////    public static int[][] matrix_mult (int[][] mat){
////
////    }
//}
