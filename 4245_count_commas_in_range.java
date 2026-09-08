class Solution {
    public int countCommas(int n) {
        int count =0;
        int temp = n;
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