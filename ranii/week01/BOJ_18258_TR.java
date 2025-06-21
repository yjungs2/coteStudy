package ranii.week01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_18258_TR {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int N=Integer.parseInt(br.readLine());
        

        Queue<Integer> q=new LinkedList<>();

        for(int i=0;i<N;i++){
            String text = br.readLine();
            String[] tokens=text.split(" ");
            String command=tokens[0];
            // case 나누기
            // case 별 계산
            switch (command) {
                case "push":
                    int a=Integer.parseInt(tokens[tokens.length-1]);
                    q.add(a);
                    break;
                case "pop":
                    if(!q.isEmpty()){
                         sb.append(q.poll()+"\n");
                    }else{
                        sb.append("-1\n");
                    }
                   
                    break;
                case "size":
                    sb.append(q.size()+"\n");
                    break;
                case "empty":
                    boolean result=q.isEmpty();
                    if(!result){
                        sb.append("0\n");
                    }else{
                        sb.append("1\n");
                    }
                    break;
                case "front":
                    if(!q.isEmpty()){
                        sb.append(q.peek()+"\n");
                    }else{
                        sb.append("-1\n");
                    }
                    break;
                case "back":
                    if(!q.isEmpty()){
                        sb.append(((Deque<Integer>)q).peekLast()+"\n");
                    }else{
                        sb.append("-1\n");
                    }
                    break;
            } 
            
        }

        System.out.println(sb.toString());
    }
}
