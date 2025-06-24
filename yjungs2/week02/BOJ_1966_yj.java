package yjungs2.week02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1966_yj {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0; i<t; i++){
            int n = sc.nextInt();
            int m = sc.nextInt();
            Queue<Printer> queue = new LinkedList<>(); // 문서 번호와 중요도를 담는 큐
            ArrayList<Integer> ps = new ArrayList<>(); // 중요도만 담는 리스트

            for(int j=0; j<n; j++) {
                int p = sc.nextInt();
                queue.add(new Printer(j, p));
                ps.add(p);
            }
            ps.sort((a, b) -> b-a); // 우선순위 내림차순 정렬
            
            int idx = 0; // 리스트의 index
            int cnt = 0; // 인쇄된 문서 count
            while(true){
                Printer printer = queue.poll(); // peek + remove
                if(printer.priority == ps.get(idx)) { // 현재 queue에 담긴 문서 중에 중요도가 가장 높다면
                    cnt ++;
                    idx ++;
                    if(printer.index == m) { // 찾으려는 번호의 문서라면
                        break;
                    }
                } else { // 가장 높은 중요도의 문서가 아니라면
                    queue.add(printer); // 뒤에 재배치
                }
                // queue.stream().forEach(p->System.out.print("("+p.index + " "+ p.priority+") "));
            }
            System.out.println(cnt);
        }
        sc.close();
    }
}

class Printer { // 큐에 ( , ) 쌍을 넣기 위해 만든 클래스
    int index;
    int priority;

    public Printer(int index, int priority) {
        this.index = index;
        this.priority = priority;
    }
}