class Solution {
    public int[] plusOne(int[] d) {
        ArrayList<Integer> lis= new ArrayList<>();
        int carry=1;
        for (int i=d.length-1;i>=0;i--){
            int temp= d[i]+carry;
            lis.add(temp%10);
            carry=temp/10;
        }
        if (carry>0) lis.add(carry);

        Collections.reverse(lis);
        int []ans= new int[lis.size()];
        for (int i=0;i<lis.size();i++) ans[i]=lis.get(i);
        return ans;

        
    }
}
