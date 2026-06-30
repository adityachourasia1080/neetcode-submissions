class Solution {
    public String simplifyPath(String path) {
        Deque<String> dq= new ArrayDeque<>();
        String curr = ".";
        String parent = "..";
        int i=0;

        while(i<path.length())
        {
            int index= path.indexOf('/',i);
            if (index==-1){
                index= path.length();
            }
            String temp= path.substring(i,index);
            System.out.println(temp);
            if (temp.equals("") ){
                i++;
                continue;
            }

            if (temp.equals(curr)){
                // do nothing
            }
            else if (temp.equals(parent)){
                if (!dq.isEmpty())  dq.pollLast();
            }else{
                System.out.println(temp);
               dq.offerLast(temp);
            }
            i=index+1;
        }

        StringBuilder str= new StringBuilder();
        str.append('/');
        while(!dq.isEmpty()){
            System.out.println(dq.peekFirst());
            str.append(dq.pollFirst());
            if (!dq.isEmpty())  str.append('/');
        }

        return str.toString();
        
    }
}