package PAT;

import java.util.*;
import java.util.Scanner;
/*
   还有一种想法是，将分子分母分开计算，不用保存一个对象类
* */
public class RationCalculate {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String num[] = scanner.nextLine().split(" ");
        Ration ration1 = new Ration(num[0]);
        Ration ration2 = new Ration(num[1]);
        List<Ration> rations = ration1.operate(ration2);
        for (int i = 0; i < rations.size();i++){
            ration1.print();
            switch (i){
                case 0:
                    System.out.print(" + ");
                    break;
                case 1:
                    System.out.print(" - ");
                    break;
                case 2:
                    System.out.print(" * ");
                    break;
                case 3:
                    System.out.print(" / ");
                    break;
            }
            ration2.print();
            System.out.print(" = ");
            if(rations.get(i)!=null) {
                rations.get(i).print();
            }else{
                System.out.println("Inf");
            }
            System.out.println();
        }
    }

    static class Ration {
        boolean positive;
        int son;
        int mum;
        boolean zero;

        Ration(String num) {
            if (num.charAt(0) == '-') {
                positive = false;
                num = num.substring(1);
            } else {
                positive = true;
            }
            son = Integer.parseInt(num.split("/")[0]);
            if (son == 0) {
                zero = true;
            }
            mum = Integer.parseInt(num.split("/")[1]);
            if (zero == false) {
                simplify();
            }
        }

        public Ration(Ration ration) {
            this.zero = ration.zero;
            this.mum = ration.mum;
            this.positive = ration.positive;
            this.son = ration.son;
        }

        public Ration() {

        }

        public List<Ration> operate(Ration ration) {
            List<Ration> rations = new ArrayList<>();
            Ration add = new Ration(ration);
            Ration sub = new Ration(ration);

            int tempMum = ration.mum * this.mum;
            int tempSon = ration.son * this.mum + ration.mum * this.son;
            int tempSon2 = ration.mum * this.son - ration.son * this.mum;

            if(this.zero){
                sub.positive = !sub.positive;
            }else{
                if(this.positive){
                    if(!ration.positive){
                        add.mum = tempMum;
                        if(tempSon2 < 0){
                            add.positive = false;
                            add.son = -tempSon2;
                        }else{
                            add.positive = true;
                            add.son = tempSon2;
                        }
                        sub.mum = tempMum;
                        sub.son = tempSon;
                        sub.positive = true;
                    }else{
                        add.mum = tempMum;
                        add.son = tempSon;
                        if(tempSon2<0){
                            sub.son = -tempSon2;
                            sub.mum = tempMum;
                            sub.positive =false;
                        }else {
                            sub.son = tempSon2;
                            sub.mum = tempMum;
                            sub.positive = true;
                        }
                    }
                }else{
                    if(!ration.positive){
                        add.mum = tempMum;
                        add.son = tempSon;
                        add.positive = false;
                        sub.mum = tempMum;
                        sub.son = tempSon2;
                        sub.positive = false;
                    }else{
                        add.mum = tempMum;
                        sub.mum = tempMum;
                        if(tempSon2 < 0){
                            add.positive = true;
                            add.son = -tempSon2;
                        }else{
                            add.positive = false;
                            add.son = tempSon2;
                        }
                        sub.son = tempSon;
                        sub.positive = false;
                    }
                }
            }
            Ration multi = new Ration(ration);
            Ration div = new Ration(ration);
            if(ration.zero){
                div = null;
                multi.zero = true;
                multi.son = 0;
            }else{
                multi.mum = this.mum*ration.mum;
                div.mum = this.mum*ration.son;

                multi.son = this.son*ration.son;
                div.son = this.son*ration.mum;
            }
            if(this.positive&&ration.positive){

            }else if((!this.positive)&&(!ration.positive)){
                if(div!=null)
                div.positive = true;
                multi.positive =true;
            }else{
                if(div!=null)
                div.positive = false;
                multi.positive =false;
            }
            add.simplify();
            sub.simplify();
            multi.simplify();
            if(div!=null)
            div.simplify();

            rations.add(add);
            rations.add(sub);
            rations.add(multi);
            rations.add(div);
            return rations;
        }

        public void simplify() {
            if(son==0){
                zero = true;
            }else{
                zero = false;
            }
            int gcd = gcd(son, mum);
            son /= gcd;
            mum /= gcd;
        }

        private static int gcd(int a, int b) {
            int rem = 0;
            while (b != 0) {
                rem = a % b;
                a = b;
                b = rem;
            }
            return a;
        }

        public void print() {
            if (zero) {
                System.out.print("0");
            } else {
                if (positive) {
                    System.out.print(format());
                } else {
                    System.out.print("(-" + format() + ")");
                }
            }
        }

        public String format() {
            int integer;
            int numerator;
            integer = son / mum;
            numerator = son % mum;
            if (numerator == 0) {
                return "" + integer;
            } else {
                if (integer == 0) {
                    return numerator + "/" + mum;
                } else {
                    return integer + " " + numerator + "/" + mum;
                }
            }
        }
    }
}