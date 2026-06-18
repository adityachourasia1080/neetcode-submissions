class TimeMap {
    class pair{
        int timestamp;
        String value;
        public pair(int timestamp,String value){
            this.timestamp= timestamp;
            this.value=value;
        }
    }
    HashMap<String,List<pair>>mp;

    public TimeMap() {
        mp= new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!mp.containsKey(key)){
            mp.put(key,new ArrayList<pair>());
        }

        List<pair> temp= mp.get(key);
        temp.add(new pair(timestamp,value));
        mp.put(key,temp);
        
    }
    
    public String get(String key, int timestamp) {
        if (!mp.containsKey(key))  return "";
        List<pair> temp= mp.get(key);

        int l=0,h=temp.size()-1;
        int index=-1;
        while(l<=h){
            int mid= l+(h-l)/2;
            if (temp.get(mid).timestamp<=timestamp){
                index=mid;
                l=mid+1;
            }
            else{
                h=mid-1;
            }
        }
        if (index==-1)  return "";
        return temp.get(index).value;
        
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */