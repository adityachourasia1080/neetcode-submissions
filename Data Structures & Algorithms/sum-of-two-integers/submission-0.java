class Solution {

    // link : https://leetcode.com/problems/sum-of-two-integers/solutions/132479/simple-explanation-on-how-to-arrive-at-t-p0qs/
    public int getSum(int a, int b) {

        while(b!=0){
            int c= a&b; // carry part
            a=a^b;
            b= (c)<<1;
        }

        return a;
        
    }
}