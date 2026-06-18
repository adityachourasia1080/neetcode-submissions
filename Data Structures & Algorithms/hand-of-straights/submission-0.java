class Solution {
    public boolean isNStraightHand(int[] hand, int g) {
        int n= hand.length;
        if ((n%g)!=0)  return false;
        TreeMap<Integer,Integer> mp= new TreeMap<>();

        for (int i=0;i<n;i++) {
            mp.put(hand[i],mp.getOrDefault(hand[i],0)+1);
        }


        while(!mp.isEmpty()){
            Integer first= mp.firstKey();

            for(int i=0;i<g;i++){
                if (!mp.containsKey(first))  return false;
                int value= mp.get(first);
                value--;
                if (value==0) mp.remove(first);
                else mp.put(first,value);

                first++;
            }
        }

        return true;
        
    }
}