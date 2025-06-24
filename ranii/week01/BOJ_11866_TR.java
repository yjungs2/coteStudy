package ranii.week01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11866_TR {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        StringBuilder sb= new StringBuilder();
        Queue<Integer> q=new LinkedList<>();
        int N=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());
        //K번 꺼내고 K-1까지 다시 넣어 
        sb.append("<");
        for(int i=1;i<N+1;i++){
            //N번 반복 해서 큐에 값 저장 
            q.offer(i);
        }
        while(!q.isEmpty()){
            for(int i=0;i<K-1;i++){
                q.offer(q.remove());
            }
            int num=q.remove();
            sb.append(num);
            if(q.isEmpty()){
                sb.append(">");
            }else{
                sb.append(", ");
            }
        }
        System.out.println(sb);
    }
}
