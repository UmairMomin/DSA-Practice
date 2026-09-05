1public class Solution {
2
3    public int firstStableIndex(int[] nums, int k) {
4        int n = nums.length;
5        for (int i = 0; i < n; i++) {
6            int maxValue = nums[i];
7            int minValue = nums[i];
8            for (int j = 0; j < i; j++) {
9                maxValue = Math.max(maxValue, nums[j]);
10            }
11            for (int j = i + 1; j < n; j++) {
12                minValue = Math.min(minValue, nums[j]);
13            }
14            if (maxValue - minValue <= k) {
15                return i;
16            }
17        }
18        return -1;
19    }
20}