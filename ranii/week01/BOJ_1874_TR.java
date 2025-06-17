package ranii.week01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
public class BOJ_1874_TR {
    public static void main(String[] args) throws Exception{
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    StringBuffer bf=new StringBuffer();
    int N=Integer.parseInt(br.readLine());
    Stack<Integer> stack=new Stack<>();
    boolean result=true; //stack 수열 가능한지 판별 여부 

    int start=1; //오름차순 수 
    
    for(int i=0;i<N;i++){ //N번 반복 
        int num = Integer.parseInt(br.readLine());
        while(start<=num){
            stack.push(start++);
            bf.append("+\n");
        }
        if(stack.peek()==num){
            stack.pop();
            bf.append("-\n");
        }else{
            result=false;
            break;
        }
    }
    if(!result){
        System.out.println("NO");
    }else{
        System.out.println(bf.toString());
    }
    }//main
}//class
