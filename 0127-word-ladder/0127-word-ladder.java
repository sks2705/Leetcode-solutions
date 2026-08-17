class Pair{
    String first;
    int second;
    Pair(String first,int second){
        this.first=first;
        this.second=second;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord,1));
        HashSet<String>hs=new HashSet<>();
        int len=wordList.size();
        for(String s:wordList){
            hs.add(s);
        }
        hs.remove(beginWord);
        while(!q.isEmpty()){
            String word = q.peek().first;
            int steps= q.peek().second;
            q.remove();
            if(word.equals(endWord)){
                return steps;
            }
            for(int i=0;i<word.length();i++){
                for(char ch ='a';ch<='z';ch++){
                    char []replacedArray=word.toCharArray();
                    replacedArray[i]=ch;
                    String replacedWord=new String(replacedArray);
                    if(hs.contains(replacedWord)){
                        hs.remove(replacedWord);
                        q.offer(new Pair(replacedWord,steps+1));
                    }

                }
            }
        }
        return 0;

    }
}