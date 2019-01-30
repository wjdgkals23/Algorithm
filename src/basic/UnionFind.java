package basic;

public class UnionFind {
	public static int [] parent = new int [11];
	
	public static int getParent(int n) {
		return n == parent[n] ? n : getParent(parent[n]);
	}
	
	public static int checkCanUnion(int a, int b) {
		int p_a = getParent(a);
		int p_b = getParent(b);
		return p_a == p_b ? 0 : 1;
	}
	
	public static void unionParent(int a, int b) {
		int p_a = getParent(a);
		int p_b = getParent(b);
		if(p_a < p_b) parent[b] = p_a;
		else parent[a] = p_b;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=1; i<11; i++) {
			parent[i] = i;
		}
		
		unionParent(1,2);
		unionParent(2,3);
		unionParent(4,3);
		unionParent(5,6);
		unionParent(6,7);
		unionParent(7,8);
		
		System.out.println(checkCanUnion(1, 6));
	}

}
