package leetcode.middle.list;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int begin = 0;
        int cur = -1;
        int end = 0;
        int leftGas = 0;
        while(cur== -1||begin != end){
            if (cur==-1){
                cur = 0;
            }
            leftGas += gas[cur] - cost[cur];
            if (leftGas < 0){
                begin--;
                if (begin == -1){
                    begin = gas.length-1;
                }
                cur = begin;
            }else{
                end++;
                if (end == gas.length){
                    end = 0;
                }
                cur = end;
            }
        }
        if (leftGas>=0){
            return begin;
        }else{
            return -1;
        }
    }

    public static void main(String[] args) {
        new GasStation().canCompleteCircuit(new int[]{1,2,3,4,5},new int[]{3,4,5,1,2});
    }
}
