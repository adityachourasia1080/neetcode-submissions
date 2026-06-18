class Solution {
    private String rev(String num1,String num2){
        if (num1.length()==1 && num1.charAt(0)=='0' 
         || num2.length()==1 && num2.charAt(0)=='0')  return "0";

         int n= num2.length();

          StringBuilder ans= new StringBuilder();
          ans.append(0);
         for (int j=num2.length()-1;j>=0;j--){
            int a= num2.charAt(j)-'0';
            int b=0;
            int rem=0;
            StringBuilder temp= new StringBuilder();
            for (int k=0;k<n-1-j;k++) temp.append(0);
            
            for (int i=num1.length()-1;i>=0;i--){
                b=num1.charAt(i)-'0';
                b=b*a;
                b+=rem;
                rem=b/10;
                b=b%10;
                temp.append(b);
            }
            if (rem!=0) temp.append(rem);
            rem=0;
          
            for (int k=0;k<temp.length();k++){
                  a=0;
                if (k<ans.length()){
                    a+=ans.charAt(k)-'0';
                }
                a+=temp.charAt(k)-'0';
                a+=rem;
                rem=a/10;
                a=a%10;

                if (k<ans.length()){
                    ans.setCharAt(k,String.valueOf(a).charAt(0));
                }
                else ans.append(a);
            }
            if (rem>0) ans.append(rem);
                            
         }


         int i=0,j=ans.length()-1;
         while(i<j){
            char ch= ans.charAt(i);
            ans.setCharAt(i,ans.charAt(j));
            ans.setCharAt(j,ch);
            i++;
            j--;
         }

         return ans.toString();
    }
    public String multiply(String num1, String num2) {
        
        if (num1.length()>num2.length()){
            return rev(num1,num2);
        }
        return rev(num2,num1);


        
    }
}
