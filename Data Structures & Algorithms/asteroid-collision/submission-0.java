class Solution {
    public int[] asteroidCollision(int[] arr) {
        int n= arr.length;
        int i=0;
        ArrayDeque<Integer>st= new ArrayDeque<>();
        while(i<n){
            if (st.isEmpty()) st.offerLast(arr[i]);
            else{
                if (!st.isEmpty() && st.peekLast()>0 && arr[i]<0)  //sign change
                {
                    while(!st.isEmpty() && st.peekLast()>0 && Math.abs(arr[i])>st.peekLast()) st.pollLast();


                    if (!st.isEmpty() && Math.abs(arr[i])==st.peekLast()) st.pollLast();
                    else if (st.isEmpty() || (!st.isEmpty() && st.peekLast()<0)) st.offerLast(arr[i]);

                }
                else st.offerLast(arr[i]);
            }
            i++; 
        }

        int ans[]=new int [st.size()];
       int j=0;
        while(!st.isEmpty()){
            ans[j]=st.poll();
            j++;
        }

        return ans;
        
    }
}