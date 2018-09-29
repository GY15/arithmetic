package PAT.advance;

import java.util.Map;
import java.util.*;

public class LargestGeneration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        Map<Integer,List<Integer>> maps = new HashMap<>();
        for (int i = 0; i < M; i++){
            int num =  scanner.nextInt();
            List<Integer> list = new ArrayList<>();
            int n = scanner.nextInt();
            for (int j = 0; j < n; j++){
                list.add(scanner.nextInt());
            }
            maps.put(num, list);
        }
        List<Integer> list = new LinkedList<>();
        list.add(1);
        List<Integer> generation = new ArrayList<>();
        generation.add(1);
        while (true) {
            List<Integer> newGeneration = new ArrayList<>();
            for (int i = 0; i < list.size();i++){
                List<Integer> temps = maps.get(list.get(i));
                if(temps!=null){
                    newGeneration.addAll(temps);
                }
            }
            generation.add(newGeneration.size());
            list = newGeneration;
            if(list.size()==0){
                break;
            }
        }
        int maxIndex = 0;
        int max = 0;
        for (int k = 0; k < generation.size();k++){
            if(generation.get(k) > max){
                maxIndex = k+1;
                max = generation.get(k);
            }
        }
        System.out.println(maxIndex+" "+max);
    }
}
