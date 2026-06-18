class Solution {
    public int reverse(int x) {

        boolean neg = x < 0;
        long val = x;

        if (val < 0) {
            val = -val;   // safe now
        }

        StringBuilder str = new StringBuilder(String.valueOf(val));

        int l = 0, r = str.length() - 1;
        while (l < r) {
            char temp = str.charAt(l);
            str.setCharAt(l, str.charAt(r));
            str.setCharAt(r, temp);
            l++;
            r--;
        }

        long k = Long.parseLong(str.toString());
        if (neg) k = -k;

        if (k > Integer.MAX_VALUE || k < Integer.MIN_VALUE)
            return 0;

        return (int) k;
    }
}
