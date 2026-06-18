class Solution {
    public double myPow(double x, int n) {

        if(n==0)  return 1;
        if (n==-1){
            return (double)(1/x);
        }
        if (n==1)  return x;

        double k= myPow(x,n/2);
        k=k*k;
        if (n%2==0)  return k;
        
        if(n<0){
            double ans= (double)1/x;
            return ans*k;
        }

        return k*x;
        
    }
}
