class Solution {
    public int addDigits(int num) {
        
        while (num>= 10){
            int sum =0;
            while(num !=0){
            int rev = num%10;
            num = num/10;
            sum +=rev;
            } 
            num =sum;
        }

    return num;   
    }
}