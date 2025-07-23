package codus.week03;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_16918_cy {

   static int N;
   static char[][] chars;
   static boolean[][] v;
   
   public static void main(String[] args) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      N = Integer.parseInt(br.readLine());
      chars = new char[N][N];
      v = new boolean[N][N];
      
      String S = null;
      for(int i=0; i<N; i++) {
         S = br.readLine();
         for(int j=0; j<N; j++) {
            chars[i][j] = S.charAt(j);
         }
      }
      
      
      int n_count = 0;
      for(int i=0; i<N; i++) {
         for(int j=0; j<N; j++) {
            if(v[i][j] != true) {
               dfs(i, j);
               n_count++;
            }
         }
      }
      v = new boolean[N][N];
      
      int f_count = 0;
      for(int i=0; i<N; i++) {
         for(int j=0; j<N; j++) {
            if(chars[i][j] == 'G') {
               chars[i][j] = 'R';
            }
         }
      }
      
      for(int i=0; i<N; i++) {
         for(int j=0; j<N; j++) {
            if(v[i][j] != true) {
               dfs(i, j);
               f_count++;
            }
         }
      }
      
      System.out.println(n_count+" "+f_count);
      
   }

   private static void dfs(int i, int j) {
      int dx[] = {0,0,1,-1};
      int dy[] = {1,-1,0,0};
      v[i][j] = true;
      char temp = chars[i][j];
      for(int k=0; k<4; k++) {
         int x = i+ dx[k];
         int y = j+ dy[k];
         if(x>=0 && x<N && y <N && y >=0) {
            if(!v[x][y] && chars[x][y] == temp) {
               dfs(x, y);
            }
         }
      }
   }

}
