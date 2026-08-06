class Solution {
    public int smallestNumber(int n, int t) {
        for(int i = n;i<=n*t; i++){
            int a = 1;
            int b = i;
            while(b>0){
                a*=b %10;
                b /=10;
            }
            if(a % t == 0){
                return i;
            }

        }
        return n;
    }
}