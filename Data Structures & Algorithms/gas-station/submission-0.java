class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int prevgas = 0;
        int currgas = 0;
        int index = 0;

        for (int i = 0; i < gas.length; i++) {
            currgas += gas[i] - cost[i];

            if (currgas < 0) {
                prevgas += currgas;
                currgas = 0;        
                index = i + 1;
            }
        }

        if (prevgas + currgas >= 0) return index;
        return -1;
    }
}
