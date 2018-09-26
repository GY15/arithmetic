package PAT;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Tree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String num = scanner.nextLine();
        TreeMap<Character,Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < num.length();i++){
            char c = num.charAt(i);
            if(treeMap.get(c)==null){
                treeMap.put(c,1);
            }else{
                int n = treeMap.get(c);
                treeMap.put(c,++n);
            }
        }
        Iterator titer=treeMap.entrySet().iterator();
        while(titer.hasNext()){
            Map.Entry ent=(Map.Entry )titer.next();
            String keyt=ent.getKey().toString();
            String valuet=ent.getValue().toString();
            System.out.println(keyt+" : "+valuet);
        }
    }
}
