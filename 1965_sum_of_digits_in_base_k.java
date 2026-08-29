class Solution {
    public int sumBase(int n, int k) {
        int sum =0;
        while(n!=0){
        int num = n%k;
        sum +=num;
        n /=k;
        }
        return sum;

    
        
    }
}