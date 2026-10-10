class Solution {
    public String firstPalindrome(String[] words) {
        for(String w:words){
            if(p(w)) return w;
        }     
    return "";  
    }
    public boolean p(String w){
        for(int i=0,j=w.length() -1;i<j;i++,j--){
            if(w.charAt(i)!= w.charAt(j)){
                return false;
            }
        }
return true;
    }
    }