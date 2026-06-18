class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n= nums.length;
        int counta=0;
        int countb=0;
        int a=-1;
        int b=-1;

        for(int i=0;i<n;i++){
            
            if (nums[i]==a) counta++;
            else if (nums[i]==b) countb++;
            else if (counta==0){
                counta=1;
                a=nums[i];
            }
            else if (countb==0){
                countb=1;
                b=nums[i];
            }
            
            else{
                counta--;
                countb--;
            }
        }

        counta=0;
        countb=0;

        for (int j=0;j<n;j++){
           if (nums[j]==a) counta++;
           else if(nums[j]==b)  countb++;
        }

        List<Integer> lis= new ArrayList<>();
        if (counta>(n/3)) lis.add(a);
        if (countb>(n/3)) lis.add(b);

        return lis;
    }
}