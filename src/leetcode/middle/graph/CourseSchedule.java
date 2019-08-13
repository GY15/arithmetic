package leetcode.middle.graph;

import java.util.*;

public class CourseSchedule {
    public static void main(String[] args) {
        new CourseSchedule().canFinish(8,
               new int[][]{{1,0},{2,1},{3,2},{0,3},{7,0},{0,5}});
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];//tricky
        for(int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for(int[] pre : prerequisites) {
            graph[pre[1]].add(pre[0]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] finished = new boolean[numCourses];
        for(int i = 0; i < numCourses; i++) {
            if(!helper(graph, visited, finished, i)){
                return false;
            }
        }

        return true;
    }

    public boolean helper(ArrayList[] graph, boolean[] visited, boolean[] finished, int s) {
        if(finished[s]) {
            return true;
        } else if(visited[s]) {
            return false;
        } else {
            visited[s] = true;
        }

        for(int i=0; i<graph[s].size();i++){
            int adj = (int)graph[s].get(i);//tricky
            if(!helper(graph, visited, finished, adj)){
                return false;
            }
        }

        finished[s] = true;
        return true;
    }
}
