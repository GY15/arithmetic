    package PAT;

    import java.util.*;

    public class DigitalBlack {
        public static void main(String[] args) {
            List<Integer> nums = new ArrayList<>();
            Scanner s = new Scanner(System.in);
            String line = s.nextLine();
            while (line.length()!=4){
                line +="0";
            }
            for (int i = 0; i < 4; i++){
                nums.add((int)(line.charAt(i)-'0'));
            }
            operate(nums);
        }
        public static void operate(List<Integer> operaters){
            List<Integer> num1 = new ArrayList<>(operaters);
            List<Integer> num2 = new ArrayList<>(operaters);
            Collections.sort(num1, (o1, o2) -> o2-o1);
            Collections.sort(num2, (o1, o2) -> o1-o2);
            List<Integer> nums = minus(num1,num2);
            if(judgeEqual(num1,num2)){
               print(num1,num1,toString(nums));
               return;
            }else{
                if(toInt(nums)==6174){
                    print(num1,num2,toString(nums));
                    return;
                }else{
                    print(num1,num2,toString(nums));
                   operate(nums);
                }
            }
        }


        static void print(List<Integer> num1, List<Integer> num2, String res){
            System.out.println(toString(num1)+" - "+toString(num2)+" = "+ res);
        }
        public static boolean judgeEqual(List<Integer> num1, List<Integer> num2){
            if (toInt(minus(num1,num2))==0){
                return true;
            } else {
                return false;
            }
        }
        public static List<Integer> minus(List<Integer> num1, List<Integer> num2){
            int res = toInt(num1)-toInt(num2);

            String s = res>=1000?(res+""):("0"+res);
            if(res==0){
                s="0000";
            }
            List<Integer> list = new ArrayList<>();
            for (int i = 0 ; i < 4;i++){
                list.add((int)(s.charAt(i)-'0'));
            }
            return list;
        }
        public static int toInt(List<Integer> nums){
            int res = 0;
            for (int i = 0 ; i < nums.size();i++){
                res += nums.get(i)*(Math.pow(10,(3-i)));
            }
            return res;
        }
        public static String toString(List<Integer> nums){
            String res = "";
            for (int i = 0 ; i < nums.size();i++){
                res += nums.get(i)+"";
            }
            return res;
        }
    }
