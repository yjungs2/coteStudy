package codus.week01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_1789_cy {
    public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    long S = Long.parseLong(br.readLine());
    int i = 1;
    int sum = 0;
    while(true){
        sum += i;
        if(S < sum) break;
        i++;
    }
    bw.write((i-1)+"\n");
    bw.flush();
    bw.close();
    br.close();

    }
}
