package codus.week02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_10799_cy {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String text = br.readLine();
        Stack<Character> stack = new Stack<>();
        int answer = 0;

        for(int i=0; i<text.length(); i++){
            char t = text.charAt(i);
            if(i == 0){
                stack.push('(');
                continue;
            }else{
                if(t == ')' && text.charAt(i-1) == '('){
                    stack.pop();
                    answer += stack.size();
                }else if(t == ')' && text.charAt(i-1) == ')'){
                    stack.pop();
                    answer += 1;
                }
                if(t == '('){
                    stack.push(t);
                }
            }

            //System.out.println(stack);
            
        }

        System.out.println(answer);
    }

}
