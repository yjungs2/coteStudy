package codus.week03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_2667_cy {
    public static int N = 0;
    public static int[][] list = null;
    public static boolean[][] visited = null;
    static ArrayList<Integer> answer = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new int[N][N];
        visited = new boolean[N][N];
        for(int i=0; i<N; i++){
            String line = br.readLine();
            for(int j=0; j<N; j++){
                list[i][j] = line.charAt(j)-'0';
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(list[i][j] == 1 && visited[i][j] == false){
                    visited[i][j] = true;
                    int count = DFS(i,j);
                    answer.add(count);
                }
            }
        }
        Collections.sort(answer);
        System.out.println(answer.size());
        for(int i : answer) System.out.println(i);
       
    }
    public static int DFS(int x, int y){
        int[] xx = {0,0,-1,1};
        int[] yy = {1,-1,0,0};
        int c = 1;
        for(int i=0; i<4; i++){
            int nx = x + xx[i];
            int ny = y + yy[i];
            if(nx >=0 && nx<N && ny >= 0 && ny < N){
                if(list[nx][ny] == 1 && visited[nx][ny] == false){
                    visited[nx][ny] = true;
                    c += DFS(nx,ny);
                }
            }
        }
        return c;
    }
}