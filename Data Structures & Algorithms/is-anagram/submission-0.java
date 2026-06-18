class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())  return false;
        HashMap<Character,Integer> mp = new HashMap<>();

        for (int i=0;i<s.length();i++){
            char c1= s.charAt(i);
            char c2= t.charAt(i);
            mp.put(c1,mp.getOrDefault(c1,0)+1);
            mp.put(c2,mp.getOrDefault(c2,0)-1);

            if (mp.get(c1) != null && mp.get(c1) == 0) mp.remove(c1);
            if (mp.get(c2) != null && mp.get(c2) == 0) mp.remove(c2);

        }

        if (mp.size()==0)  return true;
        return false;

    }
}
