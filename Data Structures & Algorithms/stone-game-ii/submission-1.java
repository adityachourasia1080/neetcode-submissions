class Solution {
    Map<String, int[]> mp;

    private int[] solve(int[] piles, int l, int h, int alice, int m) {
        if (l > h) return new int[]{0, 0};

        StringBuilder str = new StringBuilder();
        str.append(l).append("#").append(h).append("#").append(alice).append("#").append(m);
        String temp = str.toString();

        if (mp.containsKey(temp)) return mp.get(temp);

        int sum = 0;
        int[] bestRes = null;

        for (int i = l; i <= Math.min(l - 1 + 2 * m, h); i++) {
            sum += piles[i];
            int x = i - l + 1;
            int[] ans = solve(piles, i + 1, h, 1 - alice, Math.max(m, x));
            int[] curr = new int[]{ans[0], ans[1]};

            if (alice == 1) curr[0] += sum;
            else curr[1] += sum;

            if (bestRes == null) {
                bestRes = curr;
            } else {
                if (alice == 1 && curr[0] - curr[1] > bestRes[0] - bestRes[1]) bestRes = curr;
                if (alice == 0 && curr[1] - curr[0] > bestRes[1] - bestRes[0]) bestRes = curr;
            }
        }

        mp.put(temp, bestRes);
        return bestRes;
    }

    public int stoneGameII(int[] piles) {
        mp = new HashMap<>();
        int[] ans = solve(piles, 0, piles.length - 1, 1, 1);
        return ans[0];
    }
}