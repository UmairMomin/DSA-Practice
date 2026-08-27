1class Solution {
2
3    public String lexGreaterPermutation(String s, String target) {
4        int[] cnt = new int[26];
5        for (char c : s.toCharArray()) {
6            cnt[c - 'a']++;
7        }
8
9        StringBuilder res = new StringBuilder();
10        int n = target.length();
11        for (int i = 0; i < n; i++) {
12            int targetChar = target.charAt(i) - 'a';
13
14            // Case 1: First try to place the same character as target[i] at the current position
15            if (cnt[targetChar] > 0) {
16                cnt[targetChar]--;
17                // Check if the remaining characters can form a string greater than target[i+1:]
18                if (canFormGreater(cnt, target, i + 1)) {
19                    res.append(target.charAt(i));
20                    continue;
21                }
22                // Cannot form a larger string, backtrack
23                cnt[targetChar]++;
24            }
25
26            // Case 2: Place a character greater than target[i] at the current position
27            for (int j = targetChar + 1; j < 26; j++) {
28                if (cnt[j] > 0) {
29                    cnt[j]--;
30                    res.append((char) ('a' + j));
31                    // Fill remaining positions with the smallest lexicographical order
32                    res.append(getMinString(cnt));
33                    return res.toString();
34                }
35            }
36
37            // No feasible solution found, return directly
38            return ;
39        }
40
41        return ;
42    }
43
44    // Check if the remaining characters can form a string greater than the suffix.
45    private boolean canFormGreater(int[] cnt, String target, int start) {
46        String maxStr = getMaxString(cnt);
47        String suffix = target.substring(start);
48        return maxStr.compareTo(suffix) > 0;
49    }
50
51    // Get the maximum lexicographical string (in descending order)
52    private String getMaxString(int[] cnt) {
53        StringBuilder res = new StringBuilder();
54        for (int i = 25; i >= 0; i--) {
55            if (cnt[i] > 0) {
56                res.append(String.valueOf((char) ('a' + i)).repeat(cnt[i]));
57            }
58        }
59        return res.toString();
60    }
61
62    // Get the lexicographically smallest string (in ascending order)
63    private String getMinString(int[] cnt) {
64        StringBuilder res = new StringBuilder();
65        for (int i = 0; i < 26; i++) {
66            if (cnt[i] > 0) {
67                res.append(String.valueOf((char) ('a' + i)).repeat(cnt[i]));
68            }
69        }
70        return res.toString();
71    }
72}