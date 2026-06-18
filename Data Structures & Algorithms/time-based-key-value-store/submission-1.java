class TimeMap {
    
    Map<String,List<Object[]>> mp;

    public TimeMap() {
        mp= new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {

        mp.putIfAbsent(key, new ArrayList<>());
        mp.get(key).add(new Object[]{value,timestamp});
        
    }

    private String find(List<Object[]> temp,int time){
        int l=0,h= temp.size()-1;
        String ans="";
        while(l<=h){
           int mid=l+(h-l)/2;
           int curr= (int)temp.get(mid)[1];
           if (curr==time)  return (String)temp.get(mid)[0];
           else if (curr>time){
            h=mid-1;
           }
           else{
            l=mid+1;
            ans=(String)temp.get(mid)[0];
           }
        }

        return ans;
    }
    
    public String get(String key, int timestamp) {
         if (!mp.containsKey(key))  return "";
        List<Object[]> temp= mp.get(key);

        return find(temp,timestamp);
        
    }
}
