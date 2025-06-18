package codus.week01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BOJ_스택수열_cy {
	
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		
		StringBuilder sb = new StringBuilder();

		int last = 0;
		boolean isTrue = true;
		
		for(int i=0; i<n; i++) {
			
			int num = Integer.parseInt(br.readLine());
			
			if(num>last) {
				for(int j=last+1; j<=num; j++) {
					stack.push(j);
					sb.append("+\n");
				}
				last = num;
			}
			if(num == stack.peek()) {
				stack.pop();
				sb.append("-\n");
			}else{
				isTrue = false;
				break;
			}
		}
        
		System.out.println(isTrue == false ? "NO" : sb);
	}
}