class Solution {

    private void generate(int open,int closed,List<String> lis,StringBuilder str){
        if (open==0 && closed ==0 ){
            lis.add(str.toString());
            return;
        }

        if (open>0){
            str.append('(');
            generate(open-1,closed,lis,str);
            str.deleteCharAt(str.length() - 1);
        }

        if (open<closed){
                str.append(')');
                generate(open,closed-1,lis,str);
                str.deleteCharAt(str.length() - 1);
            }


    }
    public List<String> generateParenthesis(int n) {
       

        List<String> lis= new ArrayList<>();
        StringBuilder str= new StringBuilder();
        generate(n,n,lis,str);

        return lis;
        
    }
}
