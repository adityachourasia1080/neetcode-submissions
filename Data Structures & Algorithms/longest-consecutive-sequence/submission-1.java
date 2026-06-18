class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer>st= new HashSet<>();
        for (int a:nums){st.add(a);}
        if (nums.length==0)  return 0;

      int ans=1;
        for (int a: nums){
            if (st.contains(a+1)) {
                int count=0;
                while(st.contains(a)){
                    count++;
                    a++;
                }
                ans=Math.max(count,ans);
            }
        }

        return ans;
        
    }
}
