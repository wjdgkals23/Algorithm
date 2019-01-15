package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Baek6603 {
	
	static int [] can;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		LinkedList<Integer> ans = new LinkedList<Integer>();
		
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String temp = buf.readLine();
			if(temp.equals("0"))
				break;
			String[] temps= temp.split(" ");
			can = new int [Integer.parseInt(temps[0])];
			for(int i=1; i<temps.length; i++) {
				can[i-1] = Integer.parseInt(temps[i]);
			}
			
			deep(ans,0);
			System.out.println();
		}
	}

	private static void deep(LinkedList<Integer> ans, int i) {
		// TODO Auto-generated method stub
		if(ans.size() == 6) {
			for(int j=0; j<6; j++) {
				System.out.print(ans.get(j)+" ");
			}
			System.out.println();
		}
		
		if(i>=can.length || ans.size()==6) return;
		
		ans.add(can[i]);
		deep(ans,i+1);
		ans.removeLast();
		deep(ans,i+1);
	}

}
