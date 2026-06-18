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
        int c=0;

        for (Map.Entry<String,int[]> e: mp.entrySet()){

          int[]temp=e.getValue();
          if (temp[1]==point[0] || temp[2]==point[1]) continue;

          int x1=temp[1],y=point[1];
          int x=point[0],y1=temp[2];

          String key1= print(x1,y);
          String key2= print(x,y1);

        if (mp.containsKey(key1) && mp.containsKey(key2)){
          c+=(mp.get(key1)[0]*mp.get(key2)[0]*e.getValue()[0]);
        }
        
    }
    return c;
}
}
