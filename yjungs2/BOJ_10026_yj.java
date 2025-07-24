package yjungs2;

import java.util.Scanner;

// BOJ 10026 적록색약
public class BOJ_10026_yj {
    static int n;
    static char[][] gp;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        gp = new char[n][n];
        visited = new boolean[n][n];

        // 일반 사람이 보는 그림
        for(int i=0; i<n; i++){
            char[] charArr = sc.next().toCharArray();
            for(int j=0; j<n; j++) {
                gp[i][j] = charArr[j];
            }
        }
        int ans1 = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++) {
                if(!visited[i][j]){
                    rgb(i, j);
                    ans1 += 1;
                }
            }
        }

        // 적록색약이 보는 그림
        for(int i=0; i<n; i++){ 
            for(int j=0; j<n; j++) {
                if(gp[i][j]=='G') gp[i][j] = 'R';
                visited[i][j] = false;
            }
        }
        int ans2 = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++) {
                if(!visited[i][j]){
                    rgb(i, j);
                    ans2 += 1;
                }
            }
        }

        System.out.println(ans1+" "+ans2);
    }

    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    public static void rgb(int x, int y){
        visited[x][y] = true;
        char rgb = gp[x][y];
        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>=0 && nx<n && ny>=0 && ny<n) {
                if(!visited[nx][ny] && gp[nx][ny] == rgb)
                    rgb(nx, ny);
            }

        }
    }
}

class XY { // 큐에 ( , ) 쌍을 넣기 위해 만든 클래스
    int x;
    int y;
    public XY(int x, int y){
        this.x = x;
        this.y = y;
    }
}