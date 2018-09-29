package PAT.advance;

import java.util.*;

public class CarsOnCampus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        Map<String,List<Status>> map = new HashMap<>();
        for (int i = 0; i < n; i++){
            String[] strs = scanner.nextLine().split(" ");
            if (map.get(strs[0]) == null){
                List<Status> list = new ArrayList<>();
                list.add(new Status(strs[1], strs[2]));
                map.put(strs[0],list);
            }else{
                map.get(strs[0]).add(new Status(strs[1], strs[2]));
            }
        }

        List<String> nameList = new ArrayList<>();
        int maxTime = 0;
        for (String plate : map.keySet()) {
            List<Status> value = map.get(plate);
            Collections.sort(value, new Comparator<Status>() {
                @Override
                public int compare(Status o1, Status o2) {
                    return o1.time-o2.time;
                }
            });
            boolean lastIsIn = false;
            for (int i = 0; i < value.size();i++){
                if(lastIsIn == false){
                    if(value.get(i).isIn){
                        lastIsIn = true;
                    }else{
                        value.remove(i);
                        i--;
                    }
                }else{
                    if(value.get(i).isIn){
                        i--;
                        value.remove(i);
                    }else{
                        lastIsIn =false;
                    }
                }
            }
            if(value.size()!=0) {
                if (value.get(value.size() - 1).isIn) {
                    value.remove(value.size() - 1);
                }
            }

            for (int j = 0; j < value.size(); j+=2){
                int tt = value.get(j+1).time-value.get(j).time;
                if(tt == maxTime){
                    nameList.add(plate);
                }else if(tt>maxTime){
                    nameList = new ArrayList<>();
                    maxTime = tt;
                    nameList.add(plate);
                }
            }
        }


        for (int i = 0; i < m; i++){
            int numOfParking = 0;
            String strs[] = scanner.nextLine().split(":");
            int time = Integer.parseInt(strs[0])*3600+Integer.parseInt(strs[1])*60+Integer.parseInt(strs[2]);
            for (String s : map.keySet()){
               List<Status> list = map.get(s);
               for (int j = 0;j < list.size();j+=2){
                   if(time >= list.get(j).time && time < list.get(j+1).time){
                       numOfParking++;
                   }
               }
            }
            System.out.println(numOfParking);
        }
        for (int i = 0; i < nameList.size();i++){
            System.out.print(nameList.get(i)+" ");
        }
        int hh = maxTime/3600;
        int mm = (maxTime - hh*3600)/60;
        int ss = maxTime -  hh*3600 - mm*60;
        System.out.println(hh+":"+mm+":"+ss);
    }

    static class Status {
        int time;
        boolean isIn;
        Status(String time, String state){
            String t[] = time.split(":");
            this.time = Integer.parseInt(t[0])*3600+Integer.parseInt(t[1])*60+Integer.parseInt(t[2]);
            if(state.equals("in")){
                isIn = true;
            }else {
                isIn = false;
            }
        }
    }
}
