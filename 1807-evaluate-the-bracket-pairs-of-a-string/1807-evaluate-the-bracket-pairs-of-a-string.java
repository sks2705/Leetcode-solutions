class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
     HashMap<String,String>hm = new HashMap<>();
     StringBuilder result=new StringBuilder();
     for(List<String> str:knowledge){
        String key=str.get(0);
        String pair=str.get(1);
        hm.put(key,pair);
     } 
     int i =0;
     while(i<s.length()){
        if(s.charAt(i)=='('){
            int j =i+1;
            while(s.charAt(j)!=')'){
                j++;
            }
            String key=s.substring(i+1,j);
            result.append(hm.getOrDefault(key,"?"));
            i=j+1;
        }
        else{
            result.append(s.charAt(i));
            i++;
        }
     }
     return result.toString();
    }
}