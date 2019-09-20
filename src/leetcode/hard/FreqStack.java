package leetcode.hard;

import java.util.*;

public class FreqStack {
    public static void main(String[] args) {
        FreqStack s = new FreqStack();
        s.push(4);
        s.push(6);
        s.push(4);
        s.push(6);
        s.push(3);
        s.push(4);
        s.pop();
        s.pop();
        s.pop();
        s.pop();
    }
    List<List<Integer>> lists;
    Map<Integer,Integer> map;

    public FreqStack() {
        lists = new LinkedList<>();
        map = new HashMap<>();
    }
    public void push(int x) {
        int cur = map.getOrDefault(x,0)+ 1;
        map.put(x, cur);
        if(lists.size() < cur){
            List<Integer> list =new LinkedList();
            list.add(x);
            lists.add(list);
        }else{
            lists.get(cur-1).add(x);
        }
    }

    public int pop() {
        List<Integer> resList = lists.get(lists.size()-1);
        int res = resList.remove(resList.size()-1);
        map.put(res, map.get(res)-1);
        if(resList.size() == 0){
            lists.remove(lists.size()-1);
        }
        return res;
    }
}