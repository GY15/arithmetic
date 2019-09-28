package leetcode.middle.arrays;

import java.util.*;

public class kSmallestPairs {
    public static void main(String[] args) {
        new kSmallestPairs().kSmallestPairs(new int[]{-1,-1,11},new int[]{-1,-1,6},9);
    }
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        TreeMap<Integer,Queue<Integer>> map = new TreeMap();
        List<List<Integer>> res = new ArrayList<>();
        if(nums2.length == 0|| nums1.length == 0){
            return res;
        }
        for(int i = 0; i < nums2.length; i++){
            Queue<Integer> queue = map.getOrDefault(nums2[i] + nums1[0],new LinkedList());
            queue.add(nums2[i]);
            queue.add(0);
            map.put(nums2[i] + nums1[0] ,queue);
        }

        Queue<Integer> queue;
        while(k > 0 && map.size()>0){
            queue = map.get(map.firstKey());
            List<Integer> temp = new ArrayList<>();
            int f = queue.poll();
            temp.add(map.firstKey() - f);
            temp.add(f);
            res.add(temp);
            int curIndex = queue.poll() + 1;
            if(queue.isEmpty()){
                map.pollFirstEntry();
            }
            if(curIndex < nums1.length){
                int key = f + nums1[curIndex];
                if(map.containsKey(key)){
                    map.get(key).add(f);
                    map.get(key).add(curIndex);
                }else{
                    Queue<Integer> q = new LinkedList<>();
                    q.offer(f);
                    q.offer(curIndex);
                    map.put(key,q);
                }
            }
            k--;
        }

        return res;
    }
}
