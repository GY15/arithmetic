package leetcode.hard;

public class SelfCrossing {
    public static void main(String[] args) {
        new SelfCrossing().isSelfCrossing(new int[]{1,1,3,2,1,1});
    }
    public boolean isSelfCrossing(int[] x) {
        if (x.length < 4){
            return true;
        }
        int x1 = 0,y1 = 0,x2 = 0 ,y2 = x[0],x3 = - x[1],y3 = y2,  x4 = x3, y4 = x[0] - x[2];
        int nextX = x[3]-x[1];
        int nextY = y4;
        int lastPoint = 0;
        boolean firstOut = nextX >= 0;
        for (int i = 4; i <= x.length;i++){
            switch (i % 4){
                case 0:
                    if(nextX >= x1 && nextY >= y1){
                        return true;
                    }
                    if (i == x.length){
                        return false;
                    }
                    if (firstOut) {
                        if (nextX <= x1 ){
                            firstOut = false;
                            if(nextX >= lastPoint) {
                                y2 = y1;
                                y3 = y1;
                            }
                        }
                    }
                    lastPoint = y1;
                    x1 = nextX;
                    y1 = nextY;
                    nextY += x[i];
                    break;
                case 1:
                    if(nextX <= x2 && nextY >= y2){
                        return true;
                    }
                    if (i == x.length){
                        return false;
                    }
                    if (firstOut) {
                        if (nextY <= y2 ){
                            firstOut = false;
                            if(nextY >= lastPoint) {
                                x3 = x2;
                                x4 = x2;
                            }
                        }
                    }
                    lastPoint = x2;
                    x2 = nextX;
                    y2 = nextY;
                    nextX -= x[i];
                    break;
                case 2:
                    if(nextX <= x3 && nextY <= y3){
                        return true;
                    }
                    if (i == x.length){
                        return false;
                    }
                    if (firstOut) {
                        if (nextX >= x3){
                            firstOut = false;
                            if(nextX <= lastPoint) {
                                y4 = y3;
                                y1 = y3;
                            }
                        }
                    }
                    lastPoint = y3;
                    x3 = nextX;
                    y3 = nextY;
                    nextY -= x[i];
                    break;
                case 3:
                    if(nextX >= x4 && nextY <= y4){
                        return true;
                    }
                    if (i == x.length){
                        return false;
                    }
                    if (firstOut) {
                        if (nextY >= y4){
                            firstOut = false;
                            if(nextY <= lastPoint) {
                                x1 = x4;
                                x2 = x4;
                            }
                        }
                    }
                    lastPoint = x4;
                    x4 = nextX;
                    y4 = nextY;
                    nextX += x[i];
                    break;
            }
        }
        return false;
    }
}
