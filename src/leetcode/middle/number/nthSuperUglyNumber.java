package leetcode.middle.number;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class nthSuperUglyNumber {
    class Element{
        int index;
        int curValue;
        int prime;
        Element(int curValue,int prime,int nextIndex){
            this.curValue = curValue;
            this.prime = prime;
            index = nextIndex;
        }
    }
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n == 1){
            return 1;
        }
        Queue<Element> queue = new PriorityQueue<>(new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                return o1.curValue - o2.curValue;
            }
        });
        int res[] = new int[n];
        res[0] = 1;
        for (int i = 0; i < primes.length; i++){
            queue.add(new Element(1, primes[i],0));
        }
        Element min;
        for (int i = 1;i < n; i++){
            min = queue.poll();
            while(min.curValue == res[i-1]){
                min.curValue = min.prime * res[min.index++];
                queue.offer(min);
                min = queue.poll();
            }
            res[i] = min.curValue;
            min.curValue = min.prime * res[min.index++];
            queue.offer(min);
        }
        return res[n-1];
    }

    public static void main(String[] args) {
        new nthSuperUglyNumber().nthSuperUglyNumber(12,new int[]{2,7,13,19});
    }
}
