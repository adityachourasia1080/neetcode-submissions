class Solution {
    private int[] solve(int[] stones,int l,int h,int alice){
        if (l>h)  return new int[]{0,0};

        StringBuilder str = new StringBuilder();
        str.append(l);
        str.append('#');
        str.append(h);
        str.append('#');
        str.append(alice);
        String temp= str.toString();

        if (mp.containsKey(temp))  return mp.get(temp);
         int sum=0;
        int bestRes[]=null;
        for (int i=l;i<=Math.min(l+2,h);i++){
            sum+=stones[i];
            int ans[]= solve(stones,i+1,h,1-alice);
            int left[]= new int[]{ans[0],ans[1]};

            if (alice==1)  left[0]+=sum;
            else left[1]+=sum;

            if (bestRes==null){
                bestRes= new int[]{left[0],left[1]};
            }
            else{
                if ((alice==1 && left[0]-left[1]> bestRes[0]-bestRes[1]) || (alice==0 && left[1]-left[0]> bestRes[1]-bestRes[0])){
                    bestRes[0]=left[0];
                    bestRes[1]= left[1];
                }
            }
        }

        mp.put(temp,bestRes);
        return bestRes;


    }
    HashMap<String,int []> mp;
    public String stoneGameIII(int[] stoneValue) {
        mp=new HashMap<>();
        int []ans= solve(stoneValue, 0,stoneValue.length-1,1);
        if (ans[0]>ans[1])   return "Alice";
        else if (ans[0]==ans[1])  return "Tie";
        return "Bob";
        
    }
}