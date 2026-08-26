1class Solution {
2    public String shortestBeautifulSubstring(String s, int k) {
3        String answer = ;
4        int left = 0;
5        int ones = 0;
6
7        for (int right = 0; right < s.length(); right++) {
8            if (s.charAt(right) == '1') {
9                ones++;
10            }
11
12            while (ones > k) {
13                if (s.charAt(left) == '1') {
14                    ones--;
15                }
16                left++;
17            }
18
19            while (ones == k && s.charAt(left) == '0') {
20                left++;
21            }
22
23            if (ones == k) {
24                String candidate = s.substring(left, right + 1);
25
26                if (answer.isEmpty() ||
27                    candidate.length() < answer.length() ||
28                    (candidate.length() == answer.length() &&
29                     candidate.compareTo(answer) < 0)) {
30                    answer = candidate;
31                }
32            }
33        }
34
35        return answer;
36    }
37}