package codus.week02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_2504_cy {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        //)닫힐때 바로 전 스택 괄호에 [이 있으면 오류, ]전에 (있으면 오류
        String text = br.readLine();
        boolean isTrue = true;
        int value = 1;
        int result = 0;
        
        for(int i=0; i<text.length(); i++){
            char c = text.charAt(i);
            if(c == '('){
                stack.push('(');
                value *= 2;
            }else if(c == '['){
                stack.push('[');
                value *= 3;
            }else if(c == ')'){
                if(stack.isEmpty() || stack.peek() == '[' ){
                    isTrue = false;
                    break;
                }else if(text.charAt(i-1) == '('){
                    result += value;
                }
                stack.pop();
                value /= 2;
            }else if(c == ']'){
                if(stack.isEmpty() || stack.peek() == '(' ){
                    isTrue = false;
                    break;
                }else if(text.charAt(i-1) == '['){
                    result += value;
                }
                stack.pop();
                value /= 3;
            }
        }

        if(isTrue == true){
            System.out.println(result);
        }else{
            System.out.println("0");
        }

    }
}
