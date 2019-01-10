package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baek9095 {
	public static int [] items = { 1,2,3 }; 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int rnd = Integer.parseInt(sc.nextLine());
		int [] values;
		
		for(int i=0; i<rnd; i++) {
			int target = Integer.parseInt(sc.nextLine());
			values = new int [target+1];
			
			Queue<Integer> que = new LinkedList<Integer>();
			que.add(0);
			
			while(!que.isEmpty()) {
				int ind = que.remove();
				for(int j=0; j<items.length; j++) {
					int temp = ind + items[j];
					if(temp <= target) {
						values[temp]++;
						que.add(temp);
					}
				}
			}
			
			System.out.println(values[target]);
		}
		
		
		
	}

}
