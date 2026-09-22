class Solution {
    int n, K;
    int[] prodTree;
    int[][] cntTree;
    int[] holder = new int[1]; // carries "prod" out of query()

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        n = nums.length;
        K = k;
        prodTree = new int[4 * n];
        cntTree = new int[4 * n][K];
        build(1, 0, n - 1, nums);

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int idx = queries[i][0], val = queries[i][1];
            int start = queries[i][2], x = queries[i][3];

            update(1, 0, n - 1, idx, val);

            int[] cnt = query(1, 0, n - 1, start, n - 1);
            result[i] = cnt[x];
        }
        return result;
    }

    private void build(int node, int l, int r, int[] nums) {
        if (l == r) {
            int v = nums[l] % K;
            cntTree[node][v] = 1;
            prodTree[node] = v;
            return;
        }
        int mid = (l + r) / 2;
        build(2 * node, l, mid, nums);
        build(2 * node + 1, mid + 1, r, nums);
        pull(node);
    }

    private void pull(int node) {
        int left = 2 * node, right = 2 * node + 1;
        int lp = prodTree[left], rp = prodTree[right];
        prodTree[node] = (lp * rp) % K;

        int[] res = new int[K];
        for (int v = 0; v < K; v++) res[v] = cntTree[left][v];
        for (int v = 0; v < K; v++) {
            if (cntTree[right][v] == 0) continue;
            int idx = (lp * v) % K;
            res[idx] += cntTree[right][v];
        }
        cntTree[node] = res;
    }

    private void update(int node, int l, int r, int pos, int val) {
        if (l == r) {
            int v = val % K;
            int[] c = new int[K];
            c[v] = 1;
            cntTree[node] = c;
            prodTree[node] = v;
            return;
        }
        int mid = (l + r) / 2;
        if (pos <= mid) update(2 * node, l, mid, pos, val);
        else update(2 * node + 1, mid + 1, r, pos, val);
        pull(node);
    }

    private int[] query(int node, int l, int r, int ql, int qr) {
        if (qr < l || r < ql) {
            holder[0] = 1 % K;
            return new int[K];
        }
        if (ql <= l && r <= qr) {
            holder[0] = prodTree[node];
            return cntTree[node];
        }
        int mid = (l + r) / 2;
        int[] leftCnt = query(2 * node, l, mid, ql, qr);
        int leftProd = holder[0];
        int[] rightCnt = query(2 * node + 1, mid + 1, r, ql, qr);
        int rightProd = holder[0];

        int[] res = new int[K];
        for (int v = 0; v < K; v++) res[v] = leftCnt[v];
        for (int v = 0; v < K; v++) {
            if (rightCnt[v] == 0) continue;
            int idx = (leftProd * v) % K;
            res[idx] += rightCnt[v];
        }
        holder[0] = (leftProd * rightProd) % K;
        return res;
    }
}