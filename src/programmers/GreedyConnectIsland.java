package programmers;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;

public class GreedyConnectIsland {
	
	static class Vertex {
		int start;
		int end;
		int cost;
		Vertex(int start, int end, int cost){
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
	}
	
	public static int [] parent;

	public static int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int [n];
        
        for(int p=0; p<n; p++) {
        	parent[p] = p;
        }
//        cycle 인지 확인해야하네.... 추가하려는 간선의 꼭지점이 둘 다 true이면 cycle이다!!! 
//      간선을 오름차순으로 정리하고 가장 처음것부터 하나씩 추가해나가자!!
//      간선을 추가하면서 섬들을 추가해나갈때 합집합 알고리즘을 이용해야한다.
//      아직 초기 해결방안에 대해 반례를 찾지 못했다. -> 간선이 추가되었을 때가 아닌 섬이 추가된 것을 확인하고 추가해야한다.
        LinkedList<Vertex> list = new LinkedList<Vertex>();
        for(int i=0; i<costs.length; i++) {
        	int a = costs[i][0];
        	int b = costs[i][1];
        	int c = costs[i][2];
        	list.add(new Vertex(a, b, c));
        }
        
        list.sort(new Comparator<Vertex>() {
			@Override
			public int compare(Vertex o1, Vertex o2) {
				// TODO Auto-generated method stub
				if(o1.cost > o2.cost) {
					return 1;
				}
				else {
					return -1;
				}
			}
		});
        
        HashSet<Integer> set = new HashSet<Integer>();
        
        while(!list.isEmpty()) {
        	Vertex temp = list.removeFirst();
        	int start = temp.start;
        	int end = temp.end;
        	if(!set.contains(end)&&!set.contains(start)) {
        		set.add(end);
        		set.add(start);
        		union(end,start);
        		showparent();
        		answer+=temp.cost;
        	}
        	else if(!set.contains(end)&&set.contains(start)) { // start는 이미 군집에 포함되어있는 경우 
        		set.add(end);
        		union(end,start);
        		showparent();
        		answer+=temp.cost;
        	}
        	else if(set.contains(end)&&!set.contains(start)) { // start는 이미 군집에 포함되어있는 경우 
        		set.add(start);
        		union(end,start);
        		showparent();
        		answer+=temp.cost;
        	}
        	else { // 이미 같은 싸이클에 있는 경우와 서로 다른 싸이클에 포함되어있는 경우로 나뉜다. 
        		if(findparent(end) == findparent(start)) {
        			continue;
        		}
        		else {
        			union(end,start);
        			showparent();
        			answer+=temp.cost;
        		}
        	}
        }
        
        return answer;
    }
	
	public static void showparent() {
		for(int i=0; i<parent.length; i++) {
			System.out.print(parent[i]);
		}
		System.out.println();
	}
	
	public static int findparent(int n) {
		return parent[n]==n ? n : findparent(parent[n]);
	}
	
	public static void union(int a, int b) { // 함수 수정 
		int a_ = findparent(a);
		int b_ = findparent(b);
		
		if(a_<b_) {

		}
		else parent[a] = b_;
	}
	
	public static void main(String[] args) {
		int n = 4;
		int [][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
		
		System.out.println(solution(n,costs));
	}

}
