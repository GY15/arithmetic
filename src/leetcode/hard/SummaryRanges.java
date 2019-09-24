package leetcode.hard;

import java.util.*;

public class SummaryRanges {

    public static void main(String[] args) {
        SummaryRanges s = new SummaryRanges();
        s.addNum(1);
        s.addNum(3);
        s.addNum(4);
        s.addNum(2);
        s.getIntervals();
    }

    TreeMap<Integer,Integer> map;
    TreeSet<Integer> res;
    /** Initialize your data structure here. */
    public SummaryRanges() {
        map = new TreeMap<>();
        res = new TreeSet<>();
    }

    public void addNum(int val) {
        if (!map.containsKey(val)){
            map.put(val,1);
            res.add(val);
            if (map.containsKey(val+1)){
                int n = map.get(val + 1);
                map.put(val, 1 + n);
                map.put(val + n, 1 + n);

                res.remove(val + 1);
            }
            if (map.containsKey(val-1)){
                int n = map.get(val - 1);
                int temp = map.get(val) + n;
                map.put(val - n, temp);
                map.put(val + map.get(val) - 1, temp);
                res.remove(val);
            }
        }
    }

    public int[][] getIntervals() {
        int[][] intervals = new int[res.size()][2];
        int i = 0;
        for (int key : res) {
            intervals[i][0] = key;
            intervals[i++][1] = key - 1 + map.get(key);
        }
        return intervals;
    }
}
