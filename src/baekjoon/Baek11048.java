package baekjoon;

import java.util.Scanner;

public class Baek11048 {
	public static int [][] map;
	public static int [] mx = {0,1,1};
	public static int [] my = {1,0,1};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		sc.nextLine();
		
		map = new int [x+1][y+1];
		 
		for(int i=1; i<=x; i++) {
			String temp = sc.nextLine();
			String [] temps = temp.split(" ");
			
			for(int j=1; j<=y; j++) {
				map[i][j] = Integer.parseInt(temps[j-1]);
			}
		}
		findvalue(x,y);
		System.out.println(map[x][y]);
		
	}

	private static void findvalue(int x, int y) {
		for(int i=1; i<=x; i++) {
			for(int j=1; j<=y; j++) {
				int max = 0;
				for(int k=0; k<3; k++) {
					int dx = i - mx[k];
					int dy = j - my[k];
					if(dx>0 && dx<=x && dy<=y && dy>0) {
						if(map[dx][dy] > max)
							max = map[dx][dy];
					}
				}
				map[i][j] += max;
			}
		}
	}

}
