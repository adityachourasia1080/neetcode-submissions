class Solution {
    private boolean ispalindrome(String s,int i,int j){
        while(i<j){
            if (s.charAt(i)!=(s.charAt(j)))  return false;
            i++;
            j--;
        }
        return true;
    }
    private void find(String s, int l,int h,List<String> temp,List<List<String>> ans){
        if (l==h){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i=l;i<h;i++){
            if (ispalindrome(s,l,i)){
                temp.add(s.substring(l,i+1));
                find(s,i+1,h,temp,ans);
                temp.remove(temp.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {

        List<List<String>> ans= new ArrayList<>();
        List<String> temp= new ArrayList<>();

        find(s,0,s.length(),temp,ans);
        return ans;
        
    }
}
