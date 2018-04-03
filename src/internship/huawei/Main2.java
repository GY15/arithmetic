package internship.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int money = Integer.parseInt(scanner.nextLine().trim());
        List<Commodity> commodities = new ArrayList<>();
        String[] moneys = scanner.nextLine().trim().split(" ");
        String[] coins = scanner.nextLine().trim().split(" ");
        for (int i = 0; i < moneys.length; i++) {
            commodities.add(new Commodity(i, moneys[i], coins[i]));
        }
        List<Integer> rank = new ArrayList<>();
        buyNext(commodities, money, -1, rank, 0);

        for (int i = 0; i < rankList.size(); i++) {
            System.out.print(rankList.get(i) + 1);
            if (i != rankList.size() - 1) {
                System.out.print(" ");
            }
        }

    }

    static List<Integer> rankList;
    static int maxCoin;

    public static void buyNext(List<Commodity> commodities, int leftMoney, int lastIndex, List<Integer> rank, int coin) {
        if (lastIndex == commodities.size() - 1) {
            compare(rank, coin);
        }
        boolean hasBuy = false;
        for (int i = lastIndex + 1; i < commodities.size(); i++) {
            if (leftMoney >= commodities.get(i).money) {
                hasBuy = true;
                List<Integer> rankList = new ArrayList<>(rank);
                rankList.add(i);
                buyNext(commodities, leftMoney - commodities.get(i).money, i, rankList, commodities.get(i).coin + coin);
            }
        }
        if (!hasBuy) {
            compare(rank, coin);
        }
    }

    static void compare(List<Integer> myList, int myCoin) {
        if (myCoin > maxCoin) {
            maxCoin = myCoin;
            rankList = myList;
        } else if (myCoin == maxCoin) {

        }
    }

    static class Commodity {
        int money;
        int coin;

        public Commodity(int i, String money, String coin) {
            this.money = Integer.parseInt(money);
            this.coin = Integer.parseInt(coin);
        }
    }
}
