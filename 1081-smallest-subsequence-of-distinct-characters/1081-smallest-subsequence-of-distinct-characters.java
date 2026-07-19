class Solution {
    public String smallestSubsequence(String s) {
        int[] count = new int[26];
        boolean[] visited = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        char[] stack = new char[26];
        int top = -1; 
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            count[ch - 'a']--;
            
            if (visited[ch - 'a']) continue;
            while (top >= 0 && stack[top] > ch && count[stack[top] - 'a'] > 0) {
                visited[stack[top] - 'a'] = false;
                top--; 
            }
            stack[++top] = ch; 
            visited[ch - 'a'] = true;
        }
        return new String(stack, 0, top + 1);
    }
}
