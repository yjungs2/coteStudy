package yjungs2.week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// BOJ 10799 쇠막대기
public class BOJ_10799_yj {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        String str = br.readLine();
        int cnt = 0;

        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);

            if (c=='('){
                stack.push('(');
            } else {
                stack.pop();
                if(str.charAt(i-1)=='(') { // () -> 레이저일 때
                    cnt += stack.size(); // 스택에 들어있는 막대기 수만큼 잘림
                } else {
                    cnt += 1; // 막대기의 끝
                }
            }
        }
        System.out.println(cnt);
    }
}