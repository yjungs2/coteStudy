package codus.week04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13549_cy {
    static int N,K;
    static boolean visit[];
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visit = new boolean[100001];
        
        bfs(N);
    }
    
    static void bfs(int start){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start, 0});
        visit[start]=true;
        
        while(!q.isEmpty()){
            int p[] = q.poll();
            if(p[0]==K){
                System.out.println(p[1]);
                return;
            }
            for(int i=0;i<3;i++){
                int next;
                int time;
                if(i==0){
                    next = p[0]*2;
                    time = p[1];
                }
                else if(i==1){
                    next = p[0]-1;
                    time = p[1]+1;
                }
                else{
                    next = p[0]+1;
                    time = p[1]+1;
                }
                
                if(0<=next && next<=100000 && !visit[next]){
                    q.add(new int[]{next,time});
                    visit[next]=true;
                }
            }
        }
    }
}
