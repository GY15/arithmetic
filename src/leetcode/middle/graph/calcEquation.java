package leetcode.middle.graph;

import java.util.*;

public class calcEquation {
    public static void main(String[] args) {
        List<List<String>> e = new ArrayList<>();
        List<String> t1 = new ArrayList<>();
        t1.add("a");
        t1.add("b");
        List<String> t2 = new ArrayList<>();
        t2.add("b");
        t2.add("c");
        e.add(t1);
        e.add(t2);
        double[] values = new double[2];
        values[0] = 2.0;
        values[1] = 3.0;
        List<List<String>> queries =new ArrayList<>();
        t1 = new ArrayList<>();
        t1.add("a");
        t1.add("c");
        queries.add(t1);
        t1 = new ArrayList<>();
        t1.add("b");
        t1.add("a");
        queries.add(t1);
        t1 = new ArrayList<>();
        t1.add("a");
        t1.add("e");
        queries.add(t1);
        t1 = new ArrayList<>();
        t1.add("x");
        t1.add("x");

        queries.add(t1);
        new calcEquation().calcEquation(e,values,queries);
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, ArrayList<String>> pairs = new HashMap<String, ArrayList<String>>();
        HashMap<String, ArrayList<Double>> valuesPair = new HashMap<String, ArrayList<Double>>();
        for(int i = 0; i < equations.size(); i++){
            String start = equations.get(i).get(0);
            String end = equations.get(i).get(1);
            double value = values[i];
            init(pairs,valuesPair,start,end,value);
            if(value != 0){
                init(pairs,valuesPair,end,start,1.0/value);
            }
        }
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
                res[i] = dfs(pairs, valuesPair, new HashSet<String>(), queries.get(i).get(0), queries.get(i).get(1));
        }
        return res;
    }

    private  double dfs(HashMap<String,ArrayList<String>> pairs,
                        HashMap<String,ArrayList<Double>> valuesPair, HashSet<String> set, String begin, String target){
        ArrayList<String> cur = pairs.get(begin);
        if (cur == null){
            return -1.0;
        }
        if (begin.equals(target)) {
            return  1.0;
        }
        set.add(begin);
        for (int i = 0; i < cur.size(); i++){
            if(set.contains(cur.get(i))){
                continue;
            }
            if(cur.get(i).equals(target)){
                return valuesPair.get(begin).get(i);
            }
            double temp =  dfs(pairs, valuesPair, set, cur.get(i), target);
            if(temp != -1.0){
                return temp*valuesPair.get(begin).get(i);
            }
        }
        return -1;
    }

    public void init(HashMap<String, ArrayList<String>> pairs, HashMap<String, ArrayList<Double>> valuesPair, String start, String end, double value){
        ArrayList<String> ts = pairs.get(start);
        ArrayList<Double> ds = valuesPair.get(start);
        if(ts==null){
            ts = new ArrayList<>();
            ts.add(end);
            pairs.put(start,ts);
            ds = new ArrayList<>();
            ds.add(value);
            valuesPair.put(start,ds);
        }else{
            ts.add(end);
            ds.add(value);
        }
    }
}
