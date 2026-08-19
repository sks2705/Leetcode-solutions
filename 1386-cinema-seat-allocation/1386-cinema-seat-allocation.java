class Solution {

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        Map<Integer, Set<Integer>> map =
                new HashMap<>();

        for (int[] seat : reservedSeats) {

            map.putIfAbsent(
                    seat[0],
                    new HashSet<>());

            map.get(seat[0]).add(seat[1]);
        }
        int answer =
                (n - map.size()) * 2;

        for (Set<Integer> seats :
                map.values()) {

            boolean left =
                    !seats.contains(2)
                    && !seats.contains(3)
                    && !seats.contains(4)
                    && !seats.contains(5);

            boolean middle =
                    !seats.contains(4)
                    && !seats.contains(5)
                    && !seats.contains(6)
                    && !seats.contains(7);

            boolean right =
                    !seats.contains(6)
                    && !seats.contains(7)
                    && !seats.contains(8)
                    && !seats.contains(9);

            if (left && right) {
                answer += 2;
            } else if (left
                    || middle
                    || right) {
                answer += 1;
            }
        }
        return answer;
    }
}