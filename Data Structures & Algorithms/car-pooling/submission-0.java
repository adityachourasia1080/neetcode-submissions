class Solution {
    public boolean carPooling(int[][] trips, int capacity) {

        Arrays.sort(trips,(a,b)->{
            if (a[1]==b[1])  return Integer.compare(a[2],b[2]);
            return Integer.compare(a[1],b[1]);
        });

        Deque<int[]> dq= new ArrayDeque<>();
        int pass=0;

        for (int i=0;i<trips.length;i++){

            while(!dq.isEmpty()){
                int temp[]= dq.peekFirst();
                if (temp[2]<=trips[i][1])  {
                    pass-=temp[0];
                    dq.pollFirst();
                }
                else break;
            }

            dq.offerLast(new int []{trips[i][0],trips[i][1],trips[i][2]});
            pass+=trips[i][0];
            if (pass>capacity)  return false;
        }

        return true;

        
    }
}