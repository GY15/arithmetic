package PAT.advance;

import java.text.DecimalFormat;
import java.util.*;

public class DeduplicationList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int begin = scanner.nextInt();
        int n = scanner.nextInt();
        Map<Integer, Item> maps = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int lastItem = scanner.nextInt();
            maps.put(lastItem, new Item(lastItem, scanner.nextInt(), scanner.nextInt()));
        }
        DecimalFormat df = new DecimalFormat("00000");
        Item temp = maps.get(begin);
        StringBuffer existedString = new StringBuffer();
        Set<Integer> set = new HashSet<>();
        int i = 0;
        while (true) {
            if(!set.add(temp.abs)){
                if (i != 0) {
                    existedString.append(df.format(temp.lastItem)+"\n");
                }
                i++;
                existedString.append(df.format(temp.lastItem) + " " + temp.point + " ");
            } else {
                if (temp.lastItem != begin) {
                    System.out.println(df.format(temp.lastItem));
                }
                System.out.print(df.format(temp.lastItem) + " " + temp.point + " ");
            }
            if (temp.nextItem == -1) {
                break;
            }
            temp = maps.get(temp.nextItem);
        }
        System.out.println(-1);

        System.out.print(existedString+"-1");
    }

    static class Item {
        int lastItem;
        int point;
        int abs;
        int nextItem;

        Item(int lastItem, int point, int nextItem) {
            this.lastItem = lastItem;
            this.point = point;
            this.abs = Math.abs(point);
            this.nextItem = nextItem;
        }
    }
}
