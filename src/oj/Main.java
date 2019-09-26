package oj;

import java.util.*;

public class Main {


    static int minimumSwaps(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return 0;
        }
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(nums[i], i);
        }
        int[] sortedNums = Arrays.copyOf(nums, n);
        Arrays.sort(sortedNums);
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != sortedNums[i]) {
                int j = indexMap.get(sortedNums[i]);
                indexMap.put(sortedNums[i], indexMap.get(nums[i]));
                indexMap.put(nums[i], j);

                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                cnt++;
            }
        }
        return cnt;
    }





    public static int reversePairs(int[] nums) {
        int count = mergeSort(nums, 0, nums.length - 1);
        return count;
    }
    private static int mergeSort(int[] nums, int start, int end){
        if(start>=end){
            return 0;
        }
        int mid = (start + end) / 2;
        int count = mergeSort(nums, start, mid) + mergeSort(nums, mid+1, end);
        for(int i = start, j = mid+1; i<=mid; i++){
            while(j <= end && nums[i] > nums[j]) {
                j++;
            }
            count += j-(mid+1);
        }
        Arrays.sort(nums, start, end+1);
        return count;
    }




    private static void sortOccurrences(int[] nums, int[] orderArray,  Map<Integer,Integer> map) {
        if (nums.length == 1){
            System.out.println(nums[0]);
            return;
        }else if(nums.length == 0){
            System.out.println();
            return;
        }
        int index = nums.length-1;
        for (int i = nums.length - 1; i >= 0; i--){
            if (map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                nums[index--] = nums[i];
            }
        }
        int index2 = 0;
        for (int i = 0; i < orderArray.length; i++){
            int n = map.get(orderArray[i]);
            for (int j = 0; j < n; j++){
                nums[index2++] = orderArray[i];
            }
        }
        Arrays.sort(nums,index2,nums.length);
        StringBuilder sb = new StringBuilder();
        for (int i =0; i< nums.length;i++){
            sb.append(nums[i] +" ");
        }
        System.out.println(sb.toString().trim());
    }





    public static void sortWithFreq(int nums[]){
        TreeMap<Integer, TreeSet<Integer>> res = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        Map<Integer, Integer> counts = new TreeMap<>();
        for (int i = 0; i < nums.length; i++){
            int cur = counts.getOrDefault(nums[i],0);
            if(cur != 0){
                res.get(cur).remove(nums[i]);
            }
            counts.put(nums[i],++cur);
            TreeSet<Integer> set = res.getOrDefault(cur, new TreeSet<>());
            res.put(cur, set);
            set.add(nums[i]);
        }
        StringBuilder sb = new StringBuilder();
        for (int n : res.keySet()){
            TreeSet<Integer> set = res.get(n);
            while(!set.isEmpty()) {
                int num = set.pollFirst();
                for (int i = 0; i < n; i++) {
                    sb.append(num + " ");
                }
            }
        }
        System.out.println(sb.toString().trim());
    }
}