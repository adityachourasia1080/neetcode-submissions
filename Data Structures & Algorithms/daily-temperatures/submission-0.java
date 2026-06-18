class Solution {
    public int[] dailyTemperatures(int[] temp) {
        
        ArrayDeque<int[]> dq= new ArrayDeque<>();
        int len= temp.length;
        int ans[]= new int[len];
        ans[len-1]=0;
        dq.add(new int[]{temp[len-1],len-1});

        for (int i=len-2;i>=0;i--){
          
          while(!dq.isEmpty() && dq.peekLast()[0]<=temp[i]) dq.pollLast();
          if (dq.isEmpty()) ans[i]=0;
          else ans[i]=dq.peekLast()[1]-i;

          dq.add(new int[]{temp[i],i});
        }

        return ans;
        
    }
}