package leetcode.middle.arrays;

import java.util.ArrayList;
import java.util.List;

public class MergeIntervals {
/*
    Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

    You may assume that the intervals were initially sorted according to their start times.

    Example 1:

    Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
    Output: [[1,5],[6,9]]

    先把所有的数组按第一个数字排序，然后再进行比较
*/

    public static void main(String[] args) {
        new MergeIntervals().merge(new int[][]{{1, 3}, {2, 4}, {6, 8}, {9, 10}, {10, 11}});
    }
    //先把所有的
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            initList(list, intervals[i]);
        }
        for (int i = 0; i < list.size()-1; i++){
            if (list.get(i)[1] >= list.get(i+1)[0]){
                if (list.get(i)[1] > list.get(i+1)[1]){
                    list.remove(i+1);
                    i--;
                }else{
                    list.get(i)[1] = list.get(i+1)[1];
                    list.remove(i+1);
                    i--;
                }
            }
        }

        int res[][] = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
                res[i] = list.get(i);
        }
        return res;
    }

    private void initList(List<int[]> list, int[] interval) {
        if (list.size() == 0) {
            list.add(interval);
        } else {
            if (list.get(0)[0] > interval[0]) {
                list.add(0, interval);
            } else if (list.get(list.size() - 1)[0] < interval[0]) {
                list.add(interval);
            } else {
                int left = 0;
                int right = list.size();
                while (true) {
                    int index = (right + left) / 2;
                    if (list.get(index)[0] == interval[0]) {
                        if (list.get(index)[1] < interval[1]) {
                            list.get(index)[1] = interval[1];
                        }
                        break;
                    }
                    if (list.get(index)[0] < interval[0]) {
                        if (list.get(index + 1)[0] > interval[0]) {
                            list.add(index + 1, interval);
                            break;
                        } else {
                            left = index;
                        }
                    } else {
                        right = index;
                    }
                }
            }
        }
    }

    public int[][] merge2(int[][] intervals) {
        int current = 0;
        if (intervals.length <= 1) {
            return intervals;
        }
        int length = 1;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= intervals[current][1]) {
                intervals[current][1] = intervals[i][1];
                intervals[i][0] = intervals[i][1];
            } else {
                length++;
                current = i;
            }
        }
        int res[][] = new int[length][2];
        int c = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] != intervals[i][1]) {
                res[c] = intervals[i];
                c++;
            }
        }
        return res;
    }
}
