package yoon.week01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_2417_yy {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long N = Long.parseLong(br.readLine());
        long left = 0;
        long right = N;
        long mid=-1;
        long answer = -1;
        while(left <= right)
        {
            mid = (left+right) / 2;
            
            if(Math.pow(mid,2)>=N) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        // StringBuilder sb = new StringBuilder(); 
        bw.write(answer+"\n");
        bw.close();

    }
    /*
    private static boolean isCorrect(long mid, long N){
        long result = N / mid;
        return (result <= mid && mid >= 0);
    }
    */
}
