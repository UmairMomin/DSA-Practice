1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode() {}
7 *     ListNode(int val) { this.val = val; }
8 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
9 * }
10 */
11class Solution {
12
13    public int[] nodesBetweenCriticalPoints(ListNode head) {
14        int[] result = { -1, -1 };
15
16        // Initialize minimum distance to the maximum possible value
17        int minDistance = Integer.MAX_VALUE;
18
19        // Pointers to track the previous node, current node, and indices
20        ListNode previousNode = head;
21        ListNode currentNode = head.next;
22        int currentIndex = 1;
23        int previousCriticalIndex = 0;
24        int firstCriticalIndex = 0;
25
26        while (currentNode.next != null) {
27            // Check if the current node is a local maxima or minima
28            if (
29                (currentNode.val < previousNode.val &&
30                    currentNode.val < currentNode.next.val) ||
31                (currentNode.val > previousNode.val &&
32                    currentNode.val > currentNode.next.val)
33            ) {
34                // If this is the first critical point found
35                if (previousCriticalIndex == 0) {
36                    previousCriticalIndex = currentIndex;
37                    firstCriticalIndex = currentIndex;
38                } else {
39                    // Calculate the minimum distance between critical points
40                    minDistance = Math.min(
41                        minDistance,
42                        currentIndex - previousCriticalIndex
43                    );
44                    previousCriticalIndex = currentIndex;
45                }
46            }
47
48            // Move to the next node and update indices
49            currentIndex++;
50            previousNode = currentNode;
51            currentNode = currentNode.next;
52        }
53
54        // If at least two critical points were found
55        if (minDistance != Integer.MAX_VALUE) {
56            int maxDistance = previousCriticalIndex - firstCriticalIndex;
57            result = new int[] { minDistance, maxDistance };
58        }
59
60        return result;
61    }
62}