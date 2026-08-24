1class Solution {
2
3    public int stoneGameVIII(int[] stones) {
4        int n = stones.length;
5        int[] pre = new int[n];
6        pre[0] = stones[0];
7        for (int i = 1; i < n; i++) {
8            pre[i] = pre[i - 1] + stones[i];
9        }
10
11        int[] f = new int[n];
12        f[n - 1] = pre[n - 1];
13        for (int i = n - 2; i >= 1; i--) {
14            f[i] = Math.max(f[i + 1], pre[i] - f[i + 1]);
15        }
16        return f[1];
17    }
18}