class Solution {
    private static final long LIMIT = 1_000_001L;

    public String smallestPalindrome(String s, int k) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int[] half = new int[26];
        int len = 0;
        char mid = 0;

        for (int i = 0; i < 26; i++) {
            half[i] = freq[i] / 2;
            len += half[i];
            if ((freq[i] & 1) == 1) {
                mid = (char) ('a' + i);
            }
        }

        long targetK = k;
        if (countWays(half, len) < targetK) {
            return "";
        }

        StringBuilder left = new StringBuilder();

        for (int pos = 0; pos < len; pos++) {
            for (int c = 0; c < 26; c++) {
                if (half[c] == 0) continue;
                half[c]--;
                long ways = countWays(half, len - pos - 1);

                if (ways >= targetK) {
                    left.append((char) ('a' + c));
                    break; 
                }

                targetK -= ways;
                half[c]++;
            }
        }

        StringBuilder ans = new StringBuilder(left);
        if (mid != 0) {
            ans.append(mid);
        }
        ans.append(new StringBuilder(left).reverse());

        return ans.toString();
    }
    private long countWays(int[] cnt, int totalLen) {
        long res = 1;
        int rem = totalLen;

        for (int count : cnt) {
            if (count == 0) continue;
            res = multiplyCapped(res, nCr(rem, count), LIMIT);
            rem -= count;
        }

        return res;
    }

    private long nCr(int n, int r) {
        if (r < 0 || r > n) return 0;
        if (r == 0 || r == n) return 1;
        r = Math.min(r, n - r);

        long res = 1;
        for (int i = 1; i <= r; i++) {
            res = (res * (n - r + i)) / i;
            if (res > LIMIT) return LIMIT;
        }
        return res;
    }

    private long multiplyCapped(long a, long b, long cap) {
        if (a == 0 || b == 0) return 0;
        if (a > cap / b) return cap;
        return Math.min(a * b, cap);
    }
}