package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baek9205 {
	
	public static class Node {
		int x;
		int y;
		int ind;
		
		Node(int x, int y, int ind){
			this.x= x;
			this.y= y;
			this.ind= ind;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader buf= new BufferedReader(new InputStreamReader(System.in));
		
		int cnt= Integer.parseInt(buf.readLine());
		for(int i=0; i<cnt; i++) {
			int cnt1= Integer.parseInt(buf.readLine());
			boolean ans= false;
			Node [] list= new Node[cnt1+2];
			boolean [] check= new boolean[cnt1+2];
			Queue<Node> que= new LinkedList<Node>();
			for(int j=0; j<cnt1+2; j++) {
				String temp= buf.readLine();
				int a= Integer.parseInt(temp.split(" ")[0]);
				int b= Integer.parseInt(temp.split(" ")[1]);
				
				list[j]= new Node(a,b,j);
			}
			que.add(list[0]);
			check[0]= true;
			
			while(!que.isEmpty()) {
				Node node= que.poll();
				if(node.ind == cnt1+1) {
					ans= true;
				}
				for(int k=0; k<cnt1+2; k++) {
					if(!check[k] && (Math.abs(node.x-list[k].x)+Math.abs(node.y-list[k].y))<=1000) {
						que.add(list[k]);
						check[k]= true;
					}
				}
			}
			
			if(ans) {
				System.out.println("happy");
			}
			else {
				System.out.println("sad");
			}
		}
	}

}
