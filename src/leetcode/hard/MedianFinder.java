package leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class MedianFinder {
   /* private Queue<Long> small = new PriorityQueue(),
            large = new PriorityQueue();

    public void addNum(int num) {
        large.add((long) num);
        small.add(-large.poll());
        if (large.size() < small.size())
            large.add(-small.poll());
    }

    public double findMedian() {
        return large.size() > small.size()
                ? large.peek()
                : (large.peek() - small.peek()) / 2.0;
    }
    */
    public static void main(String[] args) {
        MedianFinder m = new MedianFinder();

        m.addNum(12);
        m.addNum(10);
        m.addNum(13);
        m.addNum(11);
        m.addNum(5);
        m.addNum(15);
        m.addNum(1);
        m.addNum(11);
        m.addNum(6);
        m.addNum(17);
        m.addNum(14);
        m.addNum(8);
        m.addNum(17);
        m.addNum(6);
        m.addNum(4);
        m.addNum(16);
        m.addNum(8);
        m.addNum(10);
        m.addNum(2);
        m.addNum(12);
        m.addNum(0);
        System.out.println(m.findMedian());
    }
    List<Integer> list = new ArrayList<>();
    /** initialize your data structure here. */
    public MedianFinder() {

    }

    public void addNum(int num) {
        int begin = 0;
        int end = list.size();
        if (list.size()>0&&list.get(0)>num){
            list.add(0,num);
            return;
        }
        while(begin < end){
            int middle = (begin+end)/2;
            if(list.get(middle)==num){
                list.add(middle,num);
                return;
            }
            if(middle == list.size()-1){
                if(num > list.get(middle)){
                    list.add(middle+1,num);
                }else{
                    list.add(middle,num);
                }
                return;
            }else if(list.get(middle) < num && list.get(middle+1) > num){
                list.add(middle+1,num);
                return;
            }
            if(list.get(middle) > num){
                end = (begin+end)/2;
            }else{
                begin = middle+1;
            }
        }
        list.add(end,num);
    }

    public double findMedian() {
        if(list.size()%2==1){
            return list.get(list.size()/2);
        }else{
            return (list.get(list.size()/2)+list.get(list.size()/2-1))*1.0/2;
        }
    }
}

