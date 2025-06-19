package yjungs2.week02;

import java.util.Scanner;
import java.util.Stack;
import java.util.HashMap;

// BOJ 1935 후위 표기식2
public class BOJ_1935_yj {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        
        HashMap<Character, Integer> nums = new HashMap<>();
        int ascii = 65;
        for(int i=0; i<n; i++){
            nums.put((char)ascii, sc.nextInt());
            ascii ++;
        } // System.out.println(nums); 영대문자에 대응하는 값

        Stack<Double> stack = new Stack<>();
        double a = 0.0;
        double b = 0.0;
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if('A'<=c && c<='Z'){
                stack.push((double) nums.get(c));
            }
            else{
                switch(c){
                    case '*':
                        b = stack.pop();
                        a = stack.pop();
                        stack.push(a*b);
                        break;
                    case '/':
                        b = stack.pop();
                        a = stack.pop();
                        stack.push(a/b);
                        break;
                    case '+':
                        b = stack.pop();
                        a = stack.pop();
                        stack.push(a+b);
                        break;
                    case '-':
                        b = stack.pop();
                        a = stack.pop();
                        stack.push(a-b);
                        break;
                }
            }
        }
        System.out.printf("%.2f", stack.pop());
        sc.close();
    }   
}