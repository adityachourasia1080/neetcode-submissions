class Solution {
    class TrieNode{
        TrieNode child[];

        public TrieNode(){
            child= new TrieNode[26];
            for (int i=0;i<26;i++) child[i]=null;
        }
    }

    TrieNode root;
    int x[]={1,0,-1,0};
    int y[]={0,1,0,-1};

    private void insert(char[][]b,int cx,int cy, TrieNode temp,int depth){

         if(depth>10)  return ;
        char ch= b[cx][cy];
        int index= ch-'a';
        b[cx][cy]='#';
        if (temp.child[index]==null)  temp.child[index]= new TrieNode();


        for (int i=0;i<4;i++){
            int nx= cx+x[i];
            int ny= cy+y[i];

            if (nx<0 || nx>=b.length || ny<0 || ny>=b[0].length ||b[nx][ny]=='#') continue;
            insert(b,nx,ny,temp.child[index],depth+1);
        }

        b[cx][cy]=(char)('a'+index);

    }


    private boolean search(String str){

        TrieNode temp= root;

        for (int i=0;i<str.length();i++){
            int index= str.charAt(i)-'a';
            if (temp.child[index]==null)  return false;
            temp= temp.child[index];
        }

        return true;

    }



    public List<String> findWords(char[][] b, String[] words) {

        root= new TrieNode();
        TrieNode temp= root;

        int n= b.length;
        int m= b[0].length;
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                insert(b,i,j,root,0);
            }
        }

        List<String> res= new ArrayList<>();


        for (String str: words){
            if(search(str)==true)  res.add(str);
        }

        return res;
        
    }
}
