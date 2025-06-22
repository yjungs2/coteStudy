package codus.week02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_1966_cy {
    public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<n; i++) {
			Deque<Printer> deque = new ArrayDeque<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken()); //궁금 문서 위치 
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				int priority = Integer.parseInt(st.nextToken());
				deque.add(new Printer(j, priority)); //(0,1), (1,2), (2,3), (3,4)
			}
			
			int p = 0; 
			while(!deque.isEmpty()) {
				Printer current = deque.poll(); //현재 비교하는 애 (맨 앞에있음)
				boolean hasPriority = false; //현재 비교 애 뒤에 더 높은애가 있는가 
				
				for(Printer printer : deque) {
					if(printer.priority > current.priority) {
						hasPriority = true;
						break;
					}
				}
				if(hasPriority) {
					deque.addLast(current);
				}else {
					p++;
					if(current.index == M) {
						sb.append(p).append('\n');
						break;
					}
				}
			}
		}
		System.out.print(sb);
	}

}

class Printer {
	int index;
	int priority;
	
	public Printer(int index, int priority) {
		this.index = index;
		this.priority = priority;
	}
}