class Solution {

    private int bs (List<int[]>lis,int l, int no ){
        int index=lis.size();
        int h= lis.size()-1;
        while(l<=h){

            int mid= l+(h-l)/2;
            if (lis.get(mid)[0]>=no){
                index=mid;
                h=mid-1;
            }
            else l=mid+1;
        }
        return index;
    }

    private int maxProfit(List<int[]>lis,int start, Integer memo[]){
        if (start>= lis.size())  return 0;

        if (memo[start]!=null)   return memo[start];
       
        int cx= lis.get(start)[0];
        int cy= lis.get(start)[1];
        int profit= lis.get(start)[2];
         int maxp=profit;

        int nextIndex= bs(lis,start+1,cy);
        for (int i=nextIndex; i<lis.size();i++){
             maxp=Math.max(maxp, maxProfit(lis,i,memo)+profit);
        }

        maxp= Math.max(maxp,maxProfit(lis,start+1,memo));

        memo[start]=maxp;

        return maxp;

    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        List<int[]>lis= new ArrayList<>();
        for (int i=0;i<profit.length;i++){
            lis.add(new int[]{startTime[i],endTime[i],profit[i]});
        }
        
        Collections.sort(lis,(int []a ,int b[])->{
            if (a[0]==b[0])   return Integer.compare(a[1],b[1]);
            return Integer.compare(a[0],b[0]);
        });

        Integer memo[]= new Integer[profit.length+1];
        
        return maxProfit(lis,0, memo);
    }
}