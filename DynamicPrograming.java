package allQuestions;

import java.util.*;

public class DynamicPrograming {

	public static void main(String[] args) {
		// System.out.println(minChange(19, new HashMap<Integer, Integer>()));
//		int Weights[] = { 1, 2, 3 };
//		int Values[] = { 6, 10, 12 };
//		int Capacity = 5;
		// Expected Output: 22

//		int[][] dp = new int[Values.length + 1][Capacity + 1];
//		for (int[] row : dp)
//			Arrays.fill(row, -1);

//		String s1 = "kitten";
//		String s2 = "sitting";
//		// ✅ Output: 3

//		int[][] dp = new int[s1.length()][s2.length()];
//		for (int[] row : dp)
//			Arrays.fill(row, -1);
//
//		int[] lengths = { 1, 2, 3 };
//		int[] prices = { 10, 15, 40 };
//		int n = 5;
//		// ✅ Expected Output: 70

		// int dp[] = new int[n + 1];
		// Arrays.fill(dp, -1);

//
//		System.out.println(longestSubSeq(s1, s2, 0, 0, dp));

		// System.out.println(knapSack(Capacity, Weights, Values, 0, dp));
		// System.out.println(nSteps(7046319384L, new HashMap<Long, Long>()));

		// System.out.println(editDistance(s1, s2, 0, 0, dp));

		// System.out.println(maxProfit(n, lengths, prices, dp));

//		int[][] matrix = {
//			    { -3, -4, -1 },
//			    { -5, -6, -2 },
//			    { -7, -8, -9 }
//			};
//		System.out.println(maxSumMatrix(matrix.length, matrix[0].length, matrix));

		//System.out.println(stairCaseCount(10));
		System.out.println(minSquareToNum(9999));

	}

	public static int minChange(int value, HashMap<Integer, Integer> dp) {
		if (value < 0)
			return Integer.MAX_VALUE;
		if (value == 0)
			return 0;

		int oneDenomination = Integer.MAX_VALUE, fiveDenomination = Integer.MAX_VALUE,
				sevenDenomination = Integer.MAX_VALUE;

		if (!dp.containsKey(value)) {
			oneDenomination = minChange(value - 1, dp);
			fiveDenomination = minChange(value - 5, dp);
			sevenDenomination = minChange(value - 7, dp);
			int min = Math.min(oneDenomination, Math.min(fiveDenomination, sevenDenomination));
			dp.put(value, (min == Integer.MAX_VALUE) ? Integer.MAX_VALUE : min + 1);
			// System.out.println(value + " "+ min);
			return min + 1;
		} else {
			// System.out.println(dp.get(value)+" "+value);
			return dp.get(value);
		}

	}

	public static Long nSteps(Long steps, HashMap<Long, Long> dp) {
		if (steps < 0)
			return 0L;

		if (steps == 0)
			return 1L;

		if (!dp.containsKey(steps)) {
			Long ways = 0L;
			ways += nSteps(steps - 1, dp);
			ways += nSteps(steps - 2, dp);
			ways += nSteps(steps - 3, dp);
			dp.put(steps, ways);
			return ways;
		} else {
			return dp.get(steps);
		}

	}

	public static int minSquare(int num) {
		if (num == 1 || num == 2)
			return num;

		int dp[] = new int[num + 1];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 1; i <= num; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 1; j <= i; j++) {
				if (min > dp[i - j * j])
					min = dp[i - j * j];
			}
			dp[i] = min + 1;
		}
		return dp[num + 1];
	}

	public static int knapSack(int capacity, int[] weights, int[] values, int index, int[][] dp) {
		if (capacity <= 0 || index >= weights.length) {
			return 0;
		}

		if (dp[index][capacity] != -1) {
			return dp[index][capacity];
		}

		if (weights[index] > capacity) {
			dp[index][capacity] = knapSack(capacity, weights, values, index + 1, dp);
		} else {
			int include = values[index] + knapSack(capacity - weights[index], weights, values, index + 1, dp);

			int exclude = knapSack(capacity, weights, values, index + 1, dp);

			dp[index][capacity] = Math.max(include, exclude);
		}

		return dp[index][capacity];
	}

	public static int longestSubSeq(String s, String a, int i1, int i2, int dp[][]) {
		if (s.length() <= i1 || a.length() <= i2)
			return 0;

		if (dp[i1][i2] == -1) {
			if (s.charAt(i1) == a.charAt(i2)) {
				int res = 1 + longestSubSeq(s, a, i1 + 1, i2 + 1, dp);
				dp[i1][i2] = res;
				return res;
			} else {
				int excludeFirst = longestSubSeq(s, a, i1 + 1, i2, dp);
				int excludeSecond = longestSubSeq(s, a, i1, i2 + 1, dp);
				int max = Math.max(excludeFirst, excludeSecond);
				dp[i1][i2] = max;
				return max;
			}
		} else {
			return dp[i1][i2];
		}

	}

	public static int minStepsToString(String s, String a) {
		if (s.length() == 0)
			return a.length();
		if (a.length() == 0)
			return s.length();

		if (s.charAt(0) == a.charAt(0)) {
			return minStepsToString(s.substring(1), a.substring(1)); // no cost
		} else {
			int delete = 1 + minStepsToString(s.substring(1), a); // delete s[0]
			int insert = 1 + minStepsToString(s, a.substring(1)); // insert a[0]
			return Math.min(delete, insert);
		}
	}

	public static int editDistance(String s, String a, int i, int j, int[][] dp) {
		if (s.length() <= i)
			return a.length() - j;
		if (a.length() <= j)
			return s.length() - i;

		if (dp[i][j] == -1) {
			if (s.charAt(i) == a.charAt(j)) {
				dp[i][j] = editDistance(s, a, i + 1, j + 1, dp);
				return dp[i][j];
			} else {
				dp[i][j] = 1 + Math.min(editDistance(s, a, i + 1, j, dp),
						Math.min(editDistance(s, a, i + 1, j + 1, dp), editDistance(s, a, i, j + 1, dp)));
				return dp[i][j];
				// removing , replacing , adding character
			}
		} else {
			return dp[i][j];
		}

	}

	public static int maxProfit(int size, int[] len, int[] val, int dp[]) {
		if (size <= 0)
			return 0;

		int maxP = 0;
		if (dp[size] == -1) {
			for (int i = 0; i < val.length; i++) {
				int maxLocal = Integer.MIN_VALUE;
				if ((size - len[i]) >= 0)
					maxLocal = maxProfit(size - len[i], len, val, dp) + val[i];
				if (maxP < maxLocal)
					maxP = maxLocal;
			}
			dp[size] = maxP;
		} else {
			maxP = dp[size];
		}
		return maxP;

	}

	public static int maxSumMatrix(int r, int c, int m[][]) {
		if (m.length == 0)
			return 0;

		int result = Integer.MIN_VALUE;
		for (int i = 0; i < c; i++) {
			int arr[] = new int[r];
			for (int j = i; j < c; j++) {
				for (int k = 0; k < r; k++) {
					arr[k] = arr[k] + m[k][j];
				}
				int maxLocal = KadanesAlgo(arr);
				if (maxLocal > result)
					result = maxLocal;
			}
		}

		return result;
	}

	public static int KadanesAlgo(int arr[]) {
		int res = Integer.MIN_VALUE, max = 0;

		for (int i = 0; i < arr.length; i++) {
			max += arr[i];
			if (res < max)
				res = max;
			if (max < 0)
				max = 0;
		}
		return res;
	}

	public static long stairCaseCount(int n) {
		if (n == 0 || n == 1)
			return 1;

		int steps[] = new int[n + 1];
		steps[0] = 1;
		steps[1] = 1;
		for (int i = 2; i < steps.length; i++) {
			int count = steps[i - 1];
			count += steps[i - 2];
			if ((i - 3) >= 0)
				count += steps[i - 3];
			steps[i] = count;
		}
		System.out.println(Arrays.toString(steps));

		return steps[steps.length - 1];
	}

	public static int minSquareToNum(int n) {
		if (n == 0 || n == 1)
			return n;

		int count[] = new int[n + 1];
		count[0] = 0;
		count[1] = 1;

		for (int i = 2; i < count.length; i++) {
			int res = Integer.MAX_VALUE;
			for (int j = 1; (i - j * j) >= 0; j++) {
				int localRes = 1 + count[i - j * j];
				if (res > localRes)
					res = localRes;
			}
			count[i]=res;
		}
		return count[n];
	}

}
