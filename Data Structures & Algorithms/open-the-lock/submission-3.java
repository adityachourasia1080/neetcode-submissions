class Solution {
    public int openLock(String[] deadends, String target) {

        // Apprach is simple 
        // i will be using bfs 

        HashSet<String>st= new HashSet<>();
        for (String temp: deadends){
            st.add(temp);
        }

        HashSet<String>vis= new HashSet<>();
        String temp= "0000";
        vis.add(temp);
        if (st.contains(temp))  return -1;
        Deque<String>q= new ArrayDeque<>();
        q.add(temp);
        int count=0;


        while(!q.isEmpty()){
            int len= q.size();
            for (int i=0;i<len;i++){
                StringBuilder ori= new StringBuilder();
                ori.append(q.pollFirst());

                if (ori.toString().equals(target))  return count;
                
                for (int j=0;j<4;j++){

                    StringBuilder up= new StringBuilder(ori);
                    char c= up.charAt(j);
                    if (c=='9') c='0';
                    else c=(char)(c+1);

                    up.setCharAt(j,c);
                    if (!vis.contains(up.toString())){
                        String str= up.toString();
                        if (!st.contains(str)){
                            vis.add(str);
                            q.add(str);
                        }
                    }

                    StringBuilder down = new StringBuilder(ori);
                    c=down.charAt(j);
                    if (c=='0') c='9';
                    else c=(char)(c-1);

                    down.setCharAt(j,c);
                    if (!vis.contains(down.toString())){
                        String str= down.toString();
                        if (!st.contains(str)){
                            vis.add(str);
                            q.add(str);
                        }
                    }

                }
            }
            count++;
        }

        return -1;

        
    }
}