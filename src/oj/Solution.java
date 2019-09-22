package oj;

import java.util.*;

public class Solution {
    public static void main(String[] args) {

        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(0);
        temp.add(3);
        lists.add(temp);

         temp = new ArrayList<>();
        temp.add(1);
        temp.add(2);
        lists.add(temp);

        new Solution().smallestStringWithSwaps( "dcab",lists);
    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if (pairs.size() == 0 || s.length() <= 1){
            return s;
        }
        char cs[] = s.toCharArray();
        Map<Integer,List<Integer>> map = new HashMap<>();
        for (int i = 0; i < pairs.size();i++){
            int min =pairs.get(i).get(0);
            int max = pairs.get(i).get(1);
            if (min == max){
                continue;
            }
            List<Integer> temp = map.getOrDefault(min,new ArrayList<>());
            temp.add(max);
            map.put(min,temp);
            temp = map.getOrDefault(max,new ArrayList<>());
            temp.add(min);
            map.put(max,temp);
        }

        Set<Integer> hasIn = new HashSet<>();


        for (int i = 0; i < cs.length; i++){
            if (!hasIn.contains(i)){
                Queue<Integer> indexs =new PriorityQueue<>();
                Queue<Character> characters =new PriorityQueue<>();

                TreeSet<Integer> needHandle = new TreeSet<>();
                needHandle.add(i);

                while (!needHandle.isEmpty()){
                    int cur = needHandle.pollFirst();
                    indexs.add(cur);
                    characters.add(cs[cur]);
                    hasIn.add(cur);
                    List<Integer> nexts = map.get(cur);
                    for (int j = 0; nexts != null && j < nexts.size();j++){
                        if (!hasIn.contains(nexts.get(j)) && !needHandle.contains(nexts.get(j))){
                            needHandle.add(nexts.get(j));
                        }
                    }
                }
                while (!indexs.isEmpty()){
                    cs[indexs.poll()] = characters.poll();
                }
            }
        }
        return String.valueOf(cs);
    }



    public int nthUglyNumber(int n, int a, int b, int c) {
        long cur = 0;
        long i2=1,i3=1,i5 = 1;
        long factory2 = a;
        long factory3 = b;
        long factory5 = c;
        for (int i = 0;i < n;i++){
            cur = Math.min(Math.min(factory2,factory3),factory5);
            if(cur == factory2){
                factory2 = a * (++i2);
            }
            if(cur == factory3){
                factory3 = b * (++i3);
            }
            if(cur == factory5){
                factory5 = c * (++i5);
            }
        }
        return (int)cur;
    }


    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        if (arr.length <= 1){
            return res;
        }
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++){
            if (arr[i] - arr[i-1] < min){
                List<Integer> temp = new ArrayList<>();
                temp.add(arr[i-1]);
                temp.add(arr[i]);
                min = arr[i] -arr[i-1];
                res = new ArrayList<>();
                res.add(temp);
            }else if(arr[i] - arr[i-1] == min) {
                List<Integer> temp = new ArrayList<>();
                temp.add(arr[i - 1]);
                temp.add(arr[i]);
                res.add(temp);
            }
        }
        return res;
    }
}
