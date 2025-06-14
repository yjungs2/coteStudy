package yoon.week01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


public class BOJ_2417_yy {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine()); 
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Integer> A = new HashSet<>();
        for(int i=0; i<N; i++){
            A.add(Integer.parseInt(st.nextToken()));
        }
        int M = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder(); 
        for(int i=0;i<M;i++)
        {
            int c = Integer.parseInt(st.nextToken());
             if (A.contains(c)) {
                sb.append("1 ");
            } else {
                sb.append("0 ");
            }
        }
        bw.write(sb.toString());
        bw.close();


    }
}
