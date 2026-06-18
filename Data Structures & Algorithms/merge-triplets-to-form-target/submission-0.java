class Solution {
    public boolean mergeTriplets(int[][] t, int[] target) {
        boolean a=false;
        boolean b=false;
        boolean c=false;

        int n= t.length;
        for (int i=0;i<n;i++){
            if (t[i][0]==target[0] && t[i][1]<=target[1] && t[i][2]<=target[2]){
                a=true;
            }
            if (t[i][0]<=target[0] && t[i][1]==target[1] && t[i][2]<=target[2]){
                b=true;
            }
            if (t[i][0]<=target[0] && t[i][1]<=target[1] && t[i][2]==target[2]){
                c=true;
            }
        }

        if(a && b && c)  return true;
        return false;


    
        
    }
}
