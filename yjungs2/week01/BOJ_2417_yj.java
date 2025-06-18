package yjungs2.week01;

import java.util.Scanner;

// BOJ 2417 정수 제곱근
public class BOJ_2417_yj {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        // n=1, n=2 인 경우는 따로 생각한다
        if(n <= 2) System.out.println(n);
        else System.out.println(sqrt(n));
    }

    private static long sqrt(long n){
        long left = 1;
        long right = n;
        long temp = 0;

        while(left < right){
            // mid = (left + right)/2
            // = left/2 + right/2 = left>>1 + right>>1
            long mid = (left>>1) + (right>>1);
            // System.out.println(mid);
            if(Math.pow(mid, 2) >= n){
                temp = mid;
                right = mid; // 오른쪽 절반은 필요없음
            } else{ // Math.pow(mid, 2) < n 인 경우
                left = mid + 1; // 왼쪽 절반은 필요없음
            }
        }
        return temp;
    }
}