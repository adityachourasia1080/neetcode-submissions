class Solution {

    Map<String,int[]>mp;

    private int []solve(int []piles, int l,int h, Integer alice){
        if (l==h){
            if (alice==1)  return new int[]{piles[l],0};
            return new int[]{0,piles[l]};
        }

        StringBuilder str= new StringBuilder();
        str.append(l);
        str.append("#");
        str.append(h);
        str.append('#');
        str.append(alice);
        String temp= str.toString();
        if (mp.containsKey(temp)){
            return mp.get(temp);
        }

        int [] left= solve(piles,l+1,h,1-alice);
        int [] right= solve(piles, l,h-1,1-alice);
   
        int[] leftRes  = new int[]{left[0], left[1]};
        int[] rightRes = new int[]{right[0], right[1]};

        if (alice == 1) {
            leftRes[0]  += piles[l];
            rightRes[0] += piles[h];
        } else {
            leftRes[1]  += piles[l];
            rightRes[1] += piles[h];
        }

        if (alice == 1) {
            if (leftRes[0]-leftRes[1] > rightRes[0]-rightRes[1]) {
                mp.put(temp, leftRes);
                return leftRes;
            }
            mp.put(temp, rightRes);
            return rightRes;
        }

        if (leftRes[1]-leftRes[0] > rightRes[1]-rightRes[0]) {
            mp.put(temp, leftRes);
            return leftRes;
        }
        mp.put(temp, rightRes);
        return rightRes;

    }
    public boolean stoneGame(int[] piles) {
        mp= new HashMap<>();

        int [] ans= solve(piles, 0, piles.length-1, 1);
        if (ans[0]-ans[1]>0)  return true;
        return false;
        
    }
}