class Solution {

    public int maxEnvelopes(int[][] env) {
     
     if (env.length == 0) return 0;
     Arrays.sort(env, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
      int ans=1;

      List<Integer> dq= new ArrayList<>();
      dq.add(env[0][1]);
   
     for (int i=1;i<env.length;i++){
        if (dq.get(dq.size()-1)<env[i][1]){
            dq.add(env[i][1]);
            ans= Math.max(ans,dq.size());
        }
        else{
            int l=0,h= dq.size()-1;
            int index=-1;
            while(l<=h){
                int mid= l+(h-l)/2;
                if (dq.get(mid)>=env[i][1]){
                    index=mid;
                    h=mid-1;
                }
                else{
                    l=mid+1;
                }
            }

            dq.set(index,env[i][1]);
        }
        
     }


     return ans;

        
    }
}