import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// BOJ 2667 단지번호붙이기
public class BOJ_2667_yj {
    static int n;
    static int[][] gp;
    static int count;
    static ArrayList<Integer> ans = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        gp = new int[n][n];
        for(int i=0; i<n; i++) {
            String str = br.readLine();
            for(int j=0; j<n; j++){
                gp[i][j] = Integer.parseInt(str.substring(j, j+1));
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++){
                if(gp[i][j] == 1) {
                    count = 0;
                    DFS(i,j);
                    ans.add(count);
                }
            }
        }
        
        System.out.println(ans.size());
        ans.stream().sorted((a,b) -> a-b).forEach(i -> System.out.println(i));
    }

    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    static void DFS(int x, int y) {
        gp[x][y] = 0;
        count += 1;
        for(int i=0; i<4; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>=0 && nx<n && ny>=0 && ny<n){
                if(gp[nx][ny] == 1) {
                    DFS(nx, ny);
                }
            }
        }
    }
}