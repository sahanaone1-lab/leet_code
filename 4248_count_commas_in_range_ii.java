class Solution {
    public long countCommas(long n) {
        int count =0;
        long temp = n;
        while (n > 0) {
           count++;
           n /= 10;
        }
        if(count<=3){
            return 0;
        }
        else if(count>=4){
            return temp - 999;
        }

    return -1;   
        
    }
}