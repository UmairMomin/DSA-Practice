1class Solution {
2
3    public boolean uniformArray(int[] nums1) {
4        int mn = nums1[0];
5        boolean hasOdd = false;
6        for (int v : nums1) {
7            if (v < mn) {
8                mn = v;
9            }
10            if ((v & 1) == 1) {
11                hasOdd = true;
12            }
13        }
14        if ((mn & 1) == 1) {
15            return true;
16        }
17        return !hasOdd;
18    }
19}