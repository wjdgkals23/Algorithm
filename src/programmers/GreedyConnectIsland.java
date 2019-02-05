package programmers;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

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
        
        // 우선순위 큐는 기본적으로 비교하는 값이 같을 경우 알아서 오름차순으로 설정해 준다.
        PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>(new Comparator<Vertex>() {
            public int compare(Vertex o1, Vertex o2) {
                if(o1.cost < o2.cost){
                    return -1;
                }
                return 1;
            }
        });
        for(int i=0; i<costs.length; i++){
            int from = costs[i][0];
            int to = costs[i][1];
            int cost = costs[i][2];

            queue.offer(new Vertex(from,to,cost));
        };
        
        Iterator<Vertex> tmp = queue.iterator();
        
        while(tmp.hasNext()) {
        	Vertex vt = tmp.next();
        	System.out.print(vt.start + " ");
        	System.out.print(vt.end + " ");
        	System.out.print(vt.cost);
        	System.out.println();
        }
        
        HashSet<Integer> set = new HashSet<Integer>();
        
        while(!queue.isEmpty()) {
        	Vertex temp = queue.poll();
        	System.out.println(temp.cost);
        	int start = temp.start;
        	int end = temp.end;
        	if(!set.contains(end) && !set.contains(start)) {
        		set.add(end);
        		set.add(start);
        		union(end,start);
//        		showparent();
        		answer+=temp.cost;
        	}
        	else if(!set.contains(end) && set.contains(start)) { // start는 이미 군집에 포함되어있는 경우 
        		set.add(end);
        		union(end,start);
//        		showparent();
        		answer+=temp.cost;
        	}
        	else if(set.contains(end)&&!set.contains(start)) { // start는 이미 군집에 포함되어있는 경우 
        		set.add(start);
        		union(end,start);
        		answer+=temp.cost;
        	}
        	else { // 이미 같은 싸이클에 있는 경우와 서로 다른 싸이클에 포함되어있는 경우로 나뉜다. 
        		if(find(end) == find(start)) {
        			continue;
        		}
        		else {
        			union(end,start);
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
	
	public static int find(int n){
        LinkedList<Integer> stack = new LinkedList<Integer>();
//        union 의 루트를 찾는 과정 
        while(parent[n] != n){ 
            stack.add(n);
            n = parent[n];
        }
//        루트값으로 지정되지 않은 값들 수정하기 
        while(stack.size() > 0){
            parent[stack.poll()] = n;
        }
        return n;
    }

    public static void union(int a, int b){
        int fa = find(a);
        int fb = find(b);
        if(fa < fb)
        	parent [fb] = fa;
        else
        	parent [fa] = fb;
    }
	
	public static void main(String[] args) {
		int n = 4;
		int [][] costs = {{1,3,1},{0,2,1},{1,2,5},{1,3,1},{2,3,8}};
		
		System.out.println(solution(n,costs));
	}

}
