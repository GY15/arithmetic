package leetcode.middle.graph;

import java.util.*;

public class MinimumHeightTrees {
    public static void main(String[] args) {
        new MinimumHeightTrees().findMinHeightTrees(
                11,
                new int[][]{{0,1},{0,2},{2,3},{0,4},{2,5},{5,6},{3,7},{6,8},{8,9},{9,10}}
        );    }
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<List<Integer>> myGraph = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        if (n==1) {
            res.add(0);
            return res;
        }
        int[] degree = new int[n];
        for(int i=0; i<n; i++) {
            myGraph.add(new ArrayList<>());
        }
        for(int i=0; i<edges.length; i++) {
            myGraph.get(edges[i][0]).add(edges[i][1]);
            myGraph.get(edges[i][1]).add(edges[i][0]);
            degree[edges[i][0]]++;
            degree[edges[i][1]]++;
        }
        List<Integer> list = new LinkedList<>();

        while (true){
            int numOfTwo = 0;
            int n2 = 0;
            for (int j = 0; j < n; j++){
                if (degree[j] == 1){
                    list.add(j);
                }else if (degree[j] >= 2){
                    numOfTwo++;
                    n2 = j;
                }
            }
            if (numOfTwo == 1){
                res.add(n2);
                return res;
            }else if (numOfTwo == 0 && list.size() ==2){
                return list;
            }
            while (list.size()!=0) {
                int curLeaf = list.remove(0);
                int root = myGraph.get(curLeaf).get(0);
                myGraph.get(root).remove(myGraph.get(root).indexOf(curLeaf));
                degree[curLeaf]--;
                degree[root]--;
            }

        }
    }
}
