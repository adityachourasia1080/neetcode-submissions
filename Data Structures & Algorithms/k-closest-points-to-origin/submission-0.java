class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int []> pq= new PriorityQueue<>((int []a,int [] b)->Integer.compare(b[0],a[0]));
        for (int i=0;i<points.length;i++){
            int temp= points[i][0]*points[i][0];
            temp+= points[i][1]*points[i][1];

            pq.offer(new int[]{temp,points[i][0],points[i][1]});
            if (pq.size()>k) pq.poll();
        }

        int [][]ans= new int[k][2];
        int count=0;

        while(!pq.isEmpty()){
             int temp[]= pq.poll();
             ans[count][0]=temp[1];
             ans[count++][1]=temp[2];
        }

        return ans;


        

    }
}
