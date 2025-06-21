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
        Deque<Integer> q=new LinkedList<>();

        int N=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        int[] arr=new int[N];
        for(int i=0;i<N;i++){
            int num=Integer.parseInt(st.nextToken());
            arr[i]=num;
            q.offer(num);
            //System.out.println(q);
        }

        while(!q.isEmpty()){
            //양수면 앞에서 꺼내고 음수면 뒤에서 꺼낸다
             for(int i=0;i<N;i++){
                arr[i]=q.pollFirst();
                sb.append(i);
                System.out.println(q);
                if(arr[i]>0){
                    for(int j=0;j<arr[i]-1;j++){
                        q.addLast(q.pollFirst());
                        System.out.println(q);
                    }
                    if(!q.isEmpty()){
                        arr[i]=q.pollFirst();
                        sb.append(i+" ");
                        System.out.println(q);
                    }
                    
                }else if(arr[i]<0){
                    for(int j=0;j<arr[i];j++){
                        q.addFirst(q.pollLast());
                        System.out.println(q);
                    }
                    if(!q.isEmpty()){
                        arr[i]=q.pollLast();
                        sb.append(i+" ");
                        System.out.println(q);
                    }
                    
                }
             }
        }
        System.out.println(sb);
    }
}

// 3 2 1 -3 -1
// 2 1 -3 -1
// 1 -3 -1 2
// -3 -1 2 1
//  1 2 -1
// 
