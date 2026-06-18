class Solution {
    private boolean check(String s, int minJump, int maxJump) {
        ArrayDeque<Integer>dq= new ArrayDeque<>();
        int n= s.length();
        boolean vis[]= new boolean[n];
        vis[0]=true;
        dq.offer(0);
        int farthestCheck=0;

        while(!dq.isEmpty()){
            int len= dq.size();
            for (int i=0;i<len;i++){
                int u= dq.poll();
                if (u==n-1)  return true;

                int minj= Math.max(farthestCheck,u+minJump);
                int maxj= Math.min(u+maxJump,n-1);
                
                    for (int j=minj;j<=maxj;j++){
                        if (s.charAt(j)=='0' && vis[j]==false){
                            vis[j]=true;
                            dq.offer(j);
                        } 
                    }
                    farthestCheck=maxj+1;
            }
        }

        return false;

    }
    public boolean canReach(String s, int minJump, int maxJump) {
        return check(s,minJump,maxJump);
        
    }
}