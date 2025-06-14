package yoon.week01;

import java.util.Scanner;

public class BOJ_1789_yy {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long value = sc.nextLong();
		long sum = 0;
		int num = 0;
		for(int i=1;i<value+1;i++) {
			sum += i;
			if(sum > value) {
				break;
			}
			num += 1;
		}
	
		System.out.println(num);
		
		sc.close();

	}
    
}
