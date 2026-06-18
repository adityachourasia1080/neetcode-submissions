class CountSquares {

HashMap<String,int[]> mp;

    private String print(int a,int b){
        StringBuilder str= new StringBuilder();
        str.append(String.valueOf(a));
        str.append('_');
        str.append(String.valueOf(b));
        String key= str.toString();
        return key;
    }

    public CountSquares() {
        mp= new HashMap<>();
    }
    
    public void add(int[] point) {

       String key= print(point[0],point[1]);

        if (mp.containsKey(key)){
            int temp[]= mp.get(key);
            temp[0]++;
            mp.put(key,temp);
        }
        else mp.put(key,new int[]{1,point[0],point[1]});
        
    }
    
    public int count(int[] point) {
    int c = 0;
    int x = point[0], y = point[1];

    for (Map.Entry<String,int[]> e : mp.entrySet()) {
        int[] temp = e.getValue();
        int x1 = temp[1], y1 = temp[2];

        if (x1 == x || y1 == y) continue;
        if (Math.abs(x1 - x) != Math.abs(y1 - y)) continue; 

        String key1 = print(x1, y);
        String key2 = print(x, y1);

        if (mp.containsKey(key1) && mp.containsKey(key2)) {
            c += temp[0] * mp.get(key1)[0] * mp.get(key2)[0];
        }
    }
    return c;
}

}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */