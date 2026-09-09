class Solution {
    public long countCommas(long n) {
        if((n>=1000 )&& (n<=9999)){
            return n-999;
        }
        else if((n>=10000) && (n<=99999))
        return n-10000  +1;
        else if((n>=100000) && (n<=999999))
        return n-100000 +1;
        return 0;
    }
}