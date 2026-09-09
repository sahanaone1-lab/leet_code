class Solution {
    public long countCommas(long n) {
        if(n>=1000){
            return n-999;
        }
        if(n>=10000)
        return n-999 +1;
        if(n>=100000)
        return n-999 +1;
        return 0;
    }
}