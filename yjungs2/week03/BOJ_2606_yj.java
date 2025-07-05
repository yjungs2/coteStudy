package yjungs2.week03;

import java.util.Scanner;

// BOJ 2606 바이러스
public class BOJ_2606_yj {
    static int[][] gp;
    static boolean[] visited;
    static int count = 0;
    static int node = 0;
    static int line = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        node = sc.nextInt();
        line = sc.nextInt();
        gp = new int[node+1][node+1];
        visited = new boolean[node+1]; // false 가 default

        for(int i=0; i<line; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            gp[a][b] = 1;
            gp[b][a] = 1;
        }
        sc.close();

        dfs(1);
        System.out.println(count-1); // 1번 컴퓨터를 통해 바이러스에 걸리게 되는 컴퓨터 수 (1번 제외)
    }

    public static void dfs(int start) {
        visited[start] = true;
        count++;
        
        for(int i=1; i<node+1; i++){
            if(gp[start][i] == 1 && !visited[i]){ // visited[i]==false
                dfs(i);
            }
        }
    }
}