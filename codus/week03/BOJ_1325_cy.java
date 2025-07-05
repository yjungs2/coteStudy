package codus.week03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1325_cy {
    static int count[] = null;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer>[] list= new ArrayList[N+1];
        Queue<Integer> q = new LinkedList<>();
        
        count = new int[N+1];
        for(int i=1; i<N+1; i++){
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[b].add(a);
        }

        int max = 0;
        for(int i=1; i<N+1; i++){
            count[i] = BFS(i, list, q);

            max = Math.max(max, count[i]);
        }
        
        for(int i=0; i<N+1; i++){
            if(max == count[i]) sb.append(i + " ");
        }
        System.out.println(sb);
        
    }

    private static int BFS(int i, ArrayList<Integer>[] list, Queue<Integer> q) {
        boolean[] v = new boolean[list.length];
        v[i] = true; 
        int cnt = 0;
        q.offer(i);
        while(!q.isEmpty()){
            int node = q.poll();
            for(int num : list[node]){
                if(!v[num]){
                    v[num] = true;
                    cnt++;
                    q.offer(num);
                }
            }
        }
        return cnt;
    }
}
