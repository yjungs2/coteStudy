package ranii.week01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1935_TR {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        String text=br.readLine();

       // int c=text.charAt(N); //문자열을 숫자로 바꿈 (피연산자 식별)
        // 배열생성 후 text 저장
        int[] arr= new int[N]; //크기가 N인 배열 생성
        for(int i=0;i<N;i++){ //배열 돌기 
            arr[i]=Integer.parseInt(br.readLine());
        }
        
        //스택 생성 
        Stack<Double> stack = new Stack<>();
        // 반복문 돌려서 배열사이즈까지 반복
        for(int i=0;i<text.length();i++){
            char c=text.charAt(i);
            if('A'<=c&&'Z'>=c){
                double d=arr[c-'A'];
                stack.push(d);
            }else{
                //switch문 사용해서 연산자 구분
                 double a=0.0;
                 double b=0.0;
                 double result=0.0;
                 switch (c) {
            //case문 에서 연산 후 stack에 저장 
                    case '+':
                        a=stack.pop();
                        b=stack.pop();
                        result=a+b;
                        stack.push(result);
                        break;
                    case '*':
                        a=stack.pop();
                        b=stack.pop();
                        result=a*b;
                        stack.push(result);
                        break;
                    case '-':
                        a=stack.pop();
                        b=stack.pop();
                        result=b-a;
                        stack.push(result);
                        break;
                    case '/':
                        a=stack.pop();
                        b=stack.pop();
                        result=b / a;
                        stack.push(result);
                        break;
                 }
            }
        
        }//while
       System.out.printf("%.2f",stack.pop());

    }//main
}//class
