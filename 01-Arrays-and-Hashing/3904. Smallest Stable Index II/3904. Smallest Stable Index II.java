1class Solution {
2
3    public int firstStableIndex(int[] nums, int k) {
4        int n = nums.length;
5        int[] minValue = new int[n];
6        minValue[n - 1] = nums[n - 1];
7        for (int i = n - 2; i >= 0; i--) {
8            minValue[i] = Math.min(minValue[i + 1], nums[i]);
9        }
10
11        int maxValue = 0;
12        for (int i = 0; i < n; i++) {
13            maxValue = Math.max(maxValue, nums[i]);
14            if (maxValue - minValue[i] <= k) {
15                return i;
16            }
17        }
18        return -1;
19    }
20}