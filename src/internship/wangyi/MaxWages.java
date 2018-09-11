package internship.wangyi;

import java.util.*;

public class MaxWages{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        List<Wage> wages = new ArrayList<>();
      for (int i = 0; i < n;i++) {
          wages.add(new Wage(scanner.nextInt(), scanner.nextInt()));
      }
        Comparator<Wage> comparator = (w1,w2) -> {
            if(w1.getAbility()==w2.getAbility()){
                return w2.getWage()-w1.getWage();
            }
            return w1.ability-w2.ability;
        };
        wages.sort(comparator);
//        Collections.sort(wages,comparator);
//        Collections.sort(wages, new Comparator<Wage>() {
//            @Override
//            public int compare(Wage o1, Wage o2) {
//                if (o1.getAbility()<o2.ability){
//                    return -1;
//                }else if (o1.getAbility()==o2.getAbility()){
//                    if(o1.wage < o2.wage){
//                        return 1;
//                    }else{
//                        return -1;
//                    }
//                }else {
//                    return 1;
//                }
//            }
//        });
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
            int myAbility = scanner.nextInt();
            for (int f = 0; f < wages.size();f++){
                if(wages.get(f).ability > myAbility){
                    if(f==0) {
                        System.out.println(0);
                    }else {
                        System.out.println(wages.get(f - 1).wage);
                    }
                    break;
                }else{
                    if(f==wages.size()-1){
                        System.out.println(wages.get(f).wage);
                    }
                }
            }
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
