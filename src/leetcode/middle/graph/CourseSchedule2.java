package leetcode.middle.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule2 {
    //210
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] degree = new int[numCourses];
        int[][] matrix = new int[numCourses][numCourses];
        int res[] = new int[numCourses];
        int index = 0;
        for(int i = 0; i < prerequisites.length;i++){
            if (matrix[prerequisites[i][1]][prerequisites[i][0]] == 0) {
                degree[prerequisites[i][0]]++;
            }
            matrix[prerequisites[i][1]][prerequisites[i][0]] = 1;
        }
        Queue<Integer> queue= new LinkedList<>();
        for (int i = 0; i < degree.length; i++){
            if (degree[i] == 0){
                queue.offer(i);
                res[index++] = i;
            }
        }
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for (int i = 0; i < matrix.length;i++){
                if (matrix[cur][i] == 1){
                    if (--degree[i] == 0) {
                        queue.offer(i);
                        res[index++] = i;
                    }
                }
            }
        }
        return index == res.length ? res:new int[]{};
    }

    public static void main(String[] args) {
        new CourseSchedule2().findOrder(5,new int[][]{{0,1}});
    }
}
