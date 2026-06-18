class Solution {

    private ArrayList<int[]> merge(List<int[]> lis) {

        ArrayList<int[]> res = new ArrayList<>();

        int start = lis.get(0)[0];
        int end   = lis.get(0)[1];

        for (int j = 1; j < lis.size(); j++) {
            int currStart = lis.get(j)[0];
            int currEnd   = lis.get(j)[1];

            if (currStart <= end) {
                end = Math.max(end, currEnd);
            } else {
                res.add(new int[]{start, end});
                start = currStart;
                end   = currEnd;
            }
        }

        res.add(new int[]{start, end});
        return res;
    }

    public int[][] insert(int[][] it, int[] ni) {

        int n = it.length;
        if (n == 0) return new int[][]{{ni[0], ni[1]}};

        List<int[]> lis = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            lis.add(new int[]{it[i][0], it[i][1]});
        }

       
        lis.add(new int[]{ni[0], ni[1]}); 

        int i = n - 1;
        while (i >= 0 && it[i][0] > ni[0]) {
            lis.set(i + 1, lis.get(i));
            i--;
        }
        lis.set(i + 1, new int[]{ni[0], ni[1]});

      
        ArrayList<int[]> merged = merge(lis);

        int[][] ans = new int[merged.size()][2];
        for (int j = 0; j < merged.size(); j++) {
            ans[j][0] = merged.get(j)[0];
            ans[j][1] = merged.get(j)[1];
        }

        return ans;
    }
}
