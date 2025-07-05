package yjungs2.week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// BOJ 11725 트리의 부모 찾기
public class BOJ_11725_yj {
    static int n = 0; // 노드 개수
    static ArrayList<Integer>[] tree; // 트리 정보
    static boolean[] visited; // 방문 여부
    static int[] parent; // 노드의 부모 노드 저장
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n+1];
        visited = new boolean[n+1];
        parent = new int[n+1];
        for(int i=1; i<=n; i++) {
            tree[i] = new ArrayList<>();
        }

        for(int i=0; i<n-1; i++){
            String[] str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            tree[a].add(b);
            tree[b].add(a);
        }
        br.close();

        dfs(1); // 루트부터 내려가며 부모 노드를 저장
        for(int i=2; i<=n; i++) {
            System.out.println(parent[i]);
        }
    }

    static void dfs(int index){
        visited[index] = true;
        for(int i : tree[index]){
            if(!visited[i]) {
                parent[i] = index; // parent 배열에 부모 노드 저장
                dfs(i);
            }
        }
    }
}