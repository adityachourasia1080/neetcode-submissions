class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        int[][] cars = new int[n][2];

        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        // Sort by position descending
        Arrays.sort(cars, (a, b) -> b[0] - a[0]);

        int fleets = 0;
        double lastTime = -1;

        for (int i = 0; i < n; i++) {
            double time = (target - cars[i][0]) * 1.0 / cars[i][1];

            // If this car takes MORE time, it cannot catch the one ahead → new fleet
            if (time > lastTime) {
                fleets++;
                lastTime = time;
            }
        }
        return fleets;
    }
}
