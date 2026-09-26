class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for (int asteroid : asteroids) {
            boolean alive = true;
            if (asteroid > 0) {
                st.push(asteroid);
            } 
            else {
                while (!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(asteroid)) {
                    st.pop();
                }
                if (!st.isEmpty() && st.peek() == Math.abs(asteroid)) {
                    st.pop();
                    alive = false;
                }
                else if (st.isEmpty() || st.peek() < 0) {
                    st.push(asteroid);
                }
            }
        }
        int[] result = new int[st.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = st.pop();
        }
        return result;
    }
}