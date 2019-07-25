package leetcode.hard.dp;

import java.util.*;

/*
* 缺陷是不能计算过长，需要之后再次看别人的算法，84题
*Given n non-negative integers representing the histogram's bar height where the width of
* each bar is 1, find the area of largest rectangle in the histogram.
* Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
* */
public class largestRectangleArea {
    public static void main(String[] args) {
    }

    // good solution
    public int largestRectangleArea(int[] heights) {
//        if(height == null || height.length == 0) return 0;
//        int len = height.length;
//        Stack<Integer> s = new Stack<Integer>();
//        int maxArea = 0;
//        for(int i = 0; i <= len; i++){
//            int h = (i == len ? 0 : height[i]);
//            if(s.isEmpty() || h >= height[s.peek()]){
//                s.push(i);
//            }else{
//                int tp = s.pop();
//                maxArea = Math.max(maxArea, height[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
//                i--;
//            }
//        }
//        return maxArea;
        List<Rectangle> areas =new ArrayList<>();
        int max = 0;
        for (int i = 0; i< heights.length;i++){
            Set<Rectangle> temp = new HashSet<>();
            if (areas.size()==0) {
                temp.add(new Rectangle(1,heights[i]));
                max = heights[0];
            }else {
                for (int j = 0; j < areas.size(); j++) {
                    Rectangle t = areas.get(j);
                    if (heights[i] <= t.height) {
                        temp.add(new Rectangle(t.width + 1, Math.min(heights[i], t.height)));
                        max = Math.max(max, (t.width + 1) * Math.min(heights[i], t.height));
                    }  else if (heights[i] > t.height) {
                        temp.add(new Rectangle(t.width + 1, Math.min(heights[i], t.height)));
                        max = Math.max(max, (t.width + 1) * Math.min(heights[i], t.height));
                        temp.add(new Rectangle(1, heights[i]));
                        max = Math.max(max, heights[i]);
                    } else if (t.height == 0) {
                        temp.add(new Rectangle(1, heights[i]));
                    } else if (heights[i] == 0) {
                        temp.add(new Rectangle(1, 0));
                    }
                }
            }
            areas = new ArrayList<>(temp);
        }
        return max;

    }
    class Rectangle {
        int height;
        int width;

        public Rectangle(int width, int height) {
            this.width = width;
            this.height = height;
        }

        @Override
        public boolean equals(Object o) {
            Rectangle rectangle = (Rectangle) o;
            return height == rectangle.height &&
                    width == rectangle.width;
        }

        @Override
        public int hashCode() {
            return Objects.hash(height, width);
        }
    }
}
