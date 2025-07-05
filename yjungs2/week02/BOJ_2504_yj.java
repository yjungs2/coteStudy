package yjungs2.week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 미완성
public class BOJ_2504_yj {
    public static void main(String[] args) throws IOException {
    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //     String str = br.readLine();
    //     Stack<String> stack = new Stack<>();
        
    //     boolean possible = true;
    //     for(int i=0; i<str.length(); i++){
    //         String bracket = str.substring(i, i+1);
            
    //         // ( : 아스키 40 
    //         // ) : 아스키 41
    //         // [ : 아스키 91
    //         // ] : 아스키 93

    //         if(bracket=="(" || bracket=="["){
    //             stack.push(bracket);
    //         } else {
    //             if(bracket==")"){
    //                 String bf1 = stack.peek();
    //                 if(bf1 == "("){
    //                     stack.pop();
    //                     if(isNumeric(stack.peek())) { // n()
    //                         String bf2 = stack.pop();
    //                         stack.push(String.valueOf(Integer.parseInt(bf2)*2));
    //                     } else { // ()
                            
    //                     }
    //                     stack.push("2");
    //                 } else if(bf1 == "[" || bf1 == "]"){ // [) ])
    //                     possible = false;
    //                     break;
    //                 } else if(bf1 == ")"){

    //                 }
    //             }
    //         }

    //     }
    //     int ans = 0;
    //     if(possible){
    //         for(int s=0; s<stack.size(); s++){
    //             ans += Integer.parseInt(stack.pop());
    //         }
    //     }
    //     System.out.println(!possible?0:ans);
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}

