class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length, n = classroom[0].length();
        int sr = 0, sc = 0, count = 0;

        int[][] id = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (classroom[i].charAt(j) == 'S') {
                    sr = i;
                    sc = j;
                } else if (classroom[i].charAt(j) == 'L') {
                    id[i][j] = count++;
                }
            }
        }

        if (count == 0) return 0;

        int fullMask = (1 << count) - 1;
        boolean[][][][] visited = new boolean[m][n][energy + 1][1 << count];

        java.util.ArrayDeque<int[]> queue = new java.util.ArrayDeque<>();
        queue.offer(new int[]{sr, sc, energy, 0});

        visited[sr][sc][energy][0] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            moves++;

            while (size-- > 0) {
                int[] cur = queue.poll();

                int r = cur[0];
                int c = cur[1];
                int e = cur[2];
                int mask = cur[3];

                if (e == 0) continue;

                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;

                    char cell = classroom[nr].charAt(nc);

                    if (cell == 'X') continue;

                    int ne = e - 1;
                    int newMask = mask;

                    if (cell == 'R') ne = energy;

                    if (cell == 'L') {
                        newMask |= 1 << id[nr][nc];
                    }

                    if (newMask == fullMask) return moves;

                    if (!visited[nr][nc][ne][newMask]) {
                        visited[nr][nc][ne][newMask] = true;
                        queue.offer(new int[]{nr, nc, ne, newMask});
                    }
                }
            }
        }

        return -1;
    }
}