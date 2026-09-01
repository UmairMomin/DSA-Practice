1class Solution {
2
3    static final int[] dx = { 0, 1, 0, -1 };
4    static final int[] dy = { 1, 0, -1, 0 };
5
6    public int minMoves(String[] classroom, int energy) {
7        int m = classroom.length;
8        int n = classroom[0].length();
9        int[][] id = new int[m][n];
10        int sx = 0,
11            sy = 0,
12            cnt = 0;
13        for (int i = 0; i < m; i++) {
14            for (int j = 0; j < n; j++) {
15                char c = classroom[i].charAt(j);
16                if (c == 'S') {
17                    sx = i;
18                    sy = j;
19                } else if (c == 'L') {
20                    id[i][j] = 1 << cnt;
21                    cnt++;
22                }
23            }
24        }
25        int full = 1 << cnt;
26        int[][][] bestEnergy = new int[m][n][full];
27        for (int i = 0; i < m; i++) {
28            for (int j = 0; j < n; j++) {
29                Arrays.fill(bestEnergy[i][j], -1);
30            }
31        }
32
33        bestEnergy[sx][sy][0] = energy;
34
35        class Info {
36
37            int x, y, mask, e, steps;
38
39            Info(int x, int y, int mask, int e, int steps) {
40                this.x = x;
41                this.y = y;
42                this.mask = mask;
43                this.e = e;
44                this.steps = steps;
45            }
46        }
47        Deque<Info> q = new ArrayDeque<>();
48        q.addLast(new Info(sx, sy, 0, energy, 0));
49        while (!q.isEmpty()) {
50            Info t = q.removeFirst();
51            if (t.mask == full - 1) {
52                return t.steps;
53            }
54            if (t.e == 0) {
55                continue;
56            }
57            for (int d = 0; d < 4; d++) {
58                int nx = t.x + dx[d];
59                int ny = t.y + dy[d];
60                if (
61                    nx < 0 ||
62                    nx >= m ||
63                    ny < 0 ||
64                    ny >= n ||
65                    classroom[nx].charAt(ny) == 'X'
66                ) {
67                    continue;
68                }
69                int ne = classroom[nx].charAt(ny) == 'R' ? energy : t.e - 1;
70                int nmask = t.mask | id[nx][ny];
71                if (ne > bestEnergy[nx][ny][nmask]) {
72                    bestEnergy[nx][ny][nmask] = ne;
73                    q.addLast(new Info(nx, ny, nmask, ne, t.steps + 1));
74                }
75            }
76        }
77        return -1;
78    }
79}