1class Solution {
2    public int[] resultArray(int[] nums) {
3        int[] nums1 = new int[nums.length];
4        int[] nums2 = new int[nums.length];
5        int n1 = 0;
6        int n2 = 0;
7
8        for (int i = 0; i < nums.length; i++) {
9            if (i == 0) {
10                nums1[n1++] = nums[i];
11            } else if (i == 1) {
12                nums2[n2++] = nums[i];
13            } else {
14                if (nums1[n1 - 1] > nums2[n2 - 1]) {
15                    nums1[n1++] = nums[i];
16                } else {
17                    nums2[n2++] = nums[i];
18                }
19            }
20        }
21
22        for (int i = 0; i < n2; i++) {
23            nums1[n1++] = nums2[i];
24        }
25
26        return nums1;
27    }
28}