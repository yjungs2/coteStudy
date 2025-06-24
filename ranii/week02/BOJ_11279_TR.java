package ranii.week02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ_11279_TR {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();

        int N=Integer.parseInt(br.readLine());
        //0이 아닌값을 입력하면 큐에 넣고, 0을 입력하면 큐에서 가장 큰 값을 출력하면 됨 .
        PriorityQueue<Integer> q=new PriorityQueue<>(Collections.reverseOrder()); 
        //내림차순 정렬로 해서 큰값 빼는거임 
        for(int i=0;i<N;i++){
            int num=Integer.parseInt(br.readLine());
            if(num!=0){
                q.offer(num);
            }else{
                if(q.isEmpty()){
                    sb.append("0").append("\n");
                }else{
                    int max=q.poll();
                    sb.append(max).append("\n");
                }
            }
        }
       System.out.println(sb);
    }//main
}//class
