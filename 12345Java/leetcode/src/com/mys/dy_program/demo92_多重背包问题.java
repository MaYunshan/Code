package com.mys.dy_program;

/**
 * /**
 * 	���ر�������	
 * 	��N����Ʒ��һ������ΪV�ı�����ÿ����Ʒ�������޵ġ���Ʒ�������ֱ�Ϊw[i]����Ʒ�ļ۸�Ϊv[i]����Ʒ������Ϊc[i]��
 * 	��⽫��Щ��Ʒװ�뱳����ʹ��Щ��Ʒ�ķ����ܺͲ����������������Ҽ�ֵ�ܺ����
 * 	���ر��������01�����������ƣ����ҿ���ת��Ϊ01���������ĳһ����Ʒ����������ô������Ϊ������������Ʒ��ֻ���������ͼ۸���һ����
 * 	�����Ʒ���ܸ���Ϊc[0]+c[1]+.....c[N-1]
 *
 */
 
public class demo92_���ر������� {

	public static void main(String[] args) {
		int N = 6;
		int C = 12;
		int[] w = {4, 6, 2, 2, 5, 1};
		int[] v = {8, 10, 6, 3, 7, 2};
		int[] c = {2, 2, 2, 2, 2, 2};
		
		//�ⷨ1
		int ret = MultipleBag.bag(N, C, w, v, c);
		System.out.println(ret);
		
		//�ⷨ2
		int ret1 = MultipleBag.bag1(N, C, w, v, c);
		System.out.println(ret1);
		
		//�ⷨ3
		int ret2 = MultipleBag.bag2(N, C, w, v, c);
		System.out.println(ret2);
	}

}

class MultipleBag{
	/**
	 * 	�ⷨ1��ת��Ϊ01��������
	 * 	���ö�̬�滮
	 */
	public static int bag(int N,int C,int[] w,int[] v,int[] c) {
		int n = 0;
		//���е���Ʒ�����ĺ;��������Ʒ�ĸ���
		for (int i = 0; i < c.length; i++) {
			n += c[i];
		}
		
		//���¶�����������ͼ�ֵ����
		int[] weight = new int[n];
		int[] value = new int[n];
		int i = 0;
		int k = 0;
		
		//��ԭ�������鰴�ո���չ��
		while(i < N) {
			for (int j = 0; j < c[i]; j++) {
				weight[k] = w[i];
				value[k] = v[i];
				k++;
			}
			i++;
		}
		
		//����һ������ΪC+1������dp
		int[] dp = new int[C+1];
		
		//��ǰi����Ʒ֮��ѡ����Ʒ���뱳��
		for (int ii = 0; ii < n; ii++) {
			for (int j = C; j >= weight[ii]; j--) {
				/**
				 * 	����ѡ����뵱ǰ��Ʒ��Ҳ����ѡ�񲻷�
				 *		���ţ������ļ�ֵv0=dp[j]
				 *		���룬�����ļ�ֵv1=dp[j-weight[ii]]+value[ii]
				 *	��ô����״̬(ii,j)����ʱ������������ֵΪdp[j]=max{v0,v1}
				 */
				dp[j] = Math.max(dp[j], dp[j-weight[ii]]+value[ii]);
			}
		}
		
		return dp[C];
	}
	
	/**
	 * 	�ⷨ2����̬�滮
	 * 	��ά����
	 */
	public static int bag1(int N,int C,int[] w,int[] v,int[] c) {
		
		int[][] dp = new int[N][C+1];
		
		//��ѡ������һ����Ʒʱ�������ļ�ֵ
		for (int j = 1; j <= C; j++) {
			if(j/w[0] <= c[0]) {
				dp[0][j] = j/w[0]*v[0];
			}else {
				dp[0][j] = c[0]*v[0];
			}
		}
		
		for (int i = 1; i < N; i++) {
			for (int j = 1; j <= C; j++) {
				//�����ǰ������������w[i]������������ֵ��������w[i]�ļ�ֵһ��
				if(j < w[i])
					dp[i][j] = dp[i-1][j];
				//�����ǰ����������j�ܹ�����w[i]����Ҫ�������ɼ���w[i]��
				else {
					/**
					 * 	k=0������0��w[i]�������ļ�ֵΪ��v0=dp[i-1][j]
					 * 	k=1������1��w[i]�������ļ�ֵΪ��v1=dp[i-1][j-w[i]]+v[i]
					 * 	�򱳰�������ֵΪ��v01=dp[i][j]=max{v0,v1},��������w[i]
					 * 	k=2������2��w[i]�������ļ�ֵΪ��v2=dp[i-1][j-2*w[i]]+2*v[i]
					 * 	......
					 * 	�򱳰�������dp[i][j]=max{v01��v1}=max{v0,v1,v2}
					 * 	k<=c[i]
					 * 	��󣬱����ļ�ֵΪdp[i][j]=max{v0,v1,v2...vk}
					 */
					for (int k = 1; k <= c[i] && j >= k*w[i]; k++) {
						dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-k*w[i]]+k*v[i]);
					}
				}
				
			}
		}
		return dp[N-1][C];
	}
	
	/**
	 * 	�ⷨ3����̬�滮
	 * 	һά����
	 */
	public static int bag2(int N,int C,int[] w,int[] v,int[] c) {
		
		int[] dp = new int[C+1];
		
		for (int i = 0; i < N; i++) {
			for (int j = C; j >= w[i]; j--) {
				if(j >= w[i]) {
					//�����ǰ�����ܹ�����w[i]�����ҷ��õĸ���������c[i]���Ǿ�һֱ�ţ�����ȡ���ֵ
					for (int k = 1; k <= c[i] && j >= k*w[i]; k++) {
						dp[j] = Math.max(dp[j], dp[j-k*w[i]]+k*v[i]);
					}
				}
			}
		}
		return dp[C];
	}
}
