class Trie{
    public HashMap<Character,Trie>mp;
    boolean isend;

    public Trie(){
        mp= new HashMap<>();
        isend=false;
    }
}

    class WordDictionary {
        Trie trie;

    public WordDictionary() {
        trie = new Trie();
    }
    
    public void addWord(String word) {
        Trie temp= trie;
        for (int i=0;i<word.length();i++){
            Character c= word.charAt(i);
            if (!temp.mp.containsKey(c)) temp.mp.put(c,new Trie());
            temp= temp.mp.get(c);
        }
        temp.isend=true;
    }

    public boolean findWord(String word,int index,Trie temp){
        if (index==word.length()&& temp.isend)  return true;
        if (index==word.length() || temp==null)  return false;

        HashMap<Character,Trie> mp= temp.mp;
        if (word.charAt(index)=='.'){
            for (Map.Entry<Character,Trie> e: mp.entrySet()){
                if (findWord(word,index+1,e.getValue()))  return true;
            }
            return false;
        }
        else if (!mp.containsKey(word.charAt(index)))  return false;
        return findWord(word,index+1,mp.get(word.charAt(index)));
    }

    public boolean search(String word) {
        return findWord(word,0,trie);
        
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */