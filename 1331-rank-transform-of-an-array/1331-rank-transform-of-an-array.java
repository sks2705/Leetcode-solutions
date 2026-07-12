class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int [] num= new int[arr.length];
        int [] result=new int[arr.length];
        HashMap<Integer,Integer>hm=new LinkedHashMap<>();
        for(int i=0;i<arr.length;i++){
            num[i] =arr[i];
        } 
        Arrays.sort(num);
        int rank =1;
        for(int i =0;i<num.length;i++){
            if(!hm.containsKey(num[i])){
                hm.put(num[i],rank);
                rank++;
            }
        }
        for(int i =0;i<arr.length;i++){
            result[i]=hm.get(arr[i]);
        }
        return result;
    }
}