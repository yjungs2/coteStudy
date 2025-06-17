package codus.week01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10815_cy {
    static int arrN[]= null;
    static int arrM[] = null;
    static int N = 0;
    static StringBuilder sb = new StringBuilder();
    static boolean isFind = false;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        arrN = new int[N];
        for(int i=0; i<N; i++){
            arrN[i] = Integer.parseInt(st1.nextToken());
        }
        Arrays.sort(arrN);
        int M = Integer.parseInt(br.readLine());
        arrM = new int[M];

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            isFind = false;
            arrM[i] = Integer.parseInt(st2.nextToken());
            find(arrM[i], 0, N-1);
            if(isFind == true) sb.append("1 ");
            else sb.append("0 ");
        }

        System.out.println(sb);
    }
    private static void find(int target, int s, int e) {
    if (s > e) return;

    int mid = (s + e) / 2;

    if (arrN[mid] == target) {
        isFind = true;
        return;
    } else if (arrN[mid] > target) {
        find(target, s, mid - 1);
    } else {
        find(target, mid + 1, e);
    }
}
}
