package PAT.advance;
import java.lang.reflect.Array;
import java.util.*;

public class BinarySearchTree {
    static Map<Integer,Node> map;
    static int numbers[];
    static int index =0;
    public static void main(String[] args) {
        map = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++){
            map.put(i,new Node(scanner.nextInt(),scanner.nextInt()));
        }
        numbers = new int[n];
        for (int i = 0; i < numbers.length;i++){
            numbers[i] = scanner.nextInt();
        }
        Arrays.sort(numbers);
        setValue(0);
        List<Integer> list = new LinkedList<>();
        list.add(0);
        while(list.size()!=0){
            int node = list.get(0);
            if(map.get(node).left!=-1){
                list.add(map.get(node).left);
            }
            if(map.get(node).right!=-1){
                list.add(map.get(node).right);
            }
            if(node!=0){
                System.out.print(" ");
            }
            System.out.print(map.get(node).value);
            list.remove(0);
        }
  }
    public static void setValue(int node){
        if(map.get(node).left!=-1){
            setValue(map.get(node).left);
        }
        map.get(node).value = numbers[index];
        index++;
        if(map.get(node).right!=-1){
            setValue(map.get(node).right);
        }
    }
    static class Node {
        int  left;
        int right;
        int value;
        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
}
