package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek11657 {
	
	public final static int MAX = 1000000; 
	
	static class Edge {
		int from;
		int to;
		int cost;
		
		Edge(int from, int to, int cost) {
			this.from = from;
			this.cost = cost;
			this.to = to;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

	    st = new StringTokenizer(br.readLine().trim());
	    int N = Integer.parseInt(st.nextToken());
	    int M = Integer.parseInt(st.nextToken());
	    
	    int A, B, C;
	    Edge[] edgeArray = new Edge[M];

	    for (int i = 0; i < M; i++) {
	      st = new StringTokenizer(br.readLine().trim());

	      A = Integer.parseInt(st.nextToken());
	      B = Integer.parseInt(st.nextToken());
	      C = Integer.parseInt(st.nextToken());

	      edgeArray[i] = new Edge(A, B, C);
	    }
	    
	    int [] D = new int [N+1];
	    
	    for(int j=0; j<N+1; j++) {
	    	D[j] = MAX;
	    }
	    
	    D[1] = 0;
	    
	    for(int k=0; k<N-1; k++) {
	    	for(int l=0; l<M; l++) {
	    		if(D[edgeArray[l].from] == MAX) { // 최적화의 시작점이 무한대일 경우 생략 진행 
	    			continue;
	    		}
	    		if(D[edgeArray[l].to] > D[edgeArray[l].from]+edgeArray[l].cost) { // 더 작을 경우 업데이트 
	    			D[edgeArray[l].to] = D[edgeArray[l].from]+edgeArray[l].cost;
	    		}
	    	}
	    }
	    
	    boolean flag = false; // 업데이트가 끝난 뒤 한번더 확인하였을 때 변한다면 사이클이 있다는 것!!
	    for(int l=0; l<M; l++) {
    		if(D[edgeArray[l].from] == MAX) { // 최적화의 시작점이 무한대일 경우 생략 진행 
    			continue;
    		}
    		if(D[edgeArray[l].to] > D[edgeArray[l].from]+edgeArray[l].cost) { // 더 작을 경우 업데이트 
    			D[edgeArray[l].to] = D[edgeArray[l].from]+edgeArray[l].cost;
    			flag = true;
    		}
    	}
	    
	    if(flag) {
	    	System.out.println("-1");
	    }else {
	    	for(int b=2; b<N+1; b++) {
	    		if(D[b] == MAX) {
	    			System.out.println("-1");
	    		}
	    		else{
	    			System.out.println(D[b]);
	    		}
	    	}
	    }
	    
	}
}
