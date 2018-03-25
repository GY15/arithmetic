package sort;

import java.util.*;

public class SortedName {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        List<String> list = new ArrayList<>();
        Map<String,Boolean> map = new HashMap<>();
        for (int i = 0; i < n;i++){
            String line = in.nextLine();
            if(line.split("@")[1].equals("gmail.com")){
                insert(list,line.split(" ")[0],map,line.split(" ")[1]);
            }
        }
        for (String str:list){
            System.out.println(str);
        }
    }

    private static void insert(List<String> list,String str,Map<String,Boolean> map, String str2){
        if (map.get(str2)==null){
            map.put(str2,true);
        }else if (map.get(str2)){
            return;
        }
        if (list.size()==0){
            list.add(str);
        }
        else if(list.get(list.size()-1).compareTo(str)<0){
            list.add(str);
        }else {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).compareTo(str)>=0) {
                    list.add(i, str);
                    break;
                }
            }
        }
    }

}
