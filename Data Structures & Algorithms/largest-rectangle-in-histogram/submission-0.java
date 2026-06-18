class Solution {

    private ArrayList<Integer> nsl(int []h){
        Deque<int[]>dq= new ArrayDeque<>();
        ArrayList<Integer> lis= new ArrayList<>();
        dq.offerLast(new int[]{Integer.MIN_VALUE,-1});
        for (int i=0;i<h.length;i++){
            while(dq.peekLast()[0]>=h[i]){
                dq.pollLast();
            }
            lis.add(dq.peekLast()[1]);
            dq.offerLast(new int[]{h[i],i});
        }

        return lis;
    }

    private ArrayList<Integer> nsr(int []h){
        Deque<int[]>dq= new ArrayDeque<>();
        ArrayList<Integer> lis= new ArrayList<>();
        dq.offerLast(new int[]{Integer.MIN_VALUE,h.length});
        for (int i=h.length-1;i>=0;i--){
            while(dq.peekLast()[0]>=h[i]){
                dq.pollLast();
            }
            lis.add(dq.peekLast()[1]);
            dq.offerLast(new int[]{h[i],i});
        }

        Collections.reverse(lis);
        return lis;
    }
    public int largestRectangleArea(int[] h) {
        int n= h.length;
       
       ArrayList<Integer> left= nsl(h);
       ArrayList<Integer> right= nsr(h);

       int ans=0;
       for (int i=0;i<n;i++){
        
          int temp=  ((right.get(i)-left.get(i))-1)* h[i];
          ans= Math.max(temp,ans);
       }

       return ans;


        
    }
}
