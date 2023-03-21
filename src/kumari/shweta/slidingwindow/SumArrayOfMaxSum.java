/**
 * @author Shweta Kumari
 *2023-03-19 12:17:34 pm
 */
package kumari.shweta.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.text.StyledEditorKit.ForegroundAction;

/*Find maximum sum of sub array
 * Inpput [-3,4,-2,5,3,-2,8,2,-1,4] size of subArray 5
 * Output 16 sum of subarray[5,3,-2,8,2]
 * 
 */
public class SumArrayOfMaxSum {
	// Brute force approach 1  ) best and average TC O(N) worst case TC O(N^2), SC O(1)
	static int maximumSumOfSubArray(List<Integer> list, int K) {
		int maxsum = Integer.MIN_VALUE;
		for (int i = 0; i <= list.size() - K; i++) {
			int start = i;
			int end = i + K - 1;
			int sum = 0;
			for (int k = start; k <= end; k++) {
				sum = sum + list.get(k);
			}

			if (sum > maxsum) {
				maxsum = sum;
			}
		}
		return maxsum;

	}

	// 2nd Brute force approach best and average TC O(N) worst case TC O(N^2), SC O(1)
	static int maximumSumOfSubArray1(List<Integer> list, int K) {
		int s = 0, e = K - 1, ans = Integer.MIN_VALUE;
		while (e < list.size() || s <= list.size() - K) {
			int sum = 0;
			for (int i = s; i <= e; i++) {
				sum = sum + list.get(i);
			}
			if (sum > ans) {
				ans = sum;
			}
			s++;
			e++;
		}
		return ans;
	}

	//Optimized approach -->Use prefix sum for adding element of subarray TC O(N) in all case SC(N)
	
	static int optimizedMaxSumOfArray(List<Integer> list, int K) {
		List<Integer> prefixSum = new ArrayList<>();
		// Prefix sum start
		prefixSum.add(list.get(0));
		for (int i = 1; i < list.size(); i++) {
			int sumOnIth = prefixSum.get(i - 1) + list.get(i);
			prefixSum.add(sumOnIth);
		}
		// Prefix sum end
		int s = 0, e = K - 1, ans = Integer.MIN_VALUE;
		while (e < list.size() || s <= list.size() - K) {
			int sum = 0;
			if (s == 0) {
				sum = prefixSum.get(e);
			} else {
				sum = prefixSum.get(e) - prefixSum.get(s - 1);
			}
			if (sum > ans) {
				ans = sum;
			}
			s++;
			e++;
		}
		return ans;
	}
	
	//Optimized to reduce SC(1) 
	static int slidingWindowFindMax(List<Integer> list,int K) {
		int sum=0,ans=Integer.MIN_VALUE;
		for(int i=0;i<K-1;i++) {  
			sum+=list.get(i);
		}
		int s=1,e=K;
		while(e<list.size()|| s<=list.size()-K) {
			sum+=list.get(e)-list.get(s-1);
			if(sum>ans) {
				ans=sum;
			}
		}
		return ans;
		
	}
	
	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(-3, 4, -2, 5, 3, -2, 8, 2, -1, 4);
		
		int sum = maximumSumOfSubArray(list, 5);
		System.out.println("Maximum sum of subarray" + sum);
		
		int sum1 = maximumSumOfSubArray1(list, 5);
		System.out.println("Maixmum sum of subarray with Brute force appraoch" + sum1);
		
		int maxsum=optimizedMaxSumOfArray(list,5);
		System.out.println("Maximum sum of subarray with prefix sum "+maxsum);
		
		int maxsum1=slidingWindowFindMax(list,5);
		System.out.println("Sub array with maximum sum using sliding window approach"+maxsum1);
		
	}
}
