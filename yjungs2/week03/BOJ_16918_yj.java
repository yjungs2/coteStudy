import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_16918_yj {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int r = sc.nextInt();
        int c = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine(); // 한 줄 추가해서 개행 문자 제거
        
        String[][] grid = new String[r][c];
        for(int i=0; i<r; i++){
            String str = sc.nextLine();
            for(int j=0; j<c; j++){
                grid[i][j] = str.substring(j, j+1);
            }
        }

        sc.close();

        // String[][] grid2 = new String[r][c];
        // for(int i=0; i<r; i++){
        //     for(int j=0; j<c; j++){
        //         grid2[i][j] = "O";
        //     }
        // }
        int[] dx = {0, -1, 0, 0, 1};
        int[] dy = {0, 0, -1, 1, 0};
        if(n%4==3){ // 폭탄 터뜨리기
            for(int i=0; i<r; i++){
                for(int j=0; j<c; j++){
                    if(grid[i][j]=="O"){
                        for(int k=0; k<5; k++){
                            int nx = i+dx[k];
                            int ny = j+dy[k];
                            if(nx>=0 && nx<c && ny>=0 && ny<n){
                                // grid2[nx][ny] = ".";
                            }
                        }
                    }
                }
            }

        }

        if(n%2==0){
            for(int i=0; i<r; i++){
                for(int j=0; j<c; j++){
                    System.out.print("O");
                }
                System.out.println();
            }
        } 
        // else if(n%4==1) {
        //     for(int i=0; i<r; i++){
        //         for(int j=0; j<c; j++){
        //             System.out.print(grid[i][j]);
        //         }
        //         System.out.println();
        //     }
        // } else { // n%4==3 일 때
        //     for(int i=0; i<r; i++){
        //         for(int j=0; j<c; j++){
        //             System.out.print(grid2[i][j]);
        //         }
        //         System.out.println();
        //     }
        // }
    }
}