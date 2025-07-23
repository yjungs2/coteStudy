package codus.week03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16918_cy {
    public static char arr[][] = null;
    public static char list[][] = null;
    static int R,C,N = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        //N이 짝수이면 보두 0 출력, 홀수이면 3일때-> 펑 5일때-> 원래대로 
        list = new char[R][C];
        arr = new char[R][C];
        for(int i=0; i<R; i++){
            String s = br.readLine();
            for(int j=0; j<C; j++){
                arr[i][j] = s.charAt(j);
            }
        }
        
        //3,7,11,15,... -> (x-3)%4 == 0
        //5,9,13,17,21... -> (x-5)%4 == 0
        if (N == 1) {
            list = arr;
        } else if (N % 2 == 0) {
            // 모든 칸 폭탄
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    list[i][j] = 'O';
                }
            }
        } else if ((N - 3) % 4 == 0) {
            list = BFS(arr, new char[R][C]);
        } else if ((N - 5) % 4 == 0) {
            char[][] a = BFS(arr, new char[R][C]);
            list = BFS(a, new char[R][C]);
        }


        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                System.out.print(list[i][j]);
            }
            System.out.println();
        }
    }

    public static char[][] BFS(char[][] arr, char[][] list){
        int a1[] = {1,-1,0,0};
        int a2[] = {0,0,-1,1}; //(0,1), (0,-1), ... 상하좌우

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                list[i][j] = 'O';
            }
        }

        for(int i=0; i<R; i++){
            for(int j=0; j< C; j++){
                if(arr[i][j] == 'O'){
                    list[i][j] = '.';
                    for(int k=0; k<4; k++){
                        int nx = i + a1[k];
                        int ny = j + a2[k];
                        if(nx >= 0 && nx < R && ny >=0 && ny<C){
                            list[nx][ny] = '.';
                        }
                    }
                }
            }
        }

        return list;
    }
}
