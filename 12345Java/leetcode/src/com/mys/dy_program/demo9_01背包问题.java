package com.mys.dy_program;

/**
 * 01��������
 * 	����N����Ʒ��һ������ΪC�ı�������Ʒ�������ֱ�Ϊw[i]����Ʒ�ļ۸�Ϊv[i],����Щ��Ʒ�ŵ����������ʹ�ü�ֵ���
 * 	����ÿһ����Ʒ��Ҫôѡ��Ҫô��ѡ��������x[i]��ʾ��x[i]��ȡֵ��0����1�����Գ�֮Ϊ01��������
 * 	���������Ϊ��
 * 		��Լ����w1x1+w2x2+...wnxn<=C
 * 		��max{v1x1+v2x2+...vnxn}
 * @author dell
 *
 */
public class demo9_01�������� {

	public static void main(String[] args) {
		int N = 6;
		int C = 12;
		int[] w = {4, 6, 2, 2, 5, 1};
		int[] v = {8, 10, 6, 3, 7, 2};
		int ret = Bag01.bag2(N, C, w, v);
		System.out.println(ret);
	}

}

class Bag01{
	
	/**
	 * 	�ⷨ3����̬�滮
	 * 		��һά����dp����¼�����������ɵ�����ֵ,
	 * 		����״̬���̣�dp(i,C)=max(dp(i-1,C),v(i)+dp(i-1,C-w(i)))
	 * 			��ǰi-1����Ʒ�ֱ���뱳����ʱ���õ�һά����dp��dp[j]����������Ϊjʱ������ֵ
	 * 			����������Ϊjʱ��dp[j]Ҫô��i-1״̬��dp[j],Ҫô��i-1״̬ʱ��dp[j-w[i]]��v[i]�ĺ�
	 * 			����jҪ�Ӻ���ǰ��������Ȼ��dp[j-w[i]]�ǵ�ǰi״̬����ֵ��������i-1״̬ʱ��ֵ��
	 * 		��ʱ��״̬����Ϊ		 
	 * 			dp(j)= max(dp[j], dp[j-w[i]]+v[i])
	 */
	public static int bag2(int N,int C,int[] w,int[] v) {
		//��һά�������������
		int[] dp = new int[C+1]; 
				
		//���ѭ������������Ʒ����״̬
		for (int i = 0; i < N; i++) {
			//����ִ�е����dp�����Ѿ�����ֵ�ˣ�����i-1״̬ʱ����������������ֵ��
			
			//�����Ӻ���ǰ����
			//�����ǰ�����ܹ��ŵ��µ�i����Ʒ����ô�͸���i-1״̬��dp[j]��dp[j-w[i]]����i״̬��dp[j]
			//����Ų��µ�i����Ʒ��˵��dp[j]����i-1״̬ʱ��dp[i-1],��dp[j]=dp[j]
			for (int j = C; j >= w[i]; j--) {
				dp[j] = Math.max(dp[j], dp[j-w[i]]+v[i]);
			}
		}
		 return dp[C];
	}
	
	/**
	 * 	�ⷨ2���ݹ鷨
	 * 
	 */
	public static int bag1(int N,int C,int[] w,int[] v) {
		//��̬����dp������¼������Ľ�
		int[][] dp = new int[N][C+1]; 
		 int ret = dfs(C,N-1,w,v,dp);
		 return ret;
	}
	
	
	/**
	 * 	
	 * @param capacity
	 * @param index
	 * @param w
	 * @param v
	 * @param dp
	 * @return
	 */
	private static int dfs(int capacity, int index, int[] w, int[] v, int[][] dp) {
		//�������Ϊ�����߱��������Ѿ�Ϊ���ˣ�����0
		if(index < 0 || capacity <= 0)
			return 0;
		
		//����������Ѿ������Ž⣬ֱ�ӷ��ؾͿ�����
		if(dp[index][capacity] != 0)
			return dp[index][capacity];
		
		//�����ǰ�����������ܷ��µ�indexλ�ô�����Ʒ����ô�����ܼ�ֵ���ǣ�����������Ϊcapacity-w[index]ʱ������ֵ����indexλ�ô���Ʒ�ļ�ֵ
		int v1 = 0;
		if(capacity >= w[index]) {
			v1 = v[index] + dfs(capacity-w[index], index-1, w, v,dp);
		}
		
		//������ŵ�ǰ��Ʒʱ�Ĵ���
		int v2 = dfs(capacity, index-1, w, v,dp);
		
		dp[index][capacity] = Math.max(v1, v2);
		return dp[index][capacity];
	}


	/**
	 * 	�ⷨ1����̬�滮
	 * 	����һ��(N+1)*(C+1)������dp,�������ķ�Χ��0~N���е�������Χ��0~C����0�С���0����0��䣬
	 * 		dp[i][j]��ʾ�ڱ�������ΪC������£��ӵ�1������2��...��i����Ʒ��ѡȡ��Ʒʱ��õ�������
	 * 	dp[i][j]�ļ���������£�
	 * 		1.���j<w[i],Ҳ���ǵ�ǰ�������ܷŵ��µ�i����Ʒ���ǾͲ����������Ʒ�ˣ���ʱ������õ�����ֵ�ͺ�dp[i-1][j]��һ����
	 * 			dp[i][j]=dp[i-1][j]
	 * 		2.���j>=w[i],Ҳ���ǵ�ǰ�������Էŵ��µ�i����Ʒ����ôdp[i][j]���������ֿ����е����ֵ
	 * 			1). �ӱ������ó�w[i]�Ķ������ڳ�j-w[i]�Ŀ���������Ȼ��ѵ�i����Ʒ�Ž�ȥ����ʱ��v1=dp[i-1][j-w[i]]+v[i]
	 * 			2). ����������ŵ�i����Ʒ����ʱ��v2=dp[i-1][j]
	 * 	״̬ת�Ʒ���
	 * 		dp(i,C)=max(dp(i-1,C),v(i)+dp(i-1,C-w(i)))
	 * 
	 * @param N
	 * @param C
	 * @param w
	 * @param v
	 * @return
	 */
	public static int bag(int N,int C,int[] w,int[] v) {
		
		//
		int[][] dp = new int[N+1][C+1];
		
		//i�������Ǵ�1��ʼ�ģ���Ӧ����Ʒ����Ϊi-1
		for (int i = 1; i <= N; i++) {
			
			for (int j = 1; j <= C; j++) {
				//��ǰ�����޷�װ�µ�i-1����Ʒ����ô��ʱ��������ֵ���Ǹ�ֻװ����һ����Ʒ�ļ�ֵ��һ����
				if(j < w[i-1]) {
					dp[i][j] = dp[i-1][j];
				}
				
				//�����ʱ�����������ܹ�װ���µ�i-1����Ʒ����Ҫ����һЩ������
				else {
					int v1 = dp[i-1][j];					//����ʱ���ܼ�ֵ
					int v2 = dp[i-1][j-w[i-1]]+v[i-1];		//�����Ժ���ܼ�ֵ
					dp[i][j] = Math.max(v1, v2);			//ȡ���ֵ
				}
			}
		}
		return dp[N][C];
	}
}