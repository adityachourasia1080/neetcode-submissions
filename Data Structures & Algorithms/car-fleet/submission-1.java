class Solution {
    public int carFleet(int target, int[] pos, int[] speed) {

        ArrayList<int[]>lis= new ArrayList<>();
        for (int i=0;i<pos.length;i++){
            lis.add(new int[]{pos[i],speed[i]});
        }
        Collections.sort(lis,(int []a,int b[])->Integer.compare(a[0],b[0]));

        double time = 0.0;
        int carfleet=0;

        for (int i=pos.length-1;i>=0;i--){
            int dis= target-lis.get(i)[0];
            double temp= (double) (dis/  (double)lis.get(i)[1]);
            System.out.println(temp + "pos is " + pos[i]);
            if (temp>time){
                carfleet++;
                time= temp;
            }
        }

        return carfleet;
        
    }
}
