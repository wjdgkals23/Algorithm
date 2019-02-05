package programmers;

import java.util.LinkedList;

public class Thievery {
	
	public int solution(int[] money) {
        int answer = 0;
        
        LinkedList<Integer> list = new LinkedList<Integer>();
        
        for(int i=0; i<money.length; i++) {
        	list.add(money[i]);        
        }
        
        for(int i=0; i<money.length; i++) {
        	int [] temp = new int [money.length];
        	for(int j=0; j<list.size()-1; j++) {
        		temp[j] = j;
        		if(j == 2) {
        			temp[j] += temp[j-2];
        		}
        		if(j > 2) {
        			temp[j] += Math.max(temp[j-2],temp[j-3]);
        		}
        		
        	}
        	if(answer < Math.max(temp[temp.length-1],temp[temp.length-2]))
        		answer = Math.max(temp[temp.length-1],temp[temp.length-2]);
        	int a = list.removeFirst();
        	list.addLast(a);
        }
        
        
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thievery act = new Thievery();
		int [] money = {1,2,3,1};
		System.out.println(act.solution(money));

	}

}
