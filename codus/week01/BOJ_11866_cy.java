package codus.week01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11866_cy {
	static StringBuilder sb = new StringBuilder();
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Queue<Integer> q = new LinkedList<>();
		sb.append("<");
		for(int i=0; i<n; i++){
			q.add(i+1); //1에서 n까지 숫자를 넣음
		}

		while(!q.isEmpty()){
			for(int i=0; i<m-1; i++){
				q.add(q.poll());
			}
			sb.append(q.peek());
			if(q.size() != 1) sb.append(", ");
			q.poll();
		}
		sb.append(">");
		System.out.println(sb);
	}
}