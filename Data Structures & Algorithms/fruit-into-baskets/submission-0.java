class Solution {
    public int totalFruit(int[] f) {

        // Boils down to atmost 2 fruits i need to take
        // sliding window 
        int left=0;
        int right=0;

        int ans=0;
        int n= f.length;
        HashMap<Integer,Integer> mp = new HashMap<>();

        while(right<n){
            mp.put(f[right],mp.getOrDefault(f[right],0)+1);

            while(mp.size()>2){
                mp.put(f[left],mp.get(f[left])-1);

                if (mp.get(f[left])==0)  mp.remove(f[left]);
                left++;
            }

            ans=Math.max(ans,right+1-left);
            right++;

        }

        return ans;
        
    }
}