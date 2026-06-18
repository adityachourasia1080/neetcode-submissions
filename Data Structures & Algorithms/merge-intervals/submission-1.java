class Solution {
    public int[][] merge(int[][] it) {

        Arrays.sort(it, ((int[]a,int []b)->{
            if (a[0]==b[0])  return Integer.compare(a[1],b[1]);
            return Integer.compare(a[0],b[0]);
        }));
        List<int[]>lis= new ArrayList<>();
        int start= it[0][0];
        int end= it[0][1];

        for (int i=1;i<it.length;i++){
            if (it[i][0]> end){
                lis.add(new int[]{start,end});
                start= it[i][0];
                end=it[i][1];
            }
            else{
                end= Math.max(end,it[i][1]);
            }
        }
        lis.add(new int[]{start,end});
        return lis.toArray(new int[lis.size()][]);
        
    }
}
