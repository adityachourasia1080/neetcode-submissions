class Solution {
    public int reverseBits(int n) {
        StringBuilder str= new StringBuilder();
        int cd= 1;
        for (int i=0;i<32;i++){
          if ((n & cd)==1){
            str.append('1');
          }
          else str.append('0');

          n=n>>1;
        }

        int i=0,j=str.length()-1;
        while(i<j){
            Character ch= str.charAt(i);
            str.setCharAt(i,str.charAt(j));
            str.setCharAt(j,ch);
            i++;
            j--;
        }
        System.out.println(str.toString());
        
        long pow=1;
        int ans=0;
        for (i=0;i<32;i++){
            if (str.charAt(i)=='1'){
              ans+=(int)pow;
            }
            pow=pow*2;

        }

        return ans;
        
    }
}
