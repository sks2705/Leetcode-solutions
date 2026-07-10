import java.util.Arrays;

class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums[i];
            pairs[i][1] = i;
        }
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));
        int[] pos = new int[n];
        for (int i = 0; i < n; i++) {
            pos[pairs[i][1]] = i;
        }
        int LOG = 20; 
        int[][] f = new int[n][LOG];
        
        int r = 0;
        for (int l = 0; l < n; l++) {
            while (r < n && pairs[r][0] - pairs[l][0] <= maxDiff) {
                r++;
            }
            f[l][0] = r - 1; 
        }
        for (int k = 1; k < LOG; k++) {
            for (int i = 0; i < n; i++) {
                f[i][k] = f[f[i][k - 1]][k - 1];
            }
        }
        int[] ans = new int[queries.length];
        for (int t = 0; t < queries.length; t++) {
            int u = pos[queries[t][0]];
            int v = pos[queries[t][1]];
            if (u > v) {
                int temp = u;
                u = v;
                v = temp;
            }

            if (u == v) {
                ans[t] = 0;
                continue;
            }

            int steps = 0;
            int curr = u;
            for (int k = LOG - 1; k >= 0; k--) {
                if (f[curr][k] < v) {
                    curr = f[curr][k];
                    steps += (1 << k);
                }
            }
            if (f[curr][0] >= v) {
                ans[t] = steps + 1;
            } else {
                ans[t] = -1; 
            }
        }

        return ans;
    }
}
