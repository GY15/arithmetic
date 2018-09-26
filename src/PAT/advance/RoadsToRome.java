package PAT.advance;

import java.util.*;

public class RoadsToRome {
    static List<City> cities = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] strs = scanner.nextLine().split(" ");
        int cityNum = Integer.parseInt(strs[0]);
        int roadNum = Integer.parseInt(strs[1]);

        Map<String,Integer> cityMap = new HashMap<>();
        cityMap.put(strs[2],0);
        cities.add(new City(strs[2],0,0));
        for (int i = 1; i < cityNum; i++){
            strs = scanner.nextLine().split(" ");
            cities.add(new City(strs[0],i,Integer.parseInt(strs[1])));
            cityMap.put(strs[0],i);
        }
        int matrix[][] = new int[cityNum][cityNum];
        for (int i = 0; i < roadNum; i++){
            strs = scanner.nextLine().split(" ");
            matrix[cityMap.get(strs[0])][cityMap.get(strs[1])] = Integer.parseInt(strs[2]);
            matrix[cityMap.get(strs[1])][cityMap.get(strs[0])] = Integer.parseInt(strs[2]);
        }

        Element[] elements = new Element[cityNum];
        List<Integer> visited = new ArrayList<>();
        visited.add(0);
        List<Integer> notVisited = new ArrayList<>();
        for (int i = 0; i < cityNum;i++){
            elements[i] = new Element();
        }
        for (int i = 1; i< cityNum;i++){
            notVisited.add(i);
            if (matrix[0][i] != 0){
                elements[i].lastCity.add(0);
                elements[i].distance = matrix[0][i];
            }
        }
        while(notVisited.size()!=0){
            int nextCityNum = findNextCity(visited,notVisited,matrix);
            visited.add(nextCityNum);
            for (int i = 0; i < notVisited.size(); i++){
                if (notVisited.get(i) == nextCityNum){
                    notVisited.remove(i);
                    break;
                }
            }
            for (int i = 1 ; i < cityNum;i++){
                if(elements[nextCityNum].distance < 100000  && matrix[nextCityNum][i]!=0 ){
                    if(elements[nextCityNum].distance + matrix[nextCityNum][i] < elements[i].distance) {
                        elements[i].distance = elements[nextCityNum].distance + matrix[nextCityNum][i];
                        elements[i].lastCity = new ArrayList<>();
                        elements[i].lastCity.add(nextCityNum);
                    }else if(elements[nextCityNum].distance + matrix[nextCityNum][i] == elements[i].distance){
                        elements[i].lastCity.add(nextCityNum);
                    }
                }
            }
        }
        List<Plan> plans = new ArrayList<>();
        plans.add(new Plan(cities.get(cityMap.get("ROM"))));
        generate(plans,elements);
        Collections.sort(plans, new Comparator<Plan>() {
            @Override
            public int compare(Plan o1, Plan o2) {
                if(o1.happiness == o2.happiness){
                     return o2.average-o1.average;
                }else{
                    return o2.happiness-o1.happiness;
                }
            }
        });
        System.out.println(plans.size()+" " + elements[cityMap.get("ROM")].distance+" "+plans.get(0).happiness+" "+ plans.get(0).average);
        System.out.print(cities.get(0).name);
        for (int i = plans.get(0).cityNames.size()-2;i>=0;i--){
            System.out.print("->"+plans.get(0).cityNames.get(i));
        }
    }

    private static void generate(List<Plan> plans, Element[] elements) {
        for (int i = 0; i < plans.size();i++){
            List<Integer> citys = plans.get(i).citys;
            int last = citys.get(citys.size()-1);
            if(last==0){
            }else {
                List<Integer> lastCities = elements[last].lastCity;
                for (int j = 0; j < lastCities.size(); j++) {
                    Plan temp = new Plan(plans.get(i));
                    temp.addCity(cities.get(lastCities.get(j)));
                    plans.add(temp);
                }
                plans.remove(i);
                i--;
            }
        }
    }


    private static int findNextCity(List<Integer> visited,List<Integer> notVisited, int[][] matrix) {
        int minDistance = Integer.MAX_VALUE;
        int nextCity = 0;
        for (int i = 0; i < visited.size();i++){
            int begin = visited.get(i);
            for (int j = 0; j < notVisited.size();j++){
                int end = notVisited.get(j);
                if(matrix[begin][end] != 0 && matrix[begin][end] < minDistance){
                    nextCity = end;
                    minDistance = matrix[begin][end];
                }
            }
        }
        return nextCity;

    }

}
class Element{
    List<Integer> lastCity;
    int distance;
    Element(){
        this.lastCity = new ArrayList<>();
        this.distance = 1000000;
    }
}
class City{
    int number;
    String name;
    int happiness;

    public City(String name,int number, int happiness) {
        this.number = number;
        this.name = name;
        this.happiness = happiness;
    }
}
class Plan{
    List<Integer> citys;
    List<String> cityNames;
    int happiness;
    int average;

    public Plan(City city) {
        citys =new ArrayList<>();
        citys.add(city.number);
        cityNames = new ArrayList<>();
        cityNames.add(city.name);
        happiness = city.happiness;
        average = happiness;
    }

    public Plan(Plan plan) {
        this.citys= new ArrayList<>(plan.citys);
        this.cityNames= new ArrayList<>(plan.cityNames);
        this.happiness= plan.happiness;
        this.average= plan.average;
    }

    public void addCity(City city){
        cityNames.add(city.name);
        citys.add(city.number);
        happiness+=city.happiness;
        if(citys.size()>=2)
        average = happiness/(citys.size()-1);
    }

}