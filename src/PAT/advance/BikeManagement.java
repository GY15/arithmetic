package PAT.advance;

import java.util.*;

public class BikeManagement {
    static List<Station> stations = new LinkedList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int fullNumber = scanner.nextInt();
        int stationNums = scanner.nextInt();
        int problemStation = scanner.nextInt();
        int roadNums = scanner.nextInt();
        scanner.nextLine();

        stations.add(new Station(0, 0));
        //init the matrix and station
        for (int i = 0; i < stationNums; i++) {
            int bike = scanner.nextInt();
            stations.add(new Station(i + 1, bike));
        }
        scanner.nextLine();
        stationNums++;
        Element matrix[][] = new Element[stationNums][stationNums];
        for (int i = 0; i < roadNums; i++) {
            String line[] = scanner.nextLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            int distance = Integer.parseInt(line[2]);
            matrix[x][y] = new Element(-1, distance);
            matrix[y][x] = new Element(-1, distance);
        }

        for (int i = 1; i < stationNums; i++) {  //对于每一个中转点
            for (int j = 0; j < stationNums; j++) {
                for (int k = j + 1; k < stationNums; k++) {
                    if (matrix[j][i] != null && matrix[i][k] != null &&j!=i &&j!=k) {
                        int newDistance = matrix[j][i].distance + matrix[i][k].distance;
                        if (matrix[j][k] == null) {
                            matrix[j][k] = new Element(i, newDistance);
                            matrix[k][j] = new Element(i, newDistance);
                        } else {
                            matrix[j][k].addElement(newDistance, i);
                            matrix[k][j].addElement(newDistance, i);
                        }
                    }
                }
            }
        }

        List<Integer> res = matrix[0][problemStation].agencys;
        List<Plan> plans = new ArrayList<>();
        List<Plan> result = new ArrayList<>();

        for (int i = 0; i < res.size();i++){
            plans.add(new Plan(res.get(i),0, problemStation));
        }
        resolvePath(plans,matrix);
        Collections.sort(plans, new Comparator<Plan>() {
            @Override
            public int compare(Plan o1, Plan o2) {
                return Math.abs(getOutBike(o1,fullNumber)) - Math.abs(getOutBike(o2,fullNumber));
            }
        });
        int bike = getBike(plans.get(0),fullNumber);
        int max = getOutBike(plans.get(0),fullNumber);
        if(bike<0){
            System.out.print((max)+" 0");
            for (int i = 1; i< plans.get(0).stations.size();i++){
                System.out.print("->" + plans.get(0).stations.get(i).num);
            }
            System.out.print(" "+ (max+bike));
        }else{
            System.out.print(max+ " 0");
            for (int i = 1; i< plans.get(0).stations.size();i++){
                System.out.print("->"+ plans.get(0).stations.get(i).num );
            }
            System.out.print(" "+ (bike+max));
        }
    }
    static int getBike(Plan o1, int fullNumber){
        return o1.bikes - (o1.stations.size()-1)*(fullNumber/2);
    }
    static int getOutBike(Plan plan,int fullNumber){
        int half = fullNumber/2;
        List<Station> stations = plan.stations;
        int max = 0;
        int bikes = 0;
        for(int i = 1; i < stations.size(); i++){
            bikes+=half - stations.get(i).bikes;
            max = Math.max(bikes,max);
        }
        return max;
    }
    static void resolvePath(List<Plan> plans, Element[][] matrix){
        for (int i = 0; i < plans.size();i++){
            List<Station> stationsTemp =  plans.get(i).stations;
            boolean finish = true;
            for (int j = 0; j < stationsTemp.size()-1;j++){
                List<Integer> agencies = matrix[stationsTemp.get(j).num][stationsTemp.get(j+1).num].agencys;
                for (int k = 0; k < agencies.size();k++){
                    if(agencies.get(k) != -1){
                        Plan planTemp =  plans.get(i);
                        planTemp.stations.add(j+1,stations.get(agencies.get(k)));
                        planTemp.bikes += stations.get(agencies.get(k)).bikes;
                        plans.add(planTemp);
                        finish = false;
                    }
                }
                if(finish==false){
                    plans.remove(i);
                    i--;
                    break;
                }
            }
        }
    }
    //所有满足最短路径的 路径
    static class Plan{
        List<Station> stations;
        int bikes;
        Plan(int midStation,int begin, int problemStation){
            stations = new ArrayList<>();
            bikes=0;

            addStation(begin);
            if(midStation!=-1) {
                addStation(midStation);
            }
            addStation(problemStation);
        }
        private void addStation(int index){
            stations.add( BikeManagement.stations.get(index));
            bikes+=  BikeManagement.stations.get(index).bikes;
        }
    }

    static class Station {
        int num;
        int bikes;

        public Station(int num, int bikes) {
            this.num = num;
            this.bikes = bikes;
        }
    }

    static class Element {
        List<Integer> agencys;
        int distance;

        public Element(int agency, int distance) {
            if (this.agencys == null) {
                this.agencys = new LinkedList<>();
            }
            this.agencys.add(agency);
            this.distance = distance;
        }

        public void addElement(int newDistance, int i) {
            if (newDistance == this.distance) {
                this.agencys.add(i);
            } else if (newDistance < this.distance) {
                this.agencys =new LinkedList<>();
                this.distance = newDistance;
                this.agencys.add(i);
            }
        }
    }
}
