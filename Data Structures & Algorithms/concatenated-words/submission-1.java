class Solution {

    private int check(String word, int start, HashSet<String> dict, int[] memo) {
        if (start >= word.length()) return 0;
        if (memo[start] != -2) return memo[start];

        int ans = -1;

        for (int i = start; i < word.length(); i++) {
            String sub = word.substring(start, i + 1);

            if (dict.contains(sub)) {
                int temp = check(word, i + 1, dict, memo);
                if (temp != -1) {
                    ans = temp + 1;
                    break; 
                }
            }
        }

        memo[start] = ans;
        return ans;
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        HashSet<String> dict = new HashSet<>(Arrays.asList(words));
        List<String> ans = new ArrayList<>();

        for (String w : words) {
            int[] memo = new int[w.length() + 1];
            Arrays.fill(memo, -2);
            int count = check(w, 0, dict, memo);
            if (count > 1) ans.add(w);
        }

        return ans;
    }
}