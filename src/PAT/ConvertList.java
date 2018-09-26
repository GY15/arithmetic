package PAT;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class ConvertList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start = scanner.nextInt();
        int n = scanner.nextInt();
        int k2 = scanner.nextInt();
        List<Item> list = new ArrayList<>();

        HashMap<Integer,Item> map = new HashMap<>();
        for (int i = 0; i < n; i++){
            Item item = new Item(scanner.nextInt(),scanner.nextInt(),scanner.nextInt());
            map.put(item.start,item);
        }
        while(start != -1){
            Item item  = map.get(start);
            list.add(item);
            start = item.end;
        }
        DecimalFormat df=new DecimalFormat("00000");
        for(int k =0;k<list.size();k+=k2) {
            for (int i = k - 1; i >= 0; i--) {
                Item item = list.get(i);
                if (i != k - 1) {
                    System.out.println(df.format(item.start));
                }
                System.out.print(df.format(item.start) + " " + item.node + " ");
            }
            int end = list.get(k-1).end;
            System.out.println(end==-1?-1:df.format(end));
        }


    }
    static class Item{
        int node;
        int start;
        int  end;

        public Item(int start, int node,  int end) {
            this.node = node;
            this.start = start;
            this.end = end;
        }

        public void print() {
            DecimalFormat df=new DecimalFormat("00000");

            System.out.println(df.format(start)+" " + node +" "+(end==-1?-1:df.format(end)));

        }
    }
}
