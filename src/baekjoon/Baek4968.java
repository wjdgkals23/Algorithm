package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baek4968 {
	
	public static int[] tx = {-1,0,1,1,1,0,-1,-1};
	public static int[] ty = {1,1,1,0,-1,-1,-1,0};
	
	public static class Node {
		int x;
		int y;
		
		Node(int x, int y){
			this.x= x;
			this.y= y;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String sen = buf.readLine();
			if(sen.equals("0 0")) {
				break;
			}
			int x = Integer.parseInt(sen.split(" ")[0]);
			int y = Integer.parseInt(sen.split(" ")[1]);
			
			int ans = 0;
			Queue<Node> que = new LinkedList<Node>();
			
			int [][] map = new int [y][x];
			boolean [][] ch = new boolean [y][x];
			
			//지도작성 
			for(int i=0; i<y; i++) {
				String line = buf.readLine();
				String [] lines = line.split(" ");
				
				for(int j=0; j<x; j++) {
					map[i][j] = Integer.parseInt(lines[j]);
				}
			}
			
			for(int k=0; k<y; k++) {
				for(int l=0; l<x; l++) {
					if(map[k][l]!=0 && ch[k][l]!=true) {
						ans++;
						que.add(new Node(k,l));
						while(!que.isEmpty()) {
							Node temp = que.poll();
							int dx = temp.x;
							int dy = temp.y;
							ch[dx][dy] = true;
							for(int m=0; m<8; m++) {
								int ux = dx+tx[m];
								int uy = dy+ty[m];
								if(ux>=0 && ux<y && uy>=0 && uy<x)
									if(map[ux][uy]!=0 && ch[ux][uy]!=true) {
										que.add(new Node(ux,uy));
										ch[ux][uy] = true;
									}
							}
						}
					}
				}
			}
			System.out.println(ans);				
		}
	}

}
