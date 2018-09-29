package PAT.advance;

import java.util.*;

public class ForwardsOnWeibo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int L = scanner.nextInt();
        Map<Integer,Follows> followsMap = new HashMap<>();
        for (int i = 1; i <= n; i++){
            Set<Integer> set = new HashSet<>();
            followsMap.put(i,new Follows(set));
        }

        for (int i = 1; i <= n; i++){
            int num = scanner.nextInt();
            for (int j = 0 ;j < num; j++){
                followsMap.get(scanner.nextInt()).follows.get(0).add(i);

            }
        }
        for(int l = 1; l < L; l++) {
            for (int i = 1; i <= n; i++) {
                calculateNextLayer(followsMap, l, i);
            }
        }
        int m = scanner.nextInt();
        for (int i = 0; i < m;i++){
            int index = scanner.nextInt();
            List<Set<Integer>> follows = followsMap.get(index).follows;
            Set<Integer> temp = new HashSet<>();
            for (int j =0; j< follows.size();j++){
                try {
                    temp.addAll(follows.get(j));
                }catch (Exception e){

                }
            }
            System.out.println(temp.size());
        }
    }

    private static void calculateNextLayer(Map<Integer,Follows> followsMap, int l, int num) {
        Follows follows = followsMap.get(num);
        Set<Integer> current = new HashSet<>(follows.follows.get(0));
        Iterator<Integer> cur = new HashSet<>(current).iterator();
        Set<Integer> c = new HashSet<>();
        while (cur.hasNext()) {
            try {
                c.addAll(followsMap.get(cur.next()).follows.get(l - 1));
            }catch (Exception e){

            }
        }
        c.remove(num);
        follows.follows.add(c);
    }

    static class Follows{
        List<Set<Integer>> follows = new ArrayList<>();
        public Follows(Set<Integer> follows) {
            this.follows.add(follows);
        }
    }
}
