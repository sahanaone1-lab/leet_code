class Solution {
    public String removeOuterParentheses(String s) {
        /*StringBuilder stc = new StringBuilder();
        int dep = 0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                if(dep >0){
                    stc.append(ch);
                }
                dep++;
            }
            else{
                dep--;
                if(dep>0){
                    stc.append(ch);
                }
            }
        }
        return stc.toString();
        */
        Stack<Character> st = new Stack<>();
        StringBuilder stc = new StringBuilder();
        for(char ch:s.toCharArray()){
            if(ch == '('){
                if(!st.isEmpty()){
                    stc.append(ch);
                }
                st.push(ch);
            }
            else{
                st.pop();
                if(!st.isEmpty()){
                    stc.append(ch);
                }

            }
        }
        return stc.toString();
    }
}