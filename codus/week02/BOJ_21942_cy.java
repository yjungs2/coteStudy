package codus.week02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_21942_cy {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //정보 개수
        String L = st.nextToken(); //대여 기간 
        int F = Integer.parseInt(st.nextToken());
        
        Map<String, Map<String, String>> userInfo = new HashMap<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            //문제에서 들어오는 기간은 항상 2021이다
            String day = st.nextToken();
            String time = st.nextToken();
            String bName = st.nextToken();
            String userId = st.nextToken();
            String date = day+" "+time;
            Map<String, String> borrow = new HashMap<>();
            borrow.put(bName, date);
        }
    }
}
