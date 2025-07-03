import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// BOJ 1325 효율적인 해킹
public class BOJ_1325_yj {
    static int n = 0;
    static ArrayList<Integer>[] gp;
    static boolean[] visited;
    static int[] com;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        gp = new ArrayList[n+1];
        for(int i=1; i<=n; i++) {
            gp[i] = new ArrayList<>();
        }
        for(int i=0; i<m; i++){
           st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // gp[b].add(a); // 상위 -> 하위 노드
            gp[a].add(b); // 하위 -> 상위 노드
        }

        com = new int[n+1];
        for(int i=1; i<=n; i++){
            visited = new boolean[n+1];
            // dfs(i); // dfs 는 시간초과
            bfs(i);
        }

        int max = Arrays.stream(com).max().getAsInt();
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++){
            if (com[i] == max) sb.append(i+" ");
        }
        System.out.print(sb.toString().trim());
        br.close();
    }

    /* 
    static void dfs(int index) {
        visited[index] = true;
        for(int c : gp[index]){
            if(!visited[c]){
                com[c]++;
                dfs(c);
            }
        }
    } */
   static void bfs(int index) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(index);
        visited[index] = true;
        while(!queue.isEmpty()){
            int n = queue.poll();
            for(int i: gp[n]){
                if(!visited[i]){
                    com[i]++;
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
   }
}