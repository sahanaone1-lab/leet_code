class Solution {

    class Node {
        int len;
        int prefix;
        int suffix;
        int best;
        char leftChar;
        char rightChar;

        Node(int len, int prefix, int suffix, int best,
             char leftChar, char rightChar) {
            this.len = len;
            this.prefix = prefix;
            this.suffix = suffix;
            this.best = best;
            this.leftChar = leftChar;
            this.rightChar = rightChar;
        }
    }

    Node[] tree;
    char[] arr;

    public int[] longestRepeating(String s, String queryCharacters,
                                   int[] queryIndices) {

        int n = s.length();
        int k = queryIndices.length;

        arr = s.toCharArray();
        tree = new Node[4 * n];

        build(1, 0, n - 1);

        int[] answer = new int[k];

        for (int i = 0; i < k; i++) {

            int index = queryIndices[i];
            char ch = queryCharacters.charAt(i);

            arr[index] = ch;

            update(1, 0, n - 1, index);

            answer[i] = tree[1].best;
        }

        return answer;
    }

    void build(int node, int start, int end) {

        if (start == end) {
            char ch = arr[start];

            tree[node] = new Node(
                1,
                1,
                1,
                1,
                ch,
                ch
            );

            return;
        }

        int mid = (start + end) / 2;

        build(node * 2, start, mid);
        build(node * 2 + 1, mid + 1, end);

        tree[node] = merge(tree[node * 2],
                           tree[node * 2 + 1]);
    }

    void update(int node, int start, int end, int index) {

        if (start == end) {

            char ch = arr[index];

            tree[node] = new Node(
                1,
                1,
                1,
                1,
                ch,
                ch
            );

            return;
        }

        int mid = (start + end) / 2;

        if (index <= mid) {
            update(node * 2, start, mid, index);
        } else {
            update(node * 2 + 1, mid + 1, end, index);
        }

        tree[node] = merge(tree[node * 2],
                           tree[node * 2 + 1]);
    }

    Node merge(Node left, Node right) {

        int len = left.len + right.len;

        int prefix = left.prefix;
        int suffix = right.suffix;

        int best = Math.max(left.best, right.best);

        // Can combine suffix of left + prefix of right
        if (left.rightChar == right.leftChar) {

            best = Math.max(
                best,
                left.suffix + right.prefix
            );

            // Entire left part has the same character
            if (left.prefix == left.len) {
                prefix = left.len + right.prefix;
            }

            // Entire right part has the same character
            if (right.suffix == right.len) {
                suffix = right.len + left.suffix;
            }
        }

        return new Node(
            len,
            prefix,
            suffix,
            best,
            left.leftChar,
            right.rightChar
        );
    }
}