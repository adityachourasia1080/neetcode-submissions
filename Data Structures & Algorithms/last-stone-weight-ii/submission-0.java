class Solution {

    private List<Integer> findAllSubsetSum(int[] stones,int l,int mid){
        int total= mid+1-l;
        int count= (1<<total);
        List<Integer> lis= new ArrayList<>();
        for (int i=0;i<count;i++){
           int sum=0;

            for (int j=0;j<total;j++){
                if (((i >> j) & 1)==1) {
                    sum+=stones[l+j];
                }   
            }
            lis.add(sum);
        }
        return lis;
    }


    private int bs(List<Integer>right, int sum){
        int l=0,h=right.size()-1;
        int ans=-1;

        while(l<=h){
            int mid=l+(h-l)/2;
            if (right.get(mid)<=sum){
                ans=mid;
                l=mid+1;

            }
            else h=mid-1;
        }

        return ans;
    }

    public int lastStoneWeightII(int[] stones) {

        int l=0,h=stones.length-1;
        int mid=l+(h-l)/2;

        int sum=0;
        for (int i=0;i<=h;i++) sum+=stones[i];
        
        List<Integer>left  =  findAllSubsetSum(stones,l,mid);
        List<Integer>right =  findAllSubsetSum(stones,mid+1,h);

        Collections.sort(right);

        int ans=Integer.MAX_VALUE;
        for(int i=0;i<left.size();i++){

            int curr= left.get(i);
            int index= bs(right,(sum/2)-curr);
            if(index!=-1) {
                int subsetSum= curr+ right.get(index);
                ans=Math.min(ans, Math.abs(sum- (2* subsetSum)));
            }

            if (index+1<right.size()){

                int subsetSum= curr+ right.get(index+1);
                ans=Math.min(ans, Math.abs(sum- (2* subsetSum)));
            }

        }

        return ans;

        
    }
}