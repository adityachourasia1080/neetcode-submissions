class Solution {
    int x[]={0,1,0,-1};
    int y[]={1,0,-1,0};

    class Trie{
        public Trie arr[];

        public Trie(){
           arr= new Trie[26];
           for (int i=0;i<26;i++) arr[i]=null;
        }
    }

    private void formTrie(Trie head,char[][] b,int i,int j,boolean[][]vis,int maxLen){
        if (maxLen==0)  return ;
        int index= b[i][j]-'a';
        if (head.arr[index]==null){
            Trie temp= new Trie();
            head.arr[index]=temp;
        }
        head= head.arr[index];
        vis[i][j]=true;

        for(int k=0;k<4;k++){
            int nx= i+x[k];
            int ny= j+y[k];
            if (nx<0 || nx>=vis.length || ny<0 || ny>=vis[0].length || vis[nx][ny]) continue;
            formTrie(head,b,nx,ny,vis,maxLen-1);
        }
        vis[i][j]=false;
    }

    private boolean check(String word,Trie head,int index){
       if (index==word.length())  return true;
        int i = word.charAt(index)-'a';
        if (head.arr[i]==null)  return false;
        return check(word,head.arr[i],index+1);
    }

    
    public List<String> findWords(char[][] b, String[] w) {
        List<String> ans = new ArrayList<>();
        int n= b.length;
        int m= b[0].length;
        Trie head= new Trie();
        boolean vis[][]= new boolean[n][m];
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                formTrie(head,b,i,j,vis,10);
            }
        }
        for (int i=0;i<w.length;i++){
            if (check(w[i],head,0))   ans.add(w[i]);
        }
        return ans;
        
    }
}
