1class Solution {
2    public int[] twoSum(int[] nums, int target) {
3        
4        Map<Integer, Integer> map = new HashMap<>();
5
6        for (int i = 0; i < nums.length; i++) {
7            map.put(nums[i], i);
8        }
9        
10        for (int i = 0; i < nums.length; i++) {
11            int complement = target - nums[i];
12            if (map.containsKey(complement) && map.get(complement) != i) {
13                return new int[] { i, map.get(complement) };
14            }
15        }
16        
17        return new int[] {};
18    }
19}