class Solution {
    public int mostWordsFound(String[] s) {
        int count, maxi=0;
        for(int i =0;i< s.length;i++){
            count =1;
            for(int j=0;j<s[i].length();j++){
                if(s[i].charAt(j) == ' ')
                count +=1;
                
            }
            maxi = Math.max(count,maxi);
            
        }
    return maxi;
        
    }
}