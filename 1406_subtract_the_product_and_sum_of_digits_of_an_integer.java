class Solution {
    public int subtractProductAndSum(int n) {
        int temp = n;
        int sum=0;
        int mul =1;
        int rev =0;
    
        while(temp !=0){
            mul *= temp %10;
            temp = temp/10;

        }
        sum += mul; 
        while(n !=0){
            rev += n%10;
            n=n/10;
        }
        sum-=rev;
    return sum;    
    }
}