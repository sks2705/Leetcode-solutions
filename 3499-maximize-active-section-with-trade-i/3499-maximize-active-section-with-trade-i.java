class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int ones = 0;
        ArrayList<Integer> zeroGroups = new ArrayList<>();

        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '1') {
                ones++;
                i++;
            } else {
                int len = 0;
                while (i < s.length() && s.charAt(i) == '0') {
                    len++;
                    i++;
                }
                zeroGroups.add(len);
            }
        }

        int best = 0;
        for (int j = 0; j + 1 < zeroGroups.size(); j++) {
            best = Math.max(best, zeroGroups.get(j) + zeroGroups.get(j + 1));
        }

        return ones + best;
    }
}