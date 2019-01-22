package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 규칙 찾기 였다..... 2의 31승 인것이 애초에 for 문 돌리는게 무리였다.

public class Baek1011 {
	public static class Node {
		int k; // k(n-1)-1 ,k(n-1) , k(n-1)+1
		int index;
		int cnt;
		
		Node(int k, int index, int cnt) {
			this.k = k;
			this.index = index;
			this.cnt = cnt;
		}
	}
	
	public static int [] item = {-1,0,1};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int round = Integer.parseInt(sc.nextLine());
		
		for(int i=0; i<round; i++) {
			String temp = sc.nextLine();
			String [] temps = temp.split(" ");
			int x = Integer.parseInt(temps[0]);
			int y = Integer.parseInt(temps[1]);
			
			int rnd = y-x+1;
			
			if(rnd-1 == 1) {
				System.out.println(1);
			}
			else {
				int ans = 1000000000;
				Queue<Node> que = new LinkedList<Node>();
				que.add(new Node(1,1,1));
				
				while(!que.isEmpty()) {
					Node node = que.remove();
					int n_k = node.k;
					int n_ind = node.index;
					int n_cnt = node.cnt;
					if(n_ind > rnd-2)
						continue;
					if(n_ind == rnd-2) {
						if(ans > n_cnt)
							ans = n_cnt;
					}
					for(int k=0; k<3; k++) {
						int t_k = n_k + item[k];
						int t_ind = n_ind + t_k;
						if(t_k>0 && t_ind<=rnd-2) {
//							System.out.print(t_k+" " +t_ind);
							que.add(new Node(t_k, t_ind, n_cnt+1));
						}
					}
				}
				System.out.println(ans+1);
			}
			sc.close();
		}
	}

}
