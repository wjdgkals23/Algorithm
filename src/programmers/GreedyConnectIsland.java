package programmers;

import java.util.Comparator;
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

	public static int solution(int n, int[][] costs) {
        int answer = 0;
        boolean [] visited = new boolean [n+1];
//        cycle 인지 확인해야하네.... 추가하려는 간선의 꼭지점이 둘 다 true이면 cycle이다!!! 
//      간선을 오름차순으로 정리하고 가장 처음것부터 하나씩 추가해나가자!!
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
        
        boolean flag = true;
        int cnt = 0;
        
        while(flag) {
        	if(cnt == n-1) break;
        	Vertex temp = list.removeFirst();
        	if(visited[temp.start]&&visited[temp.end]) continue;
        	visited[temp.start] = true;
        	visited[temp.end] = true;
        	cnt++;
        	answer += temp.cost;
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		int n = 4;
		int [][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
		
		System.out.println(solution(n,costs));
	}

}
