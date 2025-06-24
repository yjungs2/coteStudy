package yoon.week01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class BOJ_1874_yy  {

        public static void main(String[] args) throws NumberFormatException, IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
                int N = Integer.parseInt(br.readLine());
                ArrayList<Integer> arr = new ArrayList<>();
                for(int i=0;i<N;i++){
                        arr.add(Integer.parseInt(br.readLine()));
                }
                ArrayList<Integer> stack = new ArrayList<>();
                ArrayList<Character> operations = new ArrayList<>();
                boolean possible = true;
                int current = 1;
                // '4 3 6 8 7 5 2 1'
                for(int num:arr){
                        while (current <= num){
                                stack.add(current);
                                operations.add('+');
                                current+=1;
                        }
                        if(stack.get(stack.size() - 1) == num){
                                stack.remove(stack.size()-1);
                                operations.add('-');
                        } else {
                                possible = false;
                                break;
                        }
                }
                if(possible = true) {
                        for(char op:operations){
                                System.out.println(op);
                        }
                } else{
                        System.out.println("NO");
                }
        }
}
