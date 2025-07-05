package codus.week03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_11725_cy {
    static int parent[] = null;
    
    static boolean[] v = null;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        v = new boolean[N+1];
        parent = new int[N+1]; // 부모 정보를 담은 배열
        ArrayList<Integer>[] arr = new ArrayList[N+1];
        for(int i=1; i<N+1; i++){
            arr[i] = new ArrayList<>();
        }
        StringTokenizer st = null;
        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }
        v[1] = true;
        DFS(1, arr);
        for(int i=2; i<N+1; i++){
            System.out.println(parent[i]);
        }
    }

    private static void DFS(int num, ArrayList<Integer>[] arr){
        for(int n : arr[num]){
            if(v[n] == false){
                parent[n] = num; 
                v[n] = true;
                DFS(n, arr);
            }
        }
    }
}
