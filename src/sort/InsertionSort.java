package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by 61990 on 2017/10/7.
 */
public class InsertionSort {
//

//
//    public static void main(String[] args) {
//        long startTime=System.nanoTime();   //获取开始时间
//        Scanner in = new Scanner(System.in);
//        int n1 = in.nextInt();
//        for (int m = 0; m < n1; m++) {
//            int n = in.nextInt();
//            long temp = 0;
//            int arr[] = new int[n];
////            List<Integer> list = new ArrayList<>();
//            for (int i = 0; i < n; i++) {
//                arr[i] = in.nextInt();
//            }
//
//            if (arr[0] == n) {
//                long num = n;
//                System.out.println((num - 1) * num / 2);
//            } else {
//
//                int j;
//                for (int p = 1; p < arr.length; p++) {
//                    int t = arr[p];
//                    for (j = p; j > 0 && t < arr[j - 1]; j--) {
//                        arr[j] = arr[j - 1];
//                        temp++;
//                    }
//                    arr[j] = t;
//                }
//
//                System.out.println(temp);
//
//            }
//        }
////        Arrays.sort(arr);
//        long endTime=System.nanoTime(); //获取结束时间
//        System.out.println("程序运行时间： "+(endTime-startTime)/1000+"ns");
//    }
//
//}

    static long inversion = 0;

    private static void mergeArray(int[] data, int[] temp, int start, int mid, int end){
        int i = start, j =mid, p=start;
        while(i != mid || j!=end+1){
            if(j==end+1){
                temp[p] = data[i];
                p++;
                i++;
                continue;
            }
            if( i == mid){
                temp[p]=data[j];
                j++;
                p++;
                continue;
            }
            if(data[i] <= data[j]){
                temp[p] = data[i];
                i++;
                p++;
            }else{
                temp[p] = data[j];
                inversion += j-p;
                j++;
                p++;
            }
        }
        for (int i1 = start; i1 <= end;i1++){
            data[i1]=temp[i1];
        }

    }

    private static void mergeSort(int[] data, int[] buffer, int start, int end){
        if(start<end){
            int mid = (start+end)/2;
            mergeSort(data, buffer, start, mid);
            mergeSort(data, buffer, mid+1, end);
            mergeArray(data, buffer, start, mid+1, end);
        }
    }




    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=0; t<T; t++){
            int n = sc.nextInt();
            int data[] = new int[n];
            for(int i=0; i<n; i++) {
                data[i] = sc.nextInt();
            }
            int buffer[] = new int[data.length];
            mergeSort(data, buffer, 0, data.length-1);
            System.out.println(inversion);
            inversion = 0;//reset
        }
        sc.close();

    }
}



