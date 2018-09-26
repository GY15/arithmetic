package PAT;

import java.util.*;

public class Mooncake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int total = scanner.nextInt();
        List<Cake> cakes = new LinkedList<>();
        int stocks[] = new int[n];
        for (int i = 0; i < n;i++){
            stocks[i]=scanner.nextInt();
        }
        for (int i = 0; i < n; i++){
            cakes.add(new Cake(stocks[i],scanner.nextInt()));
        }
        Collections.sort(cakes, new Comparator<Cake>() {
            @Override
            public int compare(Cake o2, Cake o1) {
                if(o1.unitPrice-o2.unitPrice > 0){
                    return 1;
                }else if(o1.unitPrice - o2.unitPrice ==0){
                    return 0;
                }
                return -1;
            }
        });
        double price = 0;
        for (int i = 0; total!=0 && i < n; i++){
            Cake cake = cakes.get(i);
            if(cake.stock > total){
                price += total*cake.unitPrice;
                total = 0;
            }else{
                total -= cake.stock;
                price += cake.price;
            }
        }
        System.out.println(String.format("%.2f",price));
    }
    static class Cake{
          int stock;
          int price;
          double unitPrice;
          Cake(int stock, int price){
              this.price = price;
              this.stock = stock;
              this.unitPrice = price*1.0/stock;
          }
    }
}
