class Trie{
    public boolean isend;
    public Trie arr[];
    public Trie(){
        arr= new Trie[26];
        for (int i=0;i<26;i++) arr[i]=null;
        isend=false;
    }
}

class PrefixTree {
    Trie trie;
    public PrefixTree() {
        this.trie= new Trie();
    }

    public void insert(String word) {
        Trie temp= trie;
        for (int i=0;i<word.length();i++){
            int index= word.charAt(i)-'a';
            if (temp.arr[index]==null){
                temp.arr[index]= new Trie();
            }
             temp= temp.arr[index]; 
        }
        temp.isend=true;
    }

    public boolean search(String word) {
        Trie temp = trie;
        for (int i=0;i<word.length();i++){
            int index= word.charAt(i)-'a';
            if (temp.arr[index]==null)  return false;
            temp=temp.arr[index];
        }
        if (temp.isend==true)  return true;
        return false;
    }

    public boolean startsWith(String prefix) {
        Trie temp = trie;
        for (int i=0;i<prefix.length();i++){
            int index= prefix.charAt(i)-'a';
            if (temp.arr[index]==null)  return false;
            temp=temp.arr[index];
        }
        return true;
    }
}
