package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek11404 {
	
	public static int INF = 10000000;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		
		int size = Integer.parseInt(buf.readLine());
		int [][] ans = new int [size][size];
		
		for(int j=0; j<size; j++) {
			for(int k=0; k<size; k++) {
				ans[j][k] = INF;
			}
		}
		
		int line_cnt = Integer.parseInt(buf.readLine());
		
		for(int i=0; i<line_cnt; i++) {
			String t = buf.readLine();
			String[] temp = t.split(" ");
			if(ans[Integer.parseInt(temp[0])-1][Integer.parseInt(temp[1])-1] > Integer.parseInt(temp[2]))
				ans[Integer.parseInt(temp[0])-1][Integer.parseInt(temp[1])-1] = Integer.parseInt(temp[2]);
		}
		
		for(int m=0; m<size; m++) { // 경유
			for(int n=0; n<size; n++) { //시작
				for(int b=0; b<size; b++) { //도착
					if(ans[n][m]!=INF && ans[m][b]!=INF)
						ans[n][b]= Math.min(ans[n][b],ans[n][m]+ans[m][b]);
				}
			}
		}
		
		for(int a=0; a<size; a++) {
			for(int c=0; c<size; c++) {
				if(ans[a][c] == INF || a==c)
					System.out.print("0 ");
				else
					System.out.print(ans[a][c] + " ");
			}
			System.out.println();
		}
	}

}
