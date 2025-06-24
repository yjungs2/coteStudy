package ranii.week02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_2346_TR {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        Deque<Balloon> q=new LinkedList<>();

        int N=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        //int[] arr=new int[N];
        for(int i=0;i<N;i++){
            int num=Integer.parseInt(st.nextToken());
            Balloon balloon=new Balloon(i+1, num);
            q.offer(balloon);
            //System.out.println(q.toString());
        }
        while(!q.isEmpty()){
            Balloon current=q.pollFirst();
            sb.append(current.idx).append(' ');
            //System.out.println(q.toString());
            if(q.isEmpty()) break;
            //양수면 앞에서 꺼내고 음수면 뒤에서 꺼낸다
            int move=current.num;
            if(move>0){//큐에 있는 첫번쩨 풍선객체의 숫자값이 0보타 큰지 비교하고싶음....
                for(int j=0;j<move-1;j++){// 이거는 이제 덱 뒤에 넣는거임...
                q.addLast(q.pollFirst());
                //System.out.println(q.toString());
                }
            }else {
                for(int j=0;j<-move;j++){
                q.addFirst(q.pollLast());
                //System.out.println(q.toString());
                }
                }
            }
             System.out.println(sb);
        }
    }
class Balloon{
    int idx;
    int num;
    
    public Balloon(int idx,int num){
        this.idx=idx;
        this.num=num;
    }
    public String toString() {
        return "(" + idx + "," + num + ")";
    }
}

// 3 2 1 -3 -1
// 2 1 -3 -1
// 1 -3 -1 2
// -3 -1 2 1
//  1 2 -1
// 
