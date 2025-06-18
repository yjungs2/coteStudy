package codus.week01;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2417_cy {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long left = 0;
        long right = N; 
        long answer = 0;
        while(left <= right) {
    		long middle = (left + right) / 2;
    		if( Math.pow( middle, 2) >= N) {
    			answer = middle;
    			right = middle - 1;
    		}
    		else if(Math.pow(middle, 2) < N){
    			left = middle + 1;
    		}
    	}

        System.out.println(answer);

    }
}
