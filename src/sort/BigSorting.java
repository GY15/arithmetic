package sort;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by 61990 on 2017/10/11.
 */
public class BigSorting {

        public static void main(String[] args){
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            BigDecimal [] unsorted = new BigDecimal[n];
            StringBuffer buffer[]= new StringBuffer[n];
            int num[] = new int[n];
            int len = 0;
            for(int unsorted_i=0; unsorted_i < n; unsorted_i++){
                String str = in.next();
                if(str.length()>40){
                    buffer[unsorted_i] = new StringBuffer(str);
                    unsorted[unsorted_i] = new BigDecimal("0");
                    len++;
                }else {
                    unsorted[unsorted_i] = new BigDecimal(str);
                }
            }
            String b[] = new String[len];
            String b1[] = new String[len];
            int n2[] = new int[len];

            for (int i = 0,j=0 ; i<n; i++){
                if(buffer[i]!=null){
                    b[j] = buffer[i].toString();
                    n2[j] = b[j].length();
                    j++;
                }
            }
            int buff[] = new int[len];
            if(len!=0) {
                mergeSort(n2, buff, b, b1, 0, len - 1);
            }
            Arrays.sort(unsorted);
            Arrays.sort(num);
            for(int i = 0; i < n; i++ ) {
                if (!unsorted[i].toString().equals("0"))
                {       System.out.println(unsorted[i]);
                }
            }
            for (int i = 0;i<len;i++){
                System.out.println(b[i]);
            }
        }

        private static void mergeArray(int[] data, int[] temp,String [] words, String[] buffers, int start, int mid, int end){
        int i = start, j =mid, p=start;
        while(i != mid || j!=end+1){
            if(j==end+1){
                temp[p] = data[i];
                buffers[p]=words[i];
                p++;
                i++;
                continue;
            }
            if( i == mid){
                temp[p]=data[j];
                buffers[p]=words[j];
                j++;
                p++;
                continue;
            }
            if(data[i] <= data[j]){
                temp[p] = data[i];
                buffers[p]=words[i];
                i++;
                p++;
            }else{
                temp[p] = data[j];
                buffers[p]=words[j];

                j++;
                p++;
            }
        }
        for (int i1 = start; i1 <= end;i1++){
            data[i1]=temp[i1];
            words[i1]=buffers[i1];
        }

    }

    private static void mergeSort(int[] data, int[] buffer,String [] words, String[] buffers, int start, int end){
        if(start<end){
            int mid = (start+end)/2;
            mergeSort(data, buffer,words,buffers, start, mid);
            mergeSort(data, buffer, words,buffers ,mid+1, end);
            mergeArray(data, buffer, words,buffers ,start, mid+1, end);
        }
        return ;
    }

}