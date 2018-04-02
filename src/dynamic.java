import java.util.*;

public class dynamic {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int arr_i = 0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            int result = equal(arr);
            System.out.println(result);
        }
        in.close();
    }

    private static int equal(int[] arr) {
        Map<Integer,Integer> nums = new HashMap<>();
        nums.put(5,0);
        nums.put(3,0);
        nums.put(1,0);
        Arrays.sort(arr);
        int temp = arr[arr.length-1];
        add(nums,arr,0,temp);
        add(nums,arr,0,temp+1);
        add(nums,arr,0,temp+3);
        return min;
    }
    static int min = 10000000;
    private static void add(Map<Integer,Integer> maps, int[] arr, int index,int target){
        Map<Integer,Integer> temp = new HashMap<>(maps);
        Map<Integer,Integer> list = new HashMap<>(maps);
        int start = arr[index];
        int end = target;
        Map<Integer,Integer> temp2 =null;
        Map<Integer,Integer> list2 =null;
        boolean isDouble = false;
        while(start!=end){
            if(end-start > 7){
                int n = (end - start)/5;
                if((end - start)%5<=2){
                    n -= 1;
                }

                if(n >= temp.get(5)){
                    temp.put(5,0);
                    list.put(5,n);
                }else{
                    temp.put(5,temp.get(5)-n);
                }

                start+= n*5;
            }else{
                temp2 = new HashMap<>(temp);
                list2 = new HashMap<>(list);
                isDouble = false;
                switch (end-start){
                    case 7:
                        addNum(5,temp2,list2);
                        addNum(1,temp2,list2);
                        addNum(1,temp2,list2);

                        addNum(3,temp,list);
                        addNum(3,temp,list);
                        addNum(1,temp,list);

                        isDouble = true;
                        break;
                    case 6:
                       isDouble = true;
                        addNum(3,temp2,list2);
                        addNum(3,temp2,list2);

                        addNum(5,temp,list);
                        addNum(1,temp,list);
                        break;
                    case 5:
                        addNum(5,temp,list);
                        break;
                    case 4:
                        addNum(3,temp,list);
                        addNum(1,temp,list);
                        break;
                    case 3:
                        addNum(3,temp,list);
                        break;
                    case 2:
                        addNum(1,temp,list);
                        addNum(1,temp,list);
                        break;
                    case 1:
                        addNum(1,temp,list);
                        break;
                }
                break;
            }
        }
        if(index == arr.length-1||index>10){
            min = Math.min(min,maps.get(1)+maps.get(3)+maps.get(5));
        }else {
            if (isDouble) {
                add(list, arr, index + 1, target);
                add(list2, arr, index + 1, target);
            }else{
                add(list, arr, index + 1, target);
            }
        }
    }
    private static void addNum(int n, Map<Integer,Integer> temp,Map<Integer,Integer> list){
        if(temp.get(n)==0){
            list.put(n,list.get(n)+1);
        }else{
            temp.put(n,temp.get(n)-1);
        }
    }
}
