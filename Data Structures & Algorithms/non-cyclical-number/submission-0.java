class Solution {
    public boolean isHappy(int n) {
          HashSet<Integer> st= new HashSet<>();
          

          while(n!=1){
            if (st.contains(n))  return false;
            st.add(n);

            int temp= n;
            int sum=0;
             while(temp>0){
                int rem= temp%10;
                 sum+= (rem*rem);
                 temp=temp/10;
             }
             n=sum;
             
          }

          return true;

        
        
    }
}
