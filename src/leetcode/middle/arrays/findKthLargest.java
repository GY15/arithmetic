package leetcode.middle.arrays;

import java.util.PriorityQueue;
import java.util.Queue;

public class findKthLargest {
    public static void main(String[] args) {
        new findKthLargest().findKthLargest(new int[]{1,2,3,4,5,6,7,8,6,7,8,9},6);
    }
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++){

            if (queue.size() < k){
                queue.offer(nums[i]);
            }else if (nums[i] > queue.peek()){
                queue.poll();
                queue.offer(nums[i]);
            }
        }
        return queue.peek();
    }
}