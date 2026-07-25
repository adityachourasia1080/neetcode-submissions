class Solution {


    public int maxEnvelopes(int[][] env) {
     if (env.length == 0) return 0;
     Arrays.sort(env, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
      int ans=1;
     int lis[]= new int[env.length];
     for (int i=0;i<env.length;i++)   lis[i]=1;
     for (int i=0;i<env.length;i++){
        for (int j=0;j<i;j++){
            if (env[i][1]>env[j][1]){
                lis[i]=Math.max(lis[i],lis[j]+1);
                ans=Math.max(ans,lis[i]);
            }
        }
     }


     return ans;

        
    }
}