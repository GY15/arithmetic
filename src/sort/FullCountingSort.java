package sort;

import java.util.Scanner;

/**
 * Created by 61990 on 2017/10/7.
 * 20
 0 ab
 6 cd
 0 ef
 6 gh
 4 ij
 0 ab
 6 cd
 0 ef
 6 gh
 0 ij
 4 that
 3 be
 0 to
 1 be
 5 question
 1 or
 2 not
 4 is
 2 to
 4 the
 */
public class FullCountingSort {

//
//    private static void mergeArray(int[] data, int[] temp,String [] words, String[] buffers, int start, int mid, int end){
//        int i = start, j =mid, p=start;
//        while(i != mid || j!=end+1){
//            if(j==end+1){
//                temp[p] = data[i];
//                buffers[p]=words[i];
//                p++;
//                i++;
//                continue;
//            }
//            if( i == mid){
//                temp[p]=data[j];
//                buffers[p]=words[j];
//                j++;
//                p++;
//                continue;
//            }
//            if(data[i] <= data[j]){
//                temp[p] = data[i];
//                buffers[p]=words[i];
//                i++;
//                p++;
//            }else{
//                temp[p] = data[j];
//                buffers[p]=words[j];
//
//                j++;
//                p++;
//            }
//        }
//        for (int i1 = start; i1 <= end;i1++){
//            data[i1]=temp[i1];
//            words[i1]=buffers[i1];
//        }
//
//    }
//
//    private static void mergeSort(int[] data, int[] buffer,String [] words, String[] buffers, int start, int end){
//        if(start<end){
//            int mid = (start+end)/2;
//            mergeSort(data, buffer,words,buffers, start, mid);
//            mergeSort(data, buffer, words,buffers ,mid+1, end);
//            mergeArray(data, buffer, words,buffers ,start, mid+1, end);
//        }
//        return ;
//    }
//
//
//
//
//    public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//            int n = sc.nextInt();
//            int data[] = new int[n];
//            String  words[] = new String[n];
//            String buffers[ ]= new String[n];
//            for(int i=0; i<n; i++) {
//                data[i] = sc.nextInt();
//                words[i] = sc.nextLine();
//            }
//            int buffer[] = new int[data.length];
//            mergeSort(data, buffer, words,buffers,0, data.length-1);
//            for (int i = 0;i < n;i++){
//
//                        System.out.println(data[i]+words[i]);
//
//            }
////            System.out.println(inversion);
////            inversion = 0;//reset
//        sc.close();
//    }
    public static void main(String[] args)
    {
//        用StringBuffer输出比遍历输出快的多，直接进入输出流中

        Scanner scan=new Scanner(System.in);
        int size=Integer.parseInt(scan.nextLine());
        StringBuffer[] st=new StringBuffer[100];

        for(int i=0;i<100;i++)
        {
            st[i]=new StringBuffer();
        }

        for(int i=0;i<size;i++)
        {
            String sts=scan.nextLine();
            String[] str=sts.split("[\\s]+");
            int k=Integer.parseInt(str[0]);
            String s;
            if(i<size/2)
                s="- ";
            else
                s=str[1]+" ";
            st[k]=st[k].append(s);
        }

        for(int i=0;i<100;i++)
        {
            System.out.print(st[i]);
        }
    }
}



