1class Solution {
2    public int largestInteger(int[] nums, int k) {
3
4        int n = nums.length;
5
6        HashMap<Integer,Integer> hm = new HashMap<>();
7
8        for(int i = 0; i < n; i++){
9            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
10        }
11
12        if(k == 1){            
13            int max = -1;
14            for(int i = 0; i < n; i++){
15                if(hm.get(nums[i]) == 1 && nums[i] > max){
16                    max = nums[i];
17                }
18            }
19
20            return max;
21        }
22
23        if(k == n){
24            int max = Integer.MIN_VALUE;
25            for(int i = 0; i < n; i++){
26                max = Math.max(max, nums[i]);
27            }
28            return max;
29        }
30
31        if(nums[0] == nums[n-1]){
32            return -1;
33        }
34
35        if(hm.get(nums[0]) == 1 && hm.get(nums[n-1]) == 1){
36            return Math.max(nums[0], nums[n-1]);
37        }
38        
39        if(hm.get(nums[0]) > 1 && hm.get(nums[n-1]) == 1){
40            return nums[n-1];
41        }
42
43        if(hm.get(nums[0]) == 1 && hm.get(nums[n-1]) > 1){
44            return nums[0];
45        }
46        return -1;
47    }
48}