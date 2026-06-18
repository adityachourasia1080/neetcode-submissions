class Solution {
    public int[] getOrder(int[][] ti) {
        int n= ti.length;
        int [][]t= new int[n][3];
        for (int i=0;i<n;i++){
            for (int j=0;j<2;j++){
                t[i][j]=ti[i][j];
            }
            t[i][2]=i;
        }

        //sorting based on enque time
        Arrays.sort(t,(a,b)->{
            if (a[0]==b[0])  return Integer.compare(a[1],b[1]);

            return Integer.compare(a[0],b[0]);
        });


        int k=0;
        int currTime=0;
        PriorityQueue<int[]>pq= new PriorityQueue<>((a,b)->{
            if (a[1]==b[1])  return Integer.compare(a[2],b[2]);
            return Integer.compare(a[1],b[1]);
        });

        int ans[]= new int[n];
        int h=0;

        while (k < n || !pq.isEmpty()) {

            // CPU idle → jump time
            if (pq.isEmpty() && k < n) {
                currTime = Math.max(currTime, t[k][0]);
            }

            // add all available tasks
            while (k < n && t[k][0] <= currTime) {
                pq.offer(new int[]{t[k][0], t[k][1], t[k][2]});
                k++;
            }

            int[] temp = pq.poll();
            currTime += temp[1];
            ans[h++] = temp[2];
        }


        return ans;
        
        
    }
}