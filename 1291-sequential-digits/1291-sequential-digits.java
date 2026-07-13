public class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= 8; i++) {
            queue.add(i);
        }
        
        while (!queue.isEmpty()) {
            int num = queue.poll();
            if (num >= low && num <= high) {
                result.add(num);
            }
            if (num > high) {
                continue;
            }
            int lastDigit = num % 10;
            if (lastDigit < 9) {
                int nextNum = num * 10 + (lastDigit + 1);
                queue.add(nextNum);
            }
        }
        return result;
    }
}
