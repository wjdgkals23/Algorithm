package programmers;

public class Thievery2 {
	
	public int solution(int[] money) {
        int answer = 0;
        int [] dp = new int [money.length];
        int [] dp2 = new int [money.length];
        
        dp[0] = dp[1] = money[0];
        dp2[0] = 0;
		dp2[1] = money[1]; 
		
		// 첫번째를 포함하게되면서 마지막 요소를 얻지 못하는 경우 
        for(int i=2; i<dp.length-1; i++) {
        	dp[i] = Math.max(dp[i-1], dp[i-2]+money[i]);
        }
        // 첫번째를 포함하지 않게 되면서 마지막 요소를 포함할 수 있는 경우 
        for(int j=2; j<dp2.length; j++) {
        	dp2[j] = Math.max(dp2[j-1], dp2[j-2]+money[j]);
        }
        
        for(int k=0; k<dp2.length; k++) {
        	System.out.println(dp[k] +", "+dp2[k]);
        }
        
        answer = Math.max(dp[dp.length-2],dp2[dp2.length-1]);
         
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thievery2 act = new Thievery2();
		int [] money = {1,2,3,1};
		System.out.println(act.solution(money));

	}

}
