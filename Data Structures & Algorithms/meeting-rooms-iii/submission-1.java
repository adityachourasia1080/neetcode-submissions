class Solution {
    public int mostBooked(int n, int[][] m) {

        Arrays.sort(m, (a,b)->Integer.compare(a[0],b[0]));

        // minheap 
        PriorityQueue<Integer>av= new PriorityQueue<>();
        for (int i=0;i<n;i++) av.offer(i);

        // minheap endTime, room index
        PriorityQueue<int[]>occ= new PriorityQueue<>((int a[],int b[])->{
            if (a[0]==b[0])  return Integer.compare(a[1],b[1]);
            return Integer.compare(a[0],b[0]);
        });


        int count[]= new int[n];

        for (int i=0;i<m.length;i++){
            int start= m[i][0];
            int end= m[i][1];

            while(!occ.isEmpty() && occ.peek()[0]<=start){
                int temp[]=occ.poll();
                av.offer(temp[1]);
            }

            if (!av.isEmpty()){
                int room = av.poll();
                occ.offer(new int[]{end,room});
                count[room]++;
            }
            else
            {
                int temp[]= occ.poll();
                count[temp[1]]++;
                occ.offer(new int[]{ temp[0]+(end-start), temp[1]});
            }
        }

        int max=-1;
        int room=-1;

        for (int i=0;i<n;i++){
            if (count[i]>max){
                max=count[i];
                room=i;
            }
        }

        return room;
        
    }
}