package internship.wangyi;

import java.util.*;

public class MaxWages{
    public static void main(String[] args) {
        int n = 3;
        int m = 3;
        List<Wage> wages = new ArrayList<>();
        wages.add(new Wage(1,10));
        wages.add(new Wage(120,100));
        wages.add(new Wage(120,120));
        wages.add(new Wage(110,80));
        Collections.sort(wages, new Comparator<Wage>() {
            @Override
            public int compare(Wage o1, Wage o2) {
                if (o1.getAbility()<o2.ability){
                    return -1;
                }else if (o1.getAbility()==o2.getAbility()){
                    if(o1.wage < o2.wage){
                        return 1;
                    }else{
                        return -1;
                    }
                }else {
                    return 1;
                }
            }
        });
        int min = wages.get(0).wage;
        for (int i = 1;i < wages.size();i++){
            if (wages.get(i).wage<=min){
                wages.remove(i);
                i--;
            }else{
                min = wages.get(i).wage;
            }
        }
        for (int i = 0; i< m;i++){
            Scanner scanner = new Scanner(System.in);
            int myAbility = scanner.nextInt();
            for (int f = 0; f < wages.size()-1;f++){
                if(wages.get(f).ability > myAbility){
                    if(f==0) {
                        System.out.println(0);
                    }else {
                        System.out.println(wages.get(f - 1).wage);
                    }
                }else{
                    if(f==wages.size()-1){
                        System.out.println(wages.get(f).wage);
                    }
                }
            }
            System.out.println();
        }
    }

    static class Wage{
        int ability;
        int wage;

        public Wage(int ability, int wage) {
            this.ability = ability;
            this.wage = wage;
        }

        public int getAbility() {
            return ability;
        }

        public int getWage() {
            return wage;
        }
    }
}
