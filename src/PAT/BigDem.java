package PAT;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class BigDem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s[] = scanner.nextLine().split(" ");
        int n = Integer.parseInt(s[0]);
        if( n < 7){
            System.out.println(s[1]);
            System.out.println(n-1);
        }else {
            for (int i =2;;i++){
                if((i+1)*i*2-2*i-1>n){
                    print(i-1,s[1]);
                    i--;
                    System.out.println(n-((i+1)*i*2-2*i-1));
                    break;
                }
            }
        }
    }
    static void print(int layer,String s){
        for (int i = 0;i<layer;i++){
            for (int j = 0;j<i;j++){
                System.out.print(" ");
            }
            for (int j = 0;j < (layer-i)*2-1;j++){
                System.out.print(s);
            }
            System.out.println();
        }
        for (int i = 2;i<=layer;i++){
            for (int j = 0;j<layer-i;j++){
                System.out.print(" ");
            }
            for (int j = 0;j < (i)*2-1;j++){
                System.out.print(s);
            }
            System.out.println();
        }
    }
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        TreeMap map1 = new TreeMap<Character,Integer>();
//        TreeMap map2 = new TreeMap<Character,Integer>();
//        map1.put('C',0);
//        map1.put('J',0);
//        map1.put('B',0);
//        map2.put('C',0);
//        map2.put('J',0);
//        map2.put('B',0);
//        int n = scanner.nextInt();
//        scanner.nextLine();
//        int result[] = new int[3];
//        for (int i = 0;i < n; i++){
//            String s = scanner.nextLine();
//            char role1 = s.charAt(0);
//            char role2 = s.charAt(2);
//
//            if(role1==role2){
//                result[1]++;
//            }else if(win(role1,role2)){
//                int mm = (int) map1.get(role1);
//                mm++;
//                map1.put(role1,mm);
//                result[0]++;
//            }else{
//                int mm = (int) map2.get(role2);
//                mm++;
//                map2.put(role2,mm);
//                result[2]++;
//            }
//        }
//        System.out.println(result[0]+" "+result[1]+" "+result[2]);
//        System.out.println(result[2]+" "+result[1]+" "+result[0]);
//
//        print(map1);
//        System.out.print(" ");
//        print(map2);
//    }
//    static void print(TreeMap<Character,Integer> map1){
//        if((int)map1.get('B')>=(int)map1.get('C') && (int)map1.get('B')>=(int)map1.get('J')){
//            System.out.print('B');
//        }else{
//            if((int)map1.get('C')>=(int)map1.get('J')){
//                System.out.print('C');
//            }else{
//                System.out.print('J');
//            }
//        }
//    }
//
//    private static boolean win(char role1, char role2) {
//        if((role1=='B'&&role2=='C')||(role1=='C'&&role2=='J')||(role1=='J'&&role2=='B')){
//            return true;
//        }
//        return false;
//    }
//
//    static int calculate(String str, char l) {
//        int total = 0;
//        int pow = 1;
//        for (int i = 0; i < str.length(); i++) {
//            if (l == (str.charAt(i))) {
//                total += pow * (l - '0');
//                pow *= 10;
//            }
//        }
//        return total;
//    }

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        PriorityQueue<Student> A = new PriorityQueue<>();
//        PriorityQueue<Student> B = new PriorityQueue<>();
//        PriorityQueue<Student> C = new PriorityQueue<>();
//        PriorityQueue<Student> D = new PriorityQueue<>();
//        int min = scanner.nextInt();
//        int mid = scanner.nextInt();
//        for (int i = 0 ;  i < n; i++){
//            int number = scanner.nextInt();
//            int de = scanner.nextInt();
//            int cai = scanner.nextInt();
//            if(de < min || cai < min){
//                continue;
//            }else{
//                if(de >= mid&&cai>=mid){
//                    A.add(new Student(number,de,cai));
//                }else if(de>=mid){
//                    B.add(new Student(number,de,cai));
//                }else if(de>=cai){
//                    C.add(new Student(number,de,cai));
//                }else{
//                    D.add(new Student(number,de,cai));
//                }
//            }
//        }
//        System.out.println(A.size()+B.size()+C.size()+D.size());
//        while (A.size()!=0){
//            A.poll().print();
//        }
//        while (B.size()!=0){
//            B.poll().print();
//        }
//        while (C.size()!=0){
//            C.poll().print();
//        }
//        while (D.size()!=0){
//            D.poll().print();
//        }
//
//    }
//    static class Student implements Comparable{
//        int de,number,cai,total;
//        public Student(int number,int de, int cai){
//            super();
//            this.number = number;
//            this.cai = cai;
//            this.de = de;
//            this.total = de+cai;
//        }
//        public void print(){
//            System.out.println(this.number +" "+ this.de +" "+this.cai);
//        }
//        @Override
//        public int compareTo(Object o) {
//            Student s = (Student)o;
//            if(total == s.total){
//                if(s.de == this.de){
//                    return this.number-s.number;
//                }else{
//                    return s.de-this.de;
//                }
//            }else{
//                return s.total-this.total;
//            }
//        }
//    }
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int start = scanner.nextInt();
//        int end = scanner.nextInt();
//        int num = 1;
//        for(int i = 0; i < start; num++){
//            if(judgePrime(num)) {
//                i++;
//            }
//        }
//        for (int i = start; i <= end; num++){
//            if(judgePrime(num)) {
//                System.out.print(num);
//                if(i == end){
//                }else{
//                    if((i - start) % 10 == 9){
//                        System.out.println();
//                    }else{
//                        System.out.print(" ");
//                    }
//                }
//                i++;
//            }
//        }
//    }
//    private static boolean judgePrime(int num){
//        int max = (int)Math.pow(num,0.5);
//        for (int i = 2;i <= max;i++){
//            if(num % i==0){
//                return false;
//            }
//        }
//        return true;
//    }
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int a[] = new int[5];
//        boolean numOfA2 = true;
//        int numOfA4 = 0;
//        for (int i = 0; i < n; i++) {
//            int num = scanner.nextInt();
//            switch (num % 5){
//                case 0:
//                    if(num % 2 == 0){
//                        a[0] += num;
//                    }
//                    break;
//                case 1:
//                    a[1] += num*(numOfA2?1:-1);
//                    numOfA2 = !numOfA2;
//                    break;
//                case 2:
//                    a[2]++;
//                    break;
//                case 3:
//                    a[3]+=num;
//                    numOfA4++;
//                    break;
//                case 4:
//                    a[4] = Math.max(a[4],num);
//                    break;
//            }
//        }
//        for (int i = 0 ; i<5;i++){
//            if(i!=0){
//                System.out.print(" ");
//            }
//            if(a[i]==0){
//                System.out.print("N");
//            }else {
//                if (i == 3) {
//                    System.out.print((double)Math.round( a[3]*1.0/numOfA4*10)/10);
//                } else {
//                    System.out.print(a[i]);
//                }
//            }
//        }
//    }

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        scanner.nextLine();
//        for (int i = 0; i < n; i++){
//            String line = scanner.nextLine();
//            String nums[] = line.split(" ");
//            BigDecimal A = new BigDecimal(nums[0]);
//            BigDecimal B = new BigDecimal(nums[1]);
//            BigDecimal C = new BigDecimal(nums[2]);
//            System.out.print("Case #" + (i+1) +": ");
//            if(A.add(B).compareTo(C)>0){
//                System.out.println("true");
//            }else{
//                System.out.println("false");
//            }
//        }
//    }
}
