class Solution {

    public String encode(List<String> strs) {
    StringBuilder coded = new StringBuilder();
    for (String str : strs) {
        coded.append(str.length()).append("#").append(str);
    }
    return coded.toString();
}

public List<String> decode(String str) {
    List<String> lis = new ArrayList<>();
    int i = 0;
    
    while (i < str.length()) {
        // Find the '#' delimiter
        int delimiterPos = str.indexOf('#', i);
        
        // Parse the length
        int length = Integer.parseInt(str.substring(i, delimiterPos));
        
        // Extract the string of that length
        i = delimiterPos + 1;
        lis.add(str.substring(i, i + length));
        
        // Move to next encoded string
        i += length;
    }
    
    return lis;
}
}
