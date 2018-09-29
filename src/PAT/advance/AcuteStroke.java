package PAT.advance;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AcuteStroke {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        int N = scanner.nextInt();
        int L = scanner.nextInt();
        int T = scanner.nextInt();
        int[][][] cores = new int[L][M][N];
        int total = 0;
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    cores[i][j][k] = scanner.nextInt();
                }
            }
        }
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    if (cores[i][j][k] == 1) {
                        int local = dfs(cores, i, j, k, L, M, N);
                        if (local >= T){
                            total += local;
                        }
                    }
                }
            }
        }
        System.out.println(total);
    }
    static class Point{
        int i;
        int j;
        int k;
        Point(int i, int j, int k){
            this.i = i;
            this.j = j;
            this.k = k;
        }
    }
    private static int dfs(int[][][] cores, int i1, int j1, int k1, int L, int M, int N) {
        List<Point> points = new ArrayList<>();
        int local = 1;
        cores[i1][j1][k1] = 0;
        points.add(new Point(i1,j1,k1));
        while (points.size()!=0){
            Point point = points.get(0);
            points.remove(0);
            int i = point.i;
            int j = point.j;
            int k = point.k;
            if(i-1>=0 && cores[i-1][j][k] == 1){
                local++;
                cores[i-1][j][k]=0;
                points.add(new Point(i-1,j,k));
            }
            if(j-1>=0 && cores[i][j-1][k] == 1){
                local++;
                cores[i][j-1][k]=0;
                points.add(new Point(i,j-1,k));
            }
            if(k-1>=0 && cores[i][j][k-1] == 1){
                local++;
                cores[i][j][k-1]=0;
                points.add(new Point(i,j,k-1));
            }
            if(i+1 < L && cores[i+1][j][k] == 1){
                local++;
                cores[i+1][j][k]=0;
                points.add(new Point(i+1,j,k));
            }
            if(j+1 < M && cores[i][j+1][k] == 1){
                local++;
                cores[i][j+1][k]=0;
                points.add(new Point(i,j+1,k));
            }
            if(k+1 < N && cores[i][j][k+1] == 1){
                local++;
                cores[i][j][k+1]=0;
                points.add(new Point(i,j,k+1));
            }
        }
        return local;
    }
}
