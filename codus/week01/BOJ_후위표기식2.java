package codus.week01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_후위표기식2 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //피연산자의 개수
        String text = br.readLine(); //후위식
        //char [] t = text.toCharArray();
        int num[] = new int[N]; //A -> num[0] B -> num[1] ...
        for(int i=0; i<N; i++){
            num[i] = Integer.parseInt(br.readLine());
        }
        Stack<Double> stack = new Stack<>();
        int idx = 0;
        double a = 0.0;
        double b = 0.0;
        double result = 0.0;
        while(idx != text.length()){ //A ~ Z
            char c = text.charAt(idx);
            if('A' <=c && c <= 'Z'){
                stack.push((double)num[c - 65]);
            }else{ // + - * / 
                switch(text.charAt(idx)){
                    case '+' : 
                        a = stack.pop();
                        b = stack.pop();
                        result = a + b;
                        stack.push(result);
                        break;
                    case '-' :
                        a = stack.pop();
                        b = stack.pop();
                        result = b - a;
                        stack.push(result);
                        break;
                    case '/' : 
                        a = stack.pop();
                        b = stack.pop();
                        result = b / a;
                        stack.push(result);
                        break;
                    case '*' :
                        a = stack.pop();
                        b = stack.pop();
                        result = a * b;
                        stack.push(result);
                        break;
                }

            }
            idx++;
        }

        System.out.printf("%.2f", stack.pop());	

    }
}
