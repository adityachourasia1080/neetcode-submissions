class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String>dead= new HashSet<>(Arrays.asList(deadends));
        HashSet<String>vis= new HashSet<>();
        if (dead.contains("0000")) return -1;
        
        Queue<String> q= new LinkedList<>();
        q.add("0000");
        
        int count=0;
        while(!q.isEmpty())
        {
            int len= q.size();
            
            while(len>0){
                len--;
                String curr= q.poll();
                if (curr.equals(target))  return count;
                vis.add(curr);
                for (int i=0;i<4;i++){
                char arr[]=curr.toCharArray();
                // move up
                    arr[i] = arr[i] == '9' ? '0' : (char)(arr[i] + 1);
                    String up = new String(arr);

                    if (!dead.contains(up) && vis.add(up)) {
                        q.offer(up);
                    }

                    // move down
                    arr = curr.toCharArray();
                    arr[i] = arr[i] == '0' ? '9' : (char)(arr[i] - 1);
                    String down = new String(arr);

                    if (!dead.contains(down) && vis.add(down)) {
                        q.offer(down);
                    }
                }

            }
            count++;
        }

        return -1;
        
    }
}