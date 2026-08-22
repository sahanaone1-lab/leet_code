class Solution {
    public int accountBalanceAfterPurchase(int pa) {
        int last = pa % 10;
        if(last >= 5 ){
            pa = pa + (10 - last);
        }else{
            pa -= last ;
        }
    return 100 - pa;
        
    }
}