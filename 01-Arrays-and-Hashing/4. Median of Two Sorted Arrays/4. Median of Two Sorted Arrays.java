1class Solution {
2    private int p1 = 0, p2 = 0;
3
4    // Get the smaller value between nums1[p1] and nums2[p2] and move the pointer forwards.
5
6    private int getMin(int[] nums1, int[] nums2) {
7        if (p1 < nums1.length && p2 < nums2.length) {
8            return nums1[p1] < nums2[p2] ? nums1[p1++] : nums2[p2++];
9        } else if (p1 < nums1.length) {
10            return nums1[p1++];
11        } else if (p2 < nums2.length) {
12            return nums2[p2++];
13        }
14        return -1;
15    }
16
17    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
18        int m = nums1.length, n = nums2.length;
19        if ((m + n) % 2 == 0) {
20            for (int i = 0; i < (m + n) / 2 - 1; ++i) {
21                int tmp = getMin(nums1, nums2);
22            }
23            return (double) (getMin(nums1, nums2) + getMin(nums1, nums2)) / 2;
24        } else {
25            for (int i = 0; i < (m + n) / 2; ++i) {
26                int tmp = getMin(nums1, nums2);
27            }
28            return getMin(nums1, nums2);
29        }
30    }
31}