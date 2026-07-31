class MedianFinder {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }

    public void addNum(int num) {

        if(right.size() > 0 && num > right.peek()){
            right.add(num);
        }
        else{
            left.add(num);
        }

        balance();
    }
    public void balance(){
        if(left.size() - right.size() > 1){
            right.add(left.remove());
        }
        else if(right.size() - left.size() > 1){
            left.add(right.remove());
        }

    }
    public double findMedian() {

        if(size() == 0){
            return -1;
        }

        if(left.size() == right.size()){
            return (left.peek() + right.peek()) / 2.0;
        }

        if(left.size() > right.size()){
            return left.peek();
        }

        return right.peek();
    }
    public int size(){
        return left.size() + right.size();
    }
}