package leetcode.middle.sort;

import java.util.Objects;
import java.util.TreeSet;

public class kthSmallest {
    public static void main(String[] args) {
        String s  ="";

    }
    public int kthSmallest(int[][] matrix, int k) {
        TreeSet<Tuple> treeSet = new TreeSet<>();
        treeSet.add(new Tuple(0,0,matrix[0][0]));
        int res = 0;
        while (k > 0){
            Tuple next = treeSet.pollFirst();
            res = next.val;
            if(next.x + 1 < matrix.length){
                treeSet.add(new Tuple(next.x+1,next.y,matrix[next.x+1][next.y]));
            }
            if(next.y + 1 < matrix[0].length){
                treeSet.add(new Tuple(next.x,next.y+1,matrix[next.x][next.y+1]));
            }
            k--;
        }
        return res;
    }
    class Tuple implements Comparable<Tuple> {
        int x;
        int y;
        int val;
        public Tuple(int x, int y, int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }





        @Override
        public int compareTo(Tuple o) {
            if (this.val == o.val){
                if(this.x == o.x){
                    return this.y - o.y;
                }
                return this.x - o.x;
            }
            return this.val - o.val;
        }
    }
}
