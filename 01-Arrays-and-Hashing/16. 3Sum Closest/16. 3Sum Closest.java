1class Solution {
2    public int threeSumClosest(int[] nums, int target) {
3        Arrays.sort(nums);
4        int n = nums.length;
5        int result = nums[0] + nums[1] + nums[2]; // Initial best guess
6
7        for (int i = 0; i < n - 2; i++) {
8            int left = i + 1, right = n - 1;
9
10            while (left < right) {
11                int sum = nums[i] + nums[left] + nums[right];
12
13                if (Math.abs(target - sum) < Math.abs(target - result)) {
14                    result = sum;
15                }
16
17                if (sum == target) return target;
18                else if (sum < target) left++;
19                else right--;
20            }
21        }
22
23        return result;
24    }
25}