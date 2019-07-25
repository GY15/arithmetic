package leetcode.hard;

public class TrappingRainWater {
    public static void main(String[] args) {
        System.out.println(new TrappingRainWater().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
    public int trap(int[] height) {
        if (height.length==0){
            return 0;
        }
        int start = 0;
        int end = height.length-1;
        int h1 = height[start];
        int h2 = height[end];

        int total = (end-start-1)*Math.min(h1,h2);
        while(start<end-1){
            if (h1<=h2){
                start++;
                int cur = height[start];
                if (cur<h1){
                    total-=cur;
                }else{
                    if (cur<=h2){
                        total=total-h1+Math.abs(cur-h1)*(end-start-1);
                    }else{
                        total=total-h1+Math.abs(h2-h1)*(end-start-1);
                    }
                    h1=cur;
                }
            }else{
                end--;
                int cur = height[end];
                if (cur<h2){
                    total-=cur;
                }else{
                    if (cur<=h1){
                        total=total-h2+Math.abs(cur-h2)*(end-start-1);
                    }else{
                        total=total-h2+Math.abs(h2-h1)*(end-start-1);
                    }
                    h2=cur;
                }
            }
        }
        return total;
    }
}
